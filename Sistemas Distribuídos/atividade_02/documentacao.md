# Documentação da Resolução da Atividade

## Estrutura adotada - MVC
```text
src/
│
├── Model/
│   └── Pessoa.java
│
├── Controller/
│   └── ClienteController.java
│
├── View/
│   ├── ClienteInterface.java
│   └── ServidorInterface.java
│
└── Server/
    ├── Servidor.java
    └── ClienteThread.java
```
### Model
classe responsável pela representação dos dados do sistema ➜ Pessoa

- implementa Serializable ➜ permite que objetos Pessoa sejam enviados e recebidos pela rede utilizando ObjectOutputStream e ObjectInputStream
### View
interfaces gráficas da aplicação

- ServidorInterface ➜ inicia o servidor, acompanha os registros de log e visualiza as pessoas cadastradas
- ClienteInterface ➜ usuário pode cadastrar e visualizar os dados

### Controller
realiza a intermediação entre a interface gráfica do cliente e a comunicação com o servidor

- realizar as operações necessárias para:

1. estabelecer a conexão com o servidor;
2. enviar os dados da pessoa;
3. receber o objeto processado pelo servidor;
4. disponibilizar o resultado para a interface do cliente.


### Server
contém as classes relacionadas à comunicação e ao atendimento dos clientes

- Servidor ➜ aguarda novas conexões TCP e cria um ClienteThread para cada cliente que se conecta
- ClienteThread ➜ processamento de uma conexão

- O fluxo básico de conexão é:

```text
Cliente
   │
   │ conexão TCP
   ▼
Servidor
   │
   │ accept()
   ▼
ClienteThread
```
---
### ClienteThread
- A thread recebe:
    - o Socket do cliente;
    - a lista compartilhada de pessoas;
    - uma referência para a ServidorInterface.

- A thread recebe o objeto enviado pelo cliente utilizando: ObjectInputStream e Pessoa pessoa = (Pessoa) entrada.readObject();

- Antes de adicionar a pessoa à lista, é realizada uma verificação: lista.contains(pessoa)
    - Caso a pessoa já esteja cadastrada, o objeto existente é localizado e não ocorre uma nova inserção.
- Para uma pessoa nova, o servidor gera automaticamente o e-mail seguindo a regra:

```text
primeiro_nome.ultimo_sobrenome.ano_nascimento@ufn.edu.br
```

- O resultado é armazenado no objeto Pessoa.
    - As pessoas cadastradas são armazenadas em: ArrayList<Pessoa>
    - Essa lista é compartilhada pelas threads responsáveis pelo atendimento dos clientes.

#### Sincronização 
- Como o servidor pode atender vários clientes simultaneamente, diferentes ClienteThread podem acessar a mesma lista.

- Para evitar condições de corrida, as operações sobre a lista são protegidas por: synchronized(lista)

- O bloco sincronizado garante que as operações de verificação e inserção realizadas sobre a lista não sejam executadas simultaneamente por diferentes threads.

#### Atualizaçao do ServidorInterface

- Quando uma pessoa é processada, a thread informa a interface por meio dos métodos:

```java
interfaceServidor.adicionarLog()
interfaceServidor.adicionarPessoa(pessoa);
```

- Assim, a interface apresenta:
    - mensagens de processamento no campo de log;
    - pessoas cadastradas na lista gráfica.
--- 
# FLUXOS
### Fluxo completo do sistema

O funcionamento completo pode ser representado pelo seguinte fluxo:

```text
┌─────────────────────┐
│ ClienteInterface    │
│                     │
│ Nome                │
│ Data de nascimento  │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│ ClienteController   │
└──────────┬──────────┘
           │
           │ Socket TCP
           ▼
┌─────────────────────┐
│ Servidor            │
│                     │
│ ServerSocket        │
│ porta 50000         │
└──────────┬──────────┘
           │
           │ accept()
           ▼
┌─────────────────────┐
│ ClienteThread       │
└──────────┬──────────┘
           │
           ▼
    Recebe Pessoa
           │
           ▼
┌─────────────────────┐
│ Verifica duplicidade│
└──────────┬──────────┘
           │
      ┌────┴─────┐
      │          │
      ▼          ▼
   Existente    Nova
      │          │
      │          ▼
      │      Gera e-mail
      │          │
      │          ▼
      │     Adiciona lista
      │          │
      └────┬─────┘
           │
           ▼
   Retorna Pessoa
           │
           ▼
┌─────────────────────┐
│ ClienteInterface    │
│                     │
│ Nome                │
│ E-mail              │
│ Data de nascimento  │
└─────────────────────┘

           E, no servidor:

ClienteThread
      │
      ├──────────────► ServidorInterface
      │                    │
      │                    ├── Log
      │                    │
      │                    └── Lista de pessoas
      │
      ▼
 ArrayList<Pessoa>
```

--- 
### Fluxo de cadastro de uma nova pessoa

```text
1. Usuário preenche os dados
        ↓
2. ClienteInterface valida os dados
        ↓
3. ClienteController estabelece conexão
        ↓
4. Pessoa é enviada pelo Socket
        ↓
5. Servidor recebe conexão
        ↓
6. ClienteThread recebe Pessoa
        ↓
7. Lista é consultada
        ↓
8. Pessoa não encontrada
        ↓
9. E-mail é gerado
        ↓
10. Pessoa é adicionada à lista
        ↓
11. Pessoa é enviada de volta
        ↓
12. Cliente apresenta os dados
        ↓
13. ServidorInterface atualiza log e lista
```
--- 
### Utilização de Threads
- classe Servidor ➜ permite que o servidor execute sua espera por conexões de forma independente da interface gráfica.
- classe ClienteThread ➜ é criada para cada cliente conectado. Dessa forma, o servidor pode atender múltiplos clientes sem precisar processar cada conexão de forma sequencial dentro da mesma thread.  

    - As diferentes threads compartilham a mesma: ArrayList<Pessoa>
        - Por isso o acesso à lista é sincronizado.
