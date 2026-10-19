# Planejamento de testes de invasão
## Metodologia
- por que planejar em vez de improvisar:
  - cobertura: um método garante que nenhuma superfície importante fique sem teste
  - comparabilidade: fases padronizadas tornam o resultado repetível e auditável (dois testadores chegam ao mesmo mapa)
  - defensabilidade legal: escopo e regras definidos por escrito separam o serviço contratado do crime
- planejar = transformar dados em decisões rastreáveis
  - cada técnica escolhida precisa apontar para uma evidência coletada e para um objetivo do escopo
  - plano é o fio que liga reconhecimento ➜ exploração ➜ pós-exploração ➜ relatório
- onde o planejamento entra no ciclo
<div>
  <img width="789" height="290" alt="image" src="https://github.com/user-attachments/assets/0cbf367f-75ce-4698-b106-45ac48e36801" />

</div>

- metodologias e frameworks de apoio
  
|framework | o que é | para que usamos|
|:----:|:----:|:-----:|
| PTES | padrão de 7 fases para execução de pentest | estrutura geral do teste|
| NIST SP 800-115 | guia técnico de avaliação de segurança (EUA) | planejamento e execução |
| OWASP WSTG | Web Security Testing Guide - testes em aplicações | alvos web |
| OSSTMM | metodologia aberta de teste de segurança | métrica e rigor |
| MITRE ATT&CK | base de táticas e técnicas reais de adversários | escolha de técnicas |
| PTES - Intel Gathering | fase de coleta: OSINT, footprinting, enumeração | coleta de dados |

  - não existe um só framework "certo": combina-se o padrão geral (PTES/NIST) com os específicos do alvo (OWASP para web) e com o
catálogo de técnicas (ATT&CK).

- o ATT&CK organiza o que um atacante faz em TÁTICAS (o objetivo) e TÉCNICAS (como). Ao planejar, escolhemos técnicas por tática — e a defesa mapeia detecções para as mesmas células.
  - reconhecimento ➜ coletar dados do alvo
  - acesso inicial ➜ primeira entrada
  - execução ➜ rodar código
  - escalada de privacidade ➜ virar admin/root
  - movimento lateral ➜ pivotar na rede
  - exfiltração ➜ tirar os dados

- quanto o testador sabe do alvo:
  - a informação entregue ao testador muda toda a coleta — e é definida já no planejamento
  - black box ➜ Nenhuma informação prévia. O testador começa do zero, como um atacante externo real. A coleta de dados é intensa.
  - grey box ➜ Informação parcial: credenciais de usuário comum, um diagrama, uma lista de IPs. O mais comum na prática
  - white box ➜ Acesso total: código-fonte, arquitetura, credenciais. Foco em profundidade, não em descobrir a superfície.

## Escopo e regras de engajamento
- escopo define exatamente quais ativos, faixas de rede, janelas de tempo e técnicas estão autorizados. Tudo fora dele é, na prática, invasão não autorizada.
- regras de engajamento
  - autorização por escrito ➜ quem assina, para quais ativos, com data de início e fim
  - alvos e faixas ➜ IPs, domínios e sub-redes explicitamente listados
  - janela de testes ➜ horários permitidos - evitar impacto em produção
  - técnicas proibidas ➜ ex: DoS, phinshing a terceiros
  - contato de emergência ➜ a quem avisar se algo sair do previsto - parada segura
  - tratamento de dados ➜ como evidências e achados são guardados e descartados
- Antes de rodar qualquer ferramenta, confirme: este alvo está na lista autorizada? Estou dentro da janela? A técnica está permitida na RoE? Se a resposta a qualquer uma for "não", pare.

 


















