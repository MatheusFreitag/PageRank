import random

sites = open("<nomeDoDataset>.txt").readlines()

with open("<arquivoParaGrafo>.txt", "w") as text_file:
    key = ""
    for i in range(len(sites)):
        tamanhoDeOutgoingLinks =  random.randint(1,10)
        for j in range(tamanhoDeOutgoingLinks):
            siteAleatorio = random.randint(1,len(sites)-1)
            key = str(sites[i]).strip() + ' ' + str(sites[siteAleatorio]).strip() + "\n"
            text_file.write(key)
            key = ""
        key = ""