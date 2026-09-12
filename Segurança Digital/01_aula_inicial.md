### ➤ Competências da disciplina
 ➥ Unidade 1: Segurança de Redes Locais e de longa distância

 ➥ Unidade 2: Serviços que promovem vulnerabilidades

 ➥ Unidade 3: Serviços que permitem escutar e visualizar o que passa em uma rede

 ➥ Unidade 4: Técnicas de defesa e invasão em servidores, estações de trabalho e equipamentos móveis
 
---
# Segurança Digital

### casos reais
- Colonial Pipeline (2021)➜ ransomware paralisou o maior oleoduto de combustível da Costa Leste dos EUS
  - acesso inicial partiu de uma única senha vazada de uma VPN sem autenticação em dois fatores
- MGM Resorts (2023) ➜  sistema de reserva, cassino e hoteis fora por dias
  - ligação se passando por cliente convenceram atendente a resetar a senha e o MFA de um conta com privilégios altos
### Definição:
- em essência: proteger informações, contas e sistemas para que ninguém não autorizado acesse, altere ou derrube o que importa
- conceitos importantes:
  - ativos ➜ o que deve ser protegido ➜ dados, contas, sistemas, infraestrutura
  - ameaças ➜  evento ou agente com potencial de causar dano a um ativo ➜ agentes maliciosos, golpes, vírus, malware, eventos naturais
  - vulnerabilidades ➜ brechas, falha ou fraqueaza exploráveis ➜ senha fraca, sistema desatualizado, configurações incorretas, falta de treinamento
  - riscos ➜ combinação entre a probabilidade de uma ameaça explorar uma vulnerabilidade e o impacto que isso causaria
  - controles ➜ proteções aplicadas ➜  MFA, backup, antivírus, politicas

### Tríade CIA
- 3 propriedades que toda informação precisa manter
- Confidencialidade ➜ só quem tem autorização consegue acessar a informação
  - criptografia, controle de acesso
  - quebra de propriedade pode leva a exposição de dados
- Integridade ➜ informação permanece correta e não é alterada sem permissão
  - hash, assinatura digital
  - quebra de integridade pode alterar comandos/ afetar execuções essenciais do sistema
- Disponibilidade ➜ sistema está acessível e funcional quando é preciso
  - redundância, backup, plano de contingência
  - falta de disponibilidade pode causar prejuízos enormes

### Defesa em profundidade
- nenhum controle é infalível sozinho ➜ estratégia: empilhar camadas, se uma falhar a próxima segura
<div align="center">
<img width="403" height="300" alt="image" src="https://github.com/user-attachments/assets/eb6e6d21-e5a4-4049-9113-75df0a2ee9e5" />
</div>

### Modelo Zero Trust
- nunca confie sempre verifique
- cada acesso é validado ➜ mesmo vindo de dentro da rede
<div align="center">
 <img width="854" height="188" alt="image" src="https://github.com/user-attachments/assets/db5e3543-1681-4cb3-a85f-fcd06b6246c0" />

</div>

### Para testes:
- VirusTotal: ferramenta gratuita que analisa arquivos, links e endereços de IP usando dezenas de motores de antivírus e serviços de reputação ao mesmo tempo
- Have I Been Pwned: serviço que verifica se um e-mail ou senha já apareceu em algum vazamento de dados público conhecido
- Wazuh Dashboard: plataforma open source de monitoramento de segurança (SIEM/XDR) usada para detectar e correlacionar eventos suspeitos em tempo real
- Wireshark: analisador de tráfego de rede que captura e exibe, pacote por pacote, tudo que trafega numa interface de rede

