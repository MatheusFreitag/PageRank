# PageRank para IPPD 2017/2

### Estrutura dos Arquivos e descrições

```bash
.root
│
├── 📄geradorDeGrafos.py //Script que gera os grafos a partir dos datasets
│
├── 📂graphs //Grafos gerados para alimentar o PageRank               
│   ├── 📄lessbiggraph.txt         
│   ├── 📄mediumgraph.txt  
│   ├── 📄lessmediumgraph.txt 
│   └── 📄smallgraph.txt                
│
├── 📂Analises //Imagens mostrando os reports do Spark
│   ├── 📄lessbig.png        
│   ├── 📄medium.png 
│   ├── 📄lessmedium.png
│   └── 📄small.png
│
├── 📂outputs //PageRanks das paginas após o algoritmo rodar
│   ├── 📄lessbigoutput.txt         
│   ├── 📄mediumoutput.txt  
│   ├── 📄lessmediumoutput.txt 
│   └── 📄smalloutput.txt  
│
├── 📂datasets //Lista de sites para gerar os grafos
│   ├── 📄lessbig.txt         
│   ├── 📄medium.txt  
│   ├── 📄lessmedium.txt 
│   └── 📄small.txt 
│
└── 📂scripts //Scripts de PageRank modularisados para cada dataset
    ├── 📄lessbig.scala        
    ├── 📄medium.scala
    ├── 📄lessmedium.scala
    └── 📄small.scala
```

