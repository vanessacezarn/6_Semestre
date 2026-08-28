# Revisão para 1º prova de SD
### 1) O que é sistema distribuido? Características e Objetivos

é um conjunto de computadores independentes que trabalham juntos como se fossem um único sistema, comunicando-se por meio de uma rede para compartilhar dados, processamento e recursos

- são sistemas heterogêneos ➜ compostos por diferentes computadores, cada qual com sua arquiteturas de hardware, sistema operacional e linguagens de programação
- fracamente acoplados ➜ espalhados geograficamente via protocolo TCP-IP
- grid computacional ➜ modelo de computação distribuída que interconecta computadores heterogêneos e geograficamente distantes para funcionarem como um único supercomputador virtual
- **objetivo** ➜ compartilhar recursos e distribuir tarefas entre diferentes computadores, buscando melhorar o desempenho, disponibilidade, escalabilidade e utilização dos recursos
    - principais recursos compartilhados: disco, placa gráfica, memória e processador
    - principal operação no compartilhamento de recusos é a **comunicação**
    - para que ocorra compartilhamento é necessário controlar o sincronismo
- são fortemente dependentes do sistema operacional
- na sua essência possui comunicação via socket (bloqueante)
    - solução threads
- arquitetura pode ser cliente-servidor, ponto-a-ponto ou híbrida
- escalabilidade ➜ é possível adicionar mais computadores para atender a um número maior de usuários
    - vertical: melhorar recursos de hardware (para todo o sistema para fazer o upgrade)
    - horizontal: adicionar mas máquinas ou servidores ao sistema para dividir a carga
- tolerância a falhas ➜ se um computador falhar, outro pode assumir sua função, aumentando a disponibilidade.
---
### 2) O que é GRID e CLUSTER? 
- GRID
    - sistema que conecta vários computadores em uma rede para atuar como supercomputador
    - pode existir grid computacional de cluster ➜ conecta vários cluster espalhados pelo mundo
    - conecta computadores espalhados geograficamente
    - hardware geralmente diferentes
    - Compartilhar recursos distribuídos
- Cluster
    - conjunto de computadores interconectados, geralmente próximos fisicamente e com características semelhantes, que trabalham de forma coordenada para executar tarefas, proporcionando maior desempenho, disponibilidade ou balanceamento de carga.
    - geralmente hardware semelhantes
    - normalmente envolve uma única organização
    - trabalhar como um sistema de alto desempenho/disponibilidade
--- 
### 3) Programação Concomitante X Programação Paralela
- programação concomitante/concorrente
    - várias tarefas progredindo de forma intercalada, não necessariamente estão sendo executadas ao mesmo tempo
    - **um processador alterna** entre as tarefas
    - Concorrente: várias tarefas podem estar em andamento no mesmo período, alternando ou executando simultaneamente.
    - Concomitante: algo que ocorre ao mesmo tempo ou durante o mesmo intervalo
- programação paralela
    - várias tarefas são executadas simultaneamente
    - utilia **vários processadores**
    - dividi uma tarefa em partes que podem ser executadas ao mesmo tempo

--- 
### 4) Comunicação entre computadores e equipamentos em sistemas distribuídos
- comunicação distribuída ➜ troca de informações, via rede, entre as máquinas que estão fisicamente separadas mas estão conectadas a uma rede
    - permite que processos rodando em máquinas diferentes se comuniquem, coordenem ações, compartilhem dados e cooperem para realizar tarefas maiores
    - ocorre atráves de troca de mensagens usando protocolos de rede
- Modelo TCP-IP: conjunto de protocolo utilizado para permitir a comunicação entre dispositivos em uma rede
    - endereço ip: identifica um dispositivo na rede
    - porta: identifica um processo/serviço dentro de um dispositivo ➜ permite que vários serviços utilizem a mesma máquina
    - mascára de rede: determina qual do endereço IP representa a rede e qual representa o host
    - socket: ponto de comunicação utilizado por uma aplicação ➜ de forma simplificada é a combinação entre endereço IP, porta e protocolo de transporte
    - camada de transporte: responsável pela comunicação entre os processos
        - TCP 
            - orientado à conexão ➜ garante a entrega e ordem dos dos dados
            - confiável ➜ realiza controle de fluxo e retransmissão em caso de perda
        - UDP
            - não orientada à conexão ➜ não garante ordem nem entrega
- Arquiteturas:
    - ponto a ponto
        - descentralizada
            - 'nós' possuem papéis semelhantes ➜ podem atuar tanto como cliente tanto como servidor
                - podem solicitar e fornecer recursos para outros nós
        - comunicação direta entre pares
        - escalabilidade: altamente escalável visto que cada nó contribui com recursos
        - tolherância a falhas: se um nó falhar o sistema segue funcionando
        - maior complexidade de gerenciamento
            - cada nó precisa ser atualizado individualmente
    - cliente servidor
        - centralizada:
            - servidor: responsável por fornecer serviços, dados ou recursos
                - atendem, controlam e gerenciam as requisões de clientes
            - cliente: máquinas que solicitam serviços ou recursos aos servidores
        - comunicação ➜ cliente pede e servidor responde
        - fácil controle e administração centralizada
        - dependência: se o servidor falhar, clientes ficam sem acesso ao serviço
        - escalabilidade limita pelo servidor
- Comunicação Bloqueante:
    - processo ou thread fica suspenso aguardando a conclusão de uma operação de comunicação, como o envio ou recebimento de uma mensagem, antes de continuar sua execução.

---
### 5) Sincronismo: 
- mecanismo que permite a coordenação entre diferentes máquinas, apesar delas estarem separadas e se comunicarem via rede
- é necessária para que processos executem concorrentemente

- para que serve:
    - evitar conflitos de dados ➜ controlar o acesso a recursos compartilhados
    - garantir a ordem correta dos eventos
    - manter a consistência dos dados
    - escrita sempre tem precedência sobre leitura
    - coordenar a execução de processos
- em java
    - syncronized: permite controlar o acesso de múltiplas threads a um trecho de código ou método
        - enquanto um thread estiver executando esse método, outra thread não poderá executar simultaneamente o mesmo método
    - lock: controle mais explícito da exclusão mútua

- em python ➜ threading para controlar a execução concorrente
    - lock ➜ garante a exclusão mútua permitindo que apenas uma thread por vez acesse a seção crítica
- via relógio ➜ sincronismo temporal (não existe um relógio global perfeitamente sincronizado)
    - utilizado para estabelecer uma ordem temporal dos eventos entre as diferentes máquinas
    - físico: tenta representar o tempo real ➜ relógios físicos das máquinas sincronizados
    - lógico: objetivo principal é a ordem dos eventos
- exclusão mútua: mecanismo que garante que apenas um processo por vez possa acessar uma determinada região crítica ou recurso compartilhado
    - lock ➜ sincronismo de ação (espera uma resposta, barreiras,...)
    - eleição ➜ mecanismo para escolher um 'líder' entre os processos de um SD
--- 

### 6) Thread: o que é e utilização?
- utilizada para desbloquear a comunicação
- mini processos dentro de processos para realizar tarefas ou rotinas de forma concomitante
- unidade em execução dentro de um processo (instância independente de um programa em execução)
    - compartilham o mesmo espaço de memória e recursos
- circundam tarefas para que essas executem concomitantemente
- cada thread possui seu contador de programa, registrador e pilha
- sem memória compartilhada ➜ sem seção crítica
    - cada thread recebe parâmetros próprios
    - variáveis não são acessadas em comum ➜ não necessitam de sincronização
- com memória compartilhada
    - 2 ou + thread acessam a mesma estrutura de dados
    - necessita de sincronização
    - em alguns casos é mais eficiente
- delegar rotina
- linguagens:
    - java: nativa
        - extends class Thread ➜ sem memória compartilhada
        - implements Runnable ➜ com memória compartilhada
        - suporta syncronized, semaphore, lock
        - exemplo de uso: um servidor receber 'n' clientes, cada cliente é tratado por uma thread
    - python: threading
        - lock: protege a seção crítica para que apenas uma thread a acesse por vez
---
### 7) Pool de Threads
- o que é: conjunto de thread previamente criadas e mantidas disponíveis para executar tarefas
    - tarefas são entregues para as threads disponíveis no pool
- para que serve:
    - evita a criação e destruição constante de threads
    - controla a quantidade de threads executando simultaneamente
    - tarefa é adiciona a uma fila ➜ thread disponível pega a tarefa ➜ executa a tarefa ➜ ao terminar a thread retorna para ao pool e pode executar outra tarefa
- utilização: quando a aplicação recebe muitas tarefas ou requisões simultâneas