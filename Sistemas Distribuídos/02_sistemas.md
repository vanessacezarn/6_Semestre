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

---

<div align="center">

  # Sistemas Distribuídos - SD </div>
- heterogêneo ➜ diferentes arquiteturas de hardware, sistema operacional e linguagens de programação
- fracamente acoplado ➜ distribuídos geograficamente via protocolo do modelo TCP/IP
- GRID computacional
  - pode ter grid computacional de cluster 
- Arquitetura: Cliente-Servidor ou Ponto-a-Ponto
  - tolerância a falhas
  - escalabilidade
  - segurança
  - manutenção/atualização 
- **Objetivo**: compartilhar recursos ➜ processador e memória
  - para o compartilhamento é necessário controlar o sincronismo ➜ gerenciar a seção crítica
    - relógio: lógico (todo mundo recebe o mesmo horário, Microsoft) e físico (cada servidor tem seu próprio horário, os nanosegundos podem mudar)
    - exclusão mútua ➜ bloqueia a seção até finalizar o processo
- SD são fortemente dependente do SO
  - gestor de processamento, gestor das camadas de serviço, gestor de comuniacação
  - se o SO não é muito bom a gestão dos SD fica ruim de realizar
- SD, na sua essência, tem comunicação via **SOCKET** que é bloqueante ➜ solução computacional em tempo de programação é THREADS
  - socket ➜ ip, porta, máscara, objetos escritores/leitores
    - escritor = write = output = sender
    - leitor = reader = input = receiver 
- características básicas:
---
### Programação multitarefa - THREAD
- miniprocesos dentro de um processo
- pode ser:
  -  com memória compartilhada (= seção crítica)
    - sincronismo: monitor, semáforo
  - sem memória compartilhada
- importância ➜ execução de processo concomitantes






