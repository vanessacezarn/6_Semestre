## ➢ Blue Team - defende
- equipe que defende os sistemas: reduz a superfície de ataque, monitora, detecta atividades maliciosas e responde a inicidentes
- parte do princípio que vai acontecer um ataque
- monitora, detecta e responde
- precisa fechar todas as brechas
- protege a operação no dia a dia ➜  24 x 7, o tempo todo
- precisa de métodos: frameworks, monitoramento e automação
### ➥ Quatro pilares
1) prevenir ➜ path, MFA, segmentação
2) detectar ➜ Logs, SIEM, EDR (antivírus)
3) responder ➜ conter e erradicar
4) recuperação ➜ backup e lições aprendidas
### ➥ Como o blue trabalha
- SOC ➜ time que monitora a segurança 24x7 e tria os alertas   
- Logs ➜ matéria-prima: sem registro, não há o que detectar
- Detecção: coletar ➜ correlacionar ➜ alertar ➜ o analista investiga
###➥  Defesa em profundidade
1) politicas e pessoas
2) perímetro: firewall, segmentação
3) rede: monitoramento, IDS/IPS
4) Host: EDR, patch, hardening
5) Dados: criptografia, backup, acesso mínimo 
### ➥ Ferramentas para conhecer
- SIEM ➜ junta os logs de tudo e dispara alertas
- EDR ➜ vê e responde no computador, isola a máquina infectada
- IDS/IPS ➜ detecta ou bloqueia tráfego suspeito na rede
### ➥ Frameworks guiam a defesa
- NIST 


## ➢ Red Team - ataca
- simula o adversário real
- procura uma brecha que funcione
- encontra as falhas antes do criminoso
- escolhe onde e quando atacar
- só precisa acertar uma vez

### Todo ataque tem uma resposta
|RED TEAM | BLUE TEAM |
|:----: | :-----:|
|serviço legado explorado (vstfpd 2.3.4) | path - remover serviço - gestão de vulnerabilidade|
|entrar por credencial padrão | senha forte - MFA - trocar defaults|
