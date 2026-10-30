# RPC e RMI

## RPC (Remote Procedure Call)

RPC, ou **Chamada de Procedimento Remoto**, é uma tecnologia de comunicação utilizada em sistemas distribuídos que permite a um programa solicitar a execução de um procedimento em outro computador, de maneira semelhante a uma chamada local. O objetivo é abstrair parte dos detalhes de comunicação pela rede.

### Funcionamento

1.  O cliente envia ao servidor uma solicitação com o procedimento
    desejado e seus parâmetros.
2.  O servidor recebe a mensagem, interpreta os parâmetros e executa o
    procedimento.
3.  O servidor envia uma resposta com o resultado.
4.  O cliente recebe a resposta e continua sua execução.

O RPC segue, geralmente, a arquitetura **cliente-servidor** e depende de um protocolo de transporte, como TCP ou UDP. Sua implementação envolve conceitos como sockets, threads e serialização de dados ou objetos.

### Características

-   **Abstração:** simplifica a comunicação entre processos distribuídos, aproximando a chamada remota de uma chamada local.
-   **Comunicação:** os dados e parâmetros são transmitidos pela rede, e a resposta retorna ao cliente.
-   **Sincronismo:** em uma chamada síncrona, o cliente aguarda a resposta; implementações também podem adotar comunicação assíncrona ou concorrente.
-   **Independência de detalhes de rede:** a tecnologia procura ocultar do programador parte da complexidade da comunicação e das diferenças entre máquinas.


- **Vantagens** 
    - Facilita o desenvolvimento de sistemas distribuídos. 
    - Torna a interação entre cliente e servidor mais simples. 
    - Permite transferir parte do processamento para servidores. 
    - Pode reduzir a necessidade de reescrever funcionalidades.

- **Limitações** 
    - Existem diferentes implementações, que nem sempre são compatíveis entre si. 
    - A comunicação está sujeita a atrasos e falhas de rede.
    - A abstração oferecida pode ter custo de desempenho em comparação com a comunicação direta por sockets.

## RMI (Remote Method Invocation)

RMI, ou **Invocação de Método Remoto**, é uma API do Java que permite que um objeto invoque métodos de outro objeto que está sendo executado em outra JVM (*Java Virtual Machine*). É um mecanismo para desenvolver aplicações distribuídas orientadas a objetos.

### Características

-   **Orientação a objetos:** a unidade de invocação é um método pertencente a um objeto remoto.
-   **Execução remota:** o objeto chamado pode estar em outra JVM, possivelmente em outro computador.
-   **Abstração da comunicação:** permite invocar métodos remotos semlidar diretamente com todos os detalhes de rede.
-   **Aplicação em Java:** é voltado à comunicação entre objetos em aplicações Java distribuídas.

### Estrutura do RMI:

| Parte | Responsabilidade |
|---|---|
| **Interface** | Define os métodos remotos (o "contrato") |
| **Classe** | Implementa a interface |
| **Servidor** | Cria o objeto e o registra para acesso remoto |
| **Cliente** | Localiza o objeto remoto e chama seus métodos |



### Diferença entre RPC e RMI

  |Aspecto|  RPC | RMI|
  |:----:|:-----:|:----:|
  Unidade de invocação |   Procedimento ou função | Método de um objeto
  Abordagem   |    Chamada remota de procedimentos  |   Invocação remota orientada a objetos              
  Linguaguem | Python  |  API do Java                               
  Objetivo |Solicitar a execução de um procedimento em outro processo | Invocar métodos de objetos executados em outra JVM                                     
  

