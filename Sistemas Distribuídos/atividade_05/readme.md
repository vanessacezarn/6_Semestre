# Desafio da Telefonia

A partir do sistema local, desenvolvido em PESQUISA E ORDENAÇÃO, refatore o sistema para que funcione em arquitetura cliente-servidor. O servidor abre a base de sessões de telefonia e fornece ao cliente os dados de sua sessão, a partir do número de celular informado pelo cliente.

##

Código base utilizado foi o desenvolvido na disciplina de Pesquisa e Ordenação cursada no 4º Semestre: - [Pesquisa-Ordenacao-2025](https://github.com/vanessacezarn/4_Semestre/tree/main/Pesquisa%20e%20Ordena%C3%A7%C3%A3o/aula_13_Desafio_Telefonia)


## Observações

1) Cabe ao programador decidir qual abordagem Cliente-Servidor vai utilizar
2) O servidor deve:
    - abrir a base de sessões (https://github.com/alexandrezamberlan/pesquisa_ordenacao/blob/master/05-hash/problemaSessaoTelefonia/telephony_sessions.txt);
    - adicionar em um HashMap as sessões da base;
    - retornar dados da sessão de um celular informado pelo cliente
3) O cliente pode:
    - conectar ao servidor (via RMI, por exemplo)
    - consultar dados de sessão de um número de celular.
