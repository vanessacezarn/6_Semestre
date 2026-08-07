### Divisão e Conquista: Soma de Sublistas

 Contexto: O processamento de grandes volumes de dados numéricos.

 Problema: Dado um vetor ou lista com 10.000 números inteiros aleatórios, divida essa lista em 4 partes iguais.

 Ação: Crie 4 threads. Cada thread recebe apenas uma das partes como parâmetro de entrada, calcula a soma dos elementos dessa sublista e retorna o valor final.

 Encerramento: A thread principal aguarda o fim das 4 threads, coleta as 4 somas parciais e calcula a soma total.
