<div align="center">

  # Sistemas Distribuídos - SD </div>
- heterogêneo ➜ diferentes arquiteturas de hardware, sistema operacional e linguagens de programação
- fracamente acoplado ➜ distribuídos geograficamente via protocolo do modelo TCP/IP
  - TCP/IP ➜ endereço de rede, porta lógica, máscara de rede e proteção de transporte

- GRID computacional: modelo de computação distribuída que interconecta computadores heterogêneos e geograficamente distantes para funcionarem como um único supercomputador virtual
  - pode ter grid computacional de cluster:  conecta clusters inteiros espalhados pelo mundo
    - cluster: é um sistema que interconecta vários computadores em uma rede local para funcionarem de forma coordenada como uma única máquina de alto desempenho 

- Arquitetura: Cliente-Servidor ou Ponto-a-Ponto
  - tolerância a falhas ➜ sistema que consegue operar mesmo com defeitos em seu hardware ou software
    - cliente-servidor ➜ ponto de falha mais crítico é o próprio servidor ➜ solução: vários servidores (custo elevado)  
  - escalabilidade ➜ capacidade de um sistema lidar com uma carga de trabalho crescente através do aumento de recursos, resultando em maior poder computacional
    - vertical: adicionar recursos (CPU, RAM, disco) ao servidor ➜ tem que parar o servidor ou desviar seu tráfego
    - horizontal: adicionar novos servidores ao sistema, distribuindo a carga de trabalho
  - segurança
  - manutenção/atualização 

- **Objetivo**: compartilhar recursos ➜ processador e memória
  - para o compartilhamento é necessário controlar o sincronismo ➜ gerenciar a seção crítica
    - relógio: lógico (todo mundo recebe o mesmo horário, Microsoft) e físico (cada servidor tem seu próprio horário, os nanosegundos podem mudar)
    - exclusão mútua ➜ bloqueia a seção até finalizar o processo

- SD são fortemente dependente do SO:
  - gestor de processamento, gestor das camadas de serviço, gestor de comuniacação
  - se o SO não é muito bom, a gestão dos SD fica ruim de realizar
  
- SD, na sua essência, tem comunicação via **SOCKET** que é bloqueante ➜ solução computacional em tempo de programação é THREADS
  - socket ➜ ip, porta, máscara, objetos escritores/leitores
    - escritor = write = output = sender
    - leitor = reader = input = receiver 
---
### Programação multitarefa - THREAD
- miniprocesos dentro de um processo
- pode ser:
  -  com memória compartilhada (= seção crítica)
    - sincronismo: monitor, semáforo
  - sem memória compartilhada
- importância ➜ execução de processo concomitantes






