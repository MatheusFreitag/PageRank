import java.io._

val iters = 20   // sets iteration from argument (in our case iter=20)
val lines = spark.read.textFile("smallgraph.txt").rdd   // read text file into Dataset[String] -> RDD1
val pairs = lines.map{ s =>
	val parts = s.split("\\s+")               // Splits a line into an array of 2 elements according space(s)
		(parts(0), parts(1))                 // create the parts<url, url> for each line in the file
    }
val links = pairs.distinct().groupByKey().cache()   // RDD1 <string, string> -> RDD2<string, iterable>  




var ranks = links.mapValues(v => 1.0)    // create the ranks <key,one> RDD from the links <key, Iter> RDD




for (i <- 1 to iters) {
	val contribs = links.join(ranks)         // join  -> RDD1
        .values                           // extract values from RDD1 -> RDD2          
        .flatMap{ case (urls, rank) =>    // RDD2 -> conbrib RDD
            val size = urls.size        
            urls.map(url => (url, rank / size))   // the ranks are distributed equally amongs the various URLs
        }
	ranks = contribs.reduceByKey(_ + _).mapValues(0.15 + 0.85 * _) // ranks RDD
}

val file = "smalloutput.txt"
val writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))
for (x <- ranks.collect) {
  writer.write(x + "\n")  // however you want to format it
}
writer.close()
