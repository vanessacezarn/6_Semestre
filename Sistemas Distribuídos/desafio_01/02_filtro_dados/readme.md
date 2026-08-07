### Filtro de Dados Independente (Map)
Contexto: Limpeza e saneamento de bases de dados.

Problema: Você tem uma lista com 5.000 strings contendo nomes de usuários informados em um formulário.

Ação: Divida a lista em 2 blocos. A Thread A recebe a primeira metade e a Thread B recebe a segunda metade. Cada thread deve processar sua sublista isolada, aplicando regras de limpeza: remover espaços em branco no início/fim e converter todo o texto para letras maiúsculas.

Encerramento: Cada thread retorna uma nova lista limpa. A thread principal junta as duas listas resultantes.
