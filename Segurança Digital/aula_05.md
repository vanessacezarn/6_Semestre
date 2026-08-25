---
# Atividades slides
### Mini shell 

1. Criar um diretório chamado recon
    ```
      mkdir recon
    ```
2. Entrar nesse repositorio
     ```
      cd recon
     ```
4. Roda um scan com nmap salvando a saída em um arquivo
     ```
      sudo nmap -sS -T4 -oN arquivo.txt scanme.nmap.org
     ```
6. filtra e imprimir só as linhas com portas abertas usando grep
     ```
      grep open arquivo.txt
    ```
    
### Exercícios
1. diferencie caminho absoluto e caminho relativo, com um exemplo de cada
2. o que significa a permissão rwxr-xr-- em notação octal?
- rwx = o dono tem permissão para ler, escrever e executar
- r-x = o grupo tem permissão para ler e executar
- r-- = os demais usuários tem permissão para ler
3. Por que o comando nmap -sS exige sudo, mas o nmap -sT não?
