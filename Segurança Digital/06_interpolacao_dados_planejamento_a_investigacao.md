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

## Conceitos:
- exposição: um serviço está acessível a partir de determinada origem
  - a mesma exposição pode ser necessária ao negócio e ainda exigir controles 
- fraqueza: configuração ou implementação reduz a segurança esperada
- vulnerabilidade: uma condição pode causar impacto quando explorada
- **CVE** ➜ identificador de um registro público de vulnerabilidade
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
- **CPE** ➜ liga o produto ao registro
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
    -  métricas de explorabilidade comuns:
        - AV: vetor de ataque
        - AC: complexidade
        - PR: privilégios exigidos
        - UI: interação do usuário
    - escopo e impacto:
        - S: o impacto atravessa a fronteira de segurança?
        - C: confidencialidade
        - I: integridade
        - A: disponibilidade
  - CVSS 4.0 ➜ base, Threat, Environmental e Supplemental
    - separa melhor impacto no sistema vulnerável e em sistemas subsequentes
    - Thread incorpora maturidade de exploração ao cálculo contextual
    - Environmental adapta o resultado ao ambiente avaliado
    - Supplemntal registra informações úteis sem alterar o score base
#### CVSS, EPPS e KEV respondem perguntas diferentes
- CVVS: Quão grave pode ser a vulnerabilidade sob condições definidas?
- EPPS: Qual a probabilidade estimada de exploração nos próximos 30 dias?
  - Score: probabilidade entre 0 e 1 de exploração observada
  - Percentil: posição relativa do CVE quando comparado ao demais registros avaliados
- CISA KEV: Há evidência de exploração conhecida no mundo real?
  - O catálogo reúne vulnerabilidades com evidência de exploração ativa.
  - A presença no KEV aumenta a urgência da análise e da remediação.
  - A ausência no catálogo não demonstra que o CVE seja seguro.
  - Confirme se o produto e a versão do ambiente estão realmente afetados 

### Pesquisa por produto e versão
- pesquise o nome exato do produto e a versão observada
- abra o registro e confira descrição, CPE e intervalo de versões
- leia as referências do fabricante e notas de atualização
  - confirma: produtos afetados, versões corrigida, pré-condições e mitigação
  - explica: backports, diferenças entre builds, configuração necessária e impacto real 
- registre CVSS com versão e vetor, sem copiar apenas o número
- a fonte do fabricante
  - confirma: produtos afetados, versões corrigidas, pré-condições e mitigação
  - explica: backports, diferenças entre builds, configurações necessárias 
- Quando NVD e advisory parecem discordar, entenda o pacote e a distribuição antes de concluir
### Cadeia de análise
porta ➜ serviço ➜ versão ➜ CVE ➜ CVSS ➜ Exploit ➜ Aplicável

- em qualquer etapa, evidências insuficientes devolvem a investigação ao passo anterior
#### por que a versão pode enganar
- fornecedor aplicou bakport do patch
- banner foi ocultado, alterado ou permanece desatualizado
- funcionalidade vulnerável está desabilitada
- exploit exige módulo, sistema operacional ou arquitetura diferentes
### Validação - da hipótese à confirmação
1. Reproduzir ➜ confirmar a evidência inicial
2. Contextualizar ➜ mapeia build, configuração e exposição
3. Testar ➜ testes seguros e autorizados
4. Documentar ➜ registar resultados e limitações

### O que investigar primeiro
- exploração ativa: há abuso conhecido ou evidência local?
- exposição: o serviço está acessível ao atacante?
- impacto: o ativo e os dados são críticos?
- viabilidade: existem pré-condições e controles?
#### Modelo simples de prioridade
- urgente: exposto, aplicável, alto impacto ou exploração observada
- alta: condições presentes e ativo importante
- média: hipótese plausível, com controles ou impacto limitado
- baixa: pouca evidência, sem exposição ou não aplicável

## Contexto do Ativo
- headers podem omitir ou falsificar o produto, confirme com outras evidÊncias
### Superfície de ataque observável
origem do teste muda o que está exposto e quais controles entram no caminho

- externa: serviços alcançáveis pela internet, DNS, certificados, APIs e painéis
- interna: serviços corporativos, administração, banco de dados e protocolos legados
- local: software instalado, permissões, credenciais e configurações do host

### Perguntas antes de buscar o CVE
- Qual é o produto exato, a versão, a build e a distribuição?
- O serviço está exposto para qual rede e quais usuários?
- Há autenticação, proxy, WAF, segmentação ou outro controle?
- A funcionalidade vulnerável está ativa e acessível?
- Qual impacto o comprometimento teria para o negócio?

