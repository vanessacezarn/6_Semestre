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
- caminho absoluto: indica a localização de um arquivo/diretório a partir da raiz do sistema de arquivos
     - exemplo: /home/vanessa/seguranca_digital/aula05.md
- caminho relativo: localização do arquivo/diretório a partir do diretório atual
     - exemplo: seguranca_digital/aula05.md

2. o que significa a permissão rwxr-xr-- em notação octal?
- em notação octal: 754
     - 7: o dono tem todas as permissões r(4) + w(2) + x(1)
     - 5: grupo tem  as permissões r(4) + x(1)
     - 4: outros tem apenas a permissão r(4)

3. Por que o comando nmap -sS exige sudo, mas o nmap -sT não?
- nmap -sS realiza varreduras SYN que requerem privilégios
- nmao -sT não exige privilégio pois utiliza chamadas de socket

4. reescreva nmap alvo > saida.txt usando a flag nativa do próprio Nmap
```
 nmap -oN saida.txt 
```


5. cite dois comandos de rede vistos hoje e o que cada um revela sobre um host
- lista as portas e conexões abertas localmente
```
ss -tuln 
```
- concecta manualmente a um serviço
```
nc host porta 
```

6. qual a diferença prática entre sudo comando e su -?
- sudo: eleva o privilégio apenas para um comando
- su - : troca toda a sessão para outro usuário

7. escreva um comando find que procure, a partir de /, arquivos com bit SUID.
```
find / perm -4000 2>/dev/null
```