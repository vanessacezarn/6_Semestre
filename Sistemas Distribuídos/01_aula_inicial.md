# Sistemas Distribuídos
### ➤ Competências da disciplina
 ➥ Unidade 1: Fundamentos em Sistemas Distribuídos

 ➥ Unidade 2: Comunicação em Sistemas Distribuídos
 
 ➥ Unidade 3: Comunicação em grupo
 
 ➥ Unidade 4: Sistemas de Arquivos Distribuídos e Memória Compartilhada Distribuída
 
---
### ➤ orientações para o semestre:
- códigos
  - todos deveram ser orientados a objetos
  - documentação (javadocs)
  - modelo MVC
  - linguagem principal: java 
---
### ➤ revisão de conceitos
#### ➥ Arquitetura de Sistemas
1) cliente-servidor
   - modelo TCP-IP: prático X teórico
     - prático: 4 camadas ➜  aplicação, transporte, internet, rede
     - teórico: OSI ➜  7 camadas
     - ```mermaid
          graph LR;
            A----> Servidor;
            Servidor----> B;
        ```
      
2) ponto-a-ponto
   - modelo TCP-IP
   - receber = receive = read ➜  deseralização
   - enviar = send = write ➜ serializar
     - por byte, string ou objetos  
   - comunicação sem API e Framework tem que saber IP, porta e método
   -  ```mermaid
        graph LR;
          A----> B;
      ```

#### ➥ Thread
- utilizada para sair de comunicação bloqueante (leitura e escrita)
- programação concomitante
- processo dentro de um processo
- miniprocessos: (*obrigatórios)
  - *id
  - *memória + cpu
  - *tempo de vida
  - *pai (quem disparou (se o pai é encerrado, os filhos são encerrados))
  -  nome
- possui as operações de:
  - declarar e envelopar
  - iniciar
  - pausar
  - reiniciar
  - finalizar ou matar
- thread com compartilhamento de memória:
  - seção crítica
  - bloqueio ➜ técnica para gerenciamento da seção crítica
    - monitor
    - semáforo
    - deadlock    
---
# Sistemas Paralelos
- fortemente acoplados: fixos em um mesmo lugar via protocolos de modelo TCP/IP: endereço de rede, porta lógica, máscara de rede e protocolos de transporte
- homogêneo: arquitetura de hardware, sistema operacional e linguagens de programação idênticas de rede
- cluster computacional
  - cluster != grid
- arquitetura: Ponto-a-Ponto
  - tolerância a falhas: se um ponto falhar o sistema consegue detectar
  - escalabilidade
  - segurança
  - manutenção/atualização
- objetivo: compartilhar recursos (processador e memória)
- vai ser estudado mais em programação paralela
