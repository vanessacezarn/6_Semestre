# Socket

## Comunicação em sistemas distribuídos

A **comunicação entre máquinas** é um dos principais focos dos sistemas distribuídos

Em um sistema distribuído, diferentes computadores podem se comunicar e compartilhar recursos, como: memória; processador; GPU;arquivos e dados;serviços.

Para que essa comunicação aconteça, são utilizados mecanismos e protocolos de comunicação em rede.

## O que é um Socket?

- É uma interface/recurso de comunicação que permite que aplicações troquem dados através de uma rede.
   - estrutura lógica para computadores se comunicarem
- Ele funciona como um **ponto de comunicação entre processos**, podendo estar em máquinas diferentes ou, em alguns casos, na mesma máquina.
   - Portanto, é mais correto dizer que o socket **permite a comunicação entre processos**, e não simplesmente que "conecta duas máquinas".

- O socket normalmente está associado a um endereço IP e uma porta
- Os sockets são muito utilizados na implementação da arquitetura cliente-servidor.

## Tipos de Comunicação
### Em relação ao sincronismo
- Síncrona ➜ TCP-IP ➜ 'tem que assistir no momento'
   - bloqueante ➜ espera a confirmação
   - buffer ➜ pode ler texto, arquivo e socket e também pode ser usado como memória transitória
- Assíncrona ➜ UDP ➜ 'ler, respoder, assistir a hora que quiser'
   - não bloqueante
- tratamento de sincronismo: semáforo ou monitor
### Em relação a persistência
- Transiente: mensagem só é enviada se o destinatário estiver ligado/online ➜ destinatário precisa existir
- Persistente: mensagem é enviada mesmo com o destinário desligado ➜ tem que ir para disco/arquivo
   - arquitetura Cliente-Servidor

## Sockets e cliente-servidor

### Servidor

1. disponibiliza um serviço;
2. associa-se a uma porta;
3. fica aguardando conexões;
4. recebe clientes;
5. realiza o processamento;
6. envia uma resposta;
7. pode encerrar a conexão ou continuar atendendo outros clientes.

### Cliente
1. conhece o endereço do servidor;
2. solicita uma conexão;
3. envia dados ou requisições;
4. recebe respostas;
5. encerra a conexão quando necessário.

---

### Socket em Java

Em Java, a comunicação TCP pode ser implementada principalmente utilizando:

- `ServerSocket`;
- `Socket`;
- `InputStream`;
- `OutputStream`.

### Servidor

O servidor TCP normalmente utiliza: `ServerSocket` para aguardar conexões em uma determinada porta

- Quando um cliente se conecta, o servidor utiliza: accept() para aceitar a conexão.
  - O resultado do accept() é um: `Socket` que representa a conexão estabelecida com aquele cliente.

- A partir desse socket, o servidor pode obter os fluxos de entrada e saída para receber e enviar dados.
   - Streams: são utilizados para comunicação através do socket:
      - `InputStream` → entrada de dados;
      - `OutputStream` → saída de dados.

#### Fluxo simplificado

```text
ServerSocket
     ↓
   accept()
     ↓
  Socket
   ↙   ↘
Input  Output
```

### Cliente em Java

O cliente normalmente cria um `Socket informando o endereço do servidor e a porta. E depois, utiliza os fluxos de entrada e saída para se comunicar.

```text
Cliente
  ↓
Socket
 ↙   ↘
Input Output
  ↓     ↓
ler   escrever
```

---

## Threads e sockets

Em uma aplicação que atende vários clientes, é comum utilizar **threads**.

```text
Servidor
   │
   ├── Cliente 1 → Thread 1
   ├── Cliente 2 → Thread 2
   └── Cliente 3 → Thread 3
```

- Isso permite que o servidor trate diferentes clientes concorrentemente.
   - Assim, o processamento de um cliente não precisa impedir o atendimento dos demais.

- **Threads podem ser utilizadas para permitir que o servidor atenda múltiplas conexões concorrentemente, evitando que o processamento de um cliente impeça o atendimento dos demais.**

---

##  Sockets como recurso de baixo nível

Socket pode ser considerado um **recurso de baixo nível** quando comparado a mecanismos de comunicação de mais alto nível.

Com sockets, o programador precisa lidar diretamente com aspectos como:

- endereço IP;
- portas;
- conexões;
- envio e recebimento de dados;
- fluxo de entrada e saída;
- encerramento de conexões;
- concorrência;
- tratamento de erros.

Por isso, sockets oferecem bastante controle, mas exigem mais trabalho do programador.

---
