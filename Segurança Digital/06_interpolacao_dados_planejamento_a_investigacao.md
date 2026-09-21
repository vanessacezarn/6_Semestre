# Da enumeração à vulnerabilidade
- interpolando dados e planejando a investigação
- ferramenta coleta sinais, o analista atribui significado e escolhe o próximo teste
  - dado ➜ contexto ➜ hipótese ➜ decisão
  - ex: 22/tcp open ssh OpenSSH 8.0p1 Ubuntu 3ubuntu0.6
    - 22/tpc ➜ qual porta e protocolo de transporte?
    - open ➜ como o alvo respondeu ao scan?
    - ssh ➜ qual serviço o Nmap inferiu?
    - versão ➜ qual o produto e build parecem ativos
  - aberta não significa vulnerável ➜ estado da porta descreve conectividade
    - open: aplicação aceitando conexões
    - closed: o host respondeu, mas não há serviço escutando
    - filtered: algum controle impediu a conclusão do scan
    - open|filtered: resposta não permitiu distinguir os dois estados
- o backport de patches é uma das principais causas de falso positivo em análise por versão

#### fontes de identificação
quantos mais fontes independentes concordarem, melhor a confiança

- banner: resposta direta do serviço
- HTTP headers: server, cookies e tecnologias
- Nmap -sV: sondas e assinaturas
- Comportamento: recursos e respostas observadas

#### Confiança da evidência
- baixa ➜ inferência genérica: servidor web em 80/tcp
- média ➜ Nmap identifica produto e família de versão
- alta ➜ banner, resposta HTTP e comportamento confirmam a mesma build

### Conceitos:
- exposição: um serviço está acessível a partir de determinada origem
  - a mesma exposição pode ser necessária ao negócio e ainda exigir controles 
- fraqueza: configuração ou implementação reduz a segurança esperada
- vulnerabilidade: uma condição pode causar impacto quando explorada
### CVE ➜ identificador de um registro público de vulnerabilidade
  - anatomia: CVE-2024-12345
    - CVE: programa de identificação
    - 2024: ano da atribuição
    - 12345: sequência única naquele ano
  - identificador organiza a conversa
  - registro contém descrição, referências e produtos afetados 
- CWE ➜ categoria de fraqueza, como validação inadequada de entrada
- Exploit ou PoC ➜ código ou procedimento que demonstra ou aproveita uma condição
  - um CVE pode não ter exploit público
  - um exploit pode exigir condições ausentes no alvo
#### CPE ➜ liga o produto ao registro
  - ajuda na correlação, mas nomes e faixas ainda precisam de validação
  - cpe:2.3:a:vendor:produto:versao:*.*.*.*
    - a ➜ tipo: application
    - vendor/produto ➜ fabricante e nome normalizado
    - versão ➜ faixa que precisa ser conferida
#### gravidade não é prioridade
- Prioridade: combina gravidade com exposição, criticidade do ativo, controle e exploração observada
- CVSS: mede características técnicas de gravidade com um vetor padronizado
  - ao registrar um score, informe também a versão do CVSS e o vetor completo 
  - CVSS 3.1 ➜ base, temporal e environmental
    -  métricas comuns: AV, AC, PR, UI, S, C, I e A
  - CVSS 4.0 ➜ base, Threat, Environmental e Supplemental
    - separa melhor impacto no sistema vulnerável e em sistemas subsequentes
 
...
### Pesquisa por produto e versão
- pesquise o nome exato do produto e a versão observada
- abra o registro e confira descrição, CPE e intervalo de versões
- leia as referências do fabricante e notas de atualização
  - confirma: produtos afetados, versões corrigida, pré-condições e mitigação
  - explica: backports, diferenças entre builds, configuração necessária e impacto real 
- registre CVSS com versão e vetor, sem copiar apenas o número

...

### Cadeia de análise
porta ➜ serviço ➜ versão ➜ CVE ➜ CVSS ➜ Exploit ➜ Aplicável

#### por que a versão pode enganar
- fornecedor aplicou bakport do patch
