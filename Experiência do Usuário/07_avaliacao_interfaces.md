# Avaliação de Interfaces
- processo de desenvolvimento
  - fase 1: análise
  - fase 2: projeto
  - fase 3: construção e prototipação
  - fase 4: avaliação
- qualidade de software ➜ um dos fatores de qualidade é interação humano-computador ➜ avaliação de interação/usabilidade
### Diferentes formas de avaliar a interação:
- objetivo: porque avaliar?
- critérios: o que avaliar ?
- forma: onde e quando avaliar?
  - etapa do processo
  - condições para a avaliação
- participantes: avaliar sob a perspectiva de quem?
  - usuário, desenvolvedores, projetistas
- métodos e técnicas: como avaliar?
  - identificar problemas e corrigi-los
  - aumentar produtividade e satisfação do usuário
### Propósitos da avaliação
- validação do sistema ➜ entendimento do mundo real
  - como o usuário emprega a tecnologia
- escolha de uma solução ➜ comparação de diferentes soluções de design
- adequação às normas ➜ verificar a conformidade com um padrão
- verificar satisfação de metas pré-estabelecidas ➜ desenvolvendo para alcançar uma meta
--- 
 ## Usabilidade
 - determina quão utilizável é o produto
 - conjunto de critérios que contribuem para a satisfação de objetivos (do cliente, do usuário ou do desenvolvedor)
 - adequação entre características (físicas/cognitivas) dos usuários e característica da interação com o sistema para realização de tarefa dentro de um contexto determinado
<div align="center">
  <img width="397" height="274" alt="image" src="https://github.com/user-attachments/assets/c5df7e8b-4156-4208-9eea-58b321d5f7aa" />
</div>

- Pressman, 1995 ➜ tentativa de se quantificar a expressão: amigável ou usuário
  - aprendizagem exigida
  - tempo de aprendizagem
  - produtividade
  - satisfação (subjetiva)
- a avaliação da usabilidade deve acontecer conforme o perfil do usuário
  - eficácia ➜ efetiva realização das tarefas
  - eficiência ➜ tempo, erros, ajuda, passos desnecessários
  - satisfação do usuário ➜ fator subjetivo

### Prototipação
- alternativas para produzir protótipos rapidamente
  - colocar pouca ênfase na eficiência da implementação
  - aceitar menos confiabilidade ou código de qualidade ruim
  - usar algoritmos simplificados ou não completos
  - usar uma plataforma diferente da final
  - usar dados fictícios ou outro conteúdo

### Normas de usabilidade 
- ISO 9241: Ergonomia de software ➜ define usabilidade
- ISO 9126: Características de qualidade
- ISO 11581: Ícones - design
- ISO 14915: Multimídia IU - design
- ISO 13407: Projeto centrado no usuário
- ISO 16982: Métodos de usabilidade
- ISO 14598: Projeto de Avaliação
---
# Avaliação
### Avaliação Formativa x Somativa
<div>
  <img width="365" height="215" alt="image" src="https://github.com/user-attachments/assets/2d8ac221-be56-4f62-b223-c01848b3f732" />
</div>

- somativa a avaliação é feita somente no produto final
- formativa a avaliação é feita ao longo do desenvolvimento

### Participantes da Avaliação
- avaliar sob a perspectiva de quem?
- categorias:
  - usuários teste: usuários finais, usuários "contratados"
  - membro da equipe de desenvolvimento
  - especialistas em IHC
  - especialistas em outras áreas - psicólogos, engenheiros, publicitários

### Técnicas de Avaliação
- técnicas prospectivas
- técnicas preditivas ou diagnósticas
  - avaliações heurísticas
    - avaliações heurísticas de usabilidade
    - inspeções cognitivas da intuitividade
    - inspeções preventivas de erros
  - avaliação analíticas
  - checklists
- técnicas objetivas ou empíricas
  - ensaios de interação
  - sistemas de monitoramento
- técnicas objetivas ou empíricas
  - ensaios de interação
  - sistemas de monitoramento  

## Técnicas Propectivas
- buscam a opinião do usuário sobre a interação com o sistema ➜ satisfação
- pode ser empregada como avaliação analítica ➜ problemas de usabilidade (ISO 9241-10)
- utilizam questionários/entrevistas
  - composição dos questionários:
    - perguntas aberta: usuário opina, discertativa
    - perguntas fechadas: conjunto pré-estabelecido de respostas, objetivo
  - servem para avaliação quantitativa e qualitativa
  - pequeno número de questões sucintas
  - espaço para opiniões e sugestões
  - taxa de devolução <= 30%
## Técnicas Preditivas ou Diagnósticas
prever erros de projetos sem a participação direta do usuário
### Avaliações Heuríticas
- baseado no conhecimento ergonômico e experiências dos avaliadores
- examinam o sistema interativo e fazem o diagnóstico dos problemas
#### avaliações heuríticas de usabilidade
- resultados dependem da experiência/competência dos avaliadores
  - vários aspectos: objetivos do usuário, estrutura da interface, objetos da interface, qualidade das interfaces
- baseiam-se em heurística ou padrões de usabilidade gerais
  - critérios ergonômicos (Scapin e Bastien - 1993)
  - heurísticas de usabilidade (Jacob Nielsen)
  - ISO 9241: 10
##### Heurísticas (Nielsen,1993)
1) visibilidade do status do sistema
    - sistema deve manter os usuários informados sobre o que está acontecendo ➜ feedback adequado dentro de um tempo razoável
2) compatibilidade do sistema com o mundo real
    - linguagem e conceitos familiares ao usuário
3) controle do usuário e liberdade
    - em caso de engano de funções é necessário ter uma 'saída de emergência' clara para sair do estado indesejado sem ter que percorrer um extenso diálogo 
4) consistência e padrões
    - seguir convenções da plataforma computacional
5) prevenção de erros
    - um design o qual previne o erro antes dele acontecer é melhor que uma boa mensagem
6) reconhecimento ao invés de lembrança
    - instruções para uso do sistema devem estar visíveis e facilmente recuperáveis quando necessárias
7) flexibilidade e eficiência de uso
    - usuários novatos devem se tornar peritos com usos e usuários experientes 'cortam' caminho em ações frequentes
8) estética e design minimalista
    - diálogos não devem conter informações irrelevantes ou raramente necessárias
9) ajudar os usuários a reconhecer, diagnosticar e corrigir erros
    - mensagem de erro devem ser expressas em linguagem clara, indicando precisamente o problema e sugerindo uma solução
10) ajuda e documentação
    - informações devem ser fáceis de encontrar, focalizadas na tarefa do usuário e não muito extensas.
- como conduzir a avaliação heurística
  - pequeno conjunto de avaliadores ➜ 3 a 5
    - cada um julga a interface/protótipo conforme as heurísticas
      - percorrer a interface pelo menos 2 vezes  
  - problemas diagnosticados são consolidados em uma única lista, onde pode-se classificar quanto à gravidade do problema:
    - frequência do problema: raro ou comum
    - impacto do problema na interação do usuário: fácil ou difícil de contornar
    - persistência do problema: 1 vez ou os usuários são repetidamente incomodados por ele
  - grau de severidade:
    - não concordo que é um problema de usabilidade
    - problema cosmético ➜ corrigido se sobrar tempo
    - problema de usabilidade menor ➜ prioridade baixa
    - problema de usabilidade grave ➜ prioridade alta
    - catástrofe de usabilidade ➜ correção antes do produto ser liberado   
        
#### inspeções cognitivas da intuitividade
#### inspeções preventivas de erro



### Avaliações Analítica
### Checklists




