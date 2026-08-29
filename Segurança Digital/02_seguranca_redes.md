# Segurança de Redes
- reconhecimento ➜ o invasor mapeia a rede: hosts ativos, serviços expostos, versões de software
- enumeração ➜ detalha o que foi encontrado: portas abertas, protocolos, usuários e permissões
- exploração ➜ utiliza uma vulnerabilidade para obter acesso não autorizado
---
## ➢ Senhas
- comprimento importa mais que complexidade artificial
  - uma frase longa como "cavalo-azul-comendo-maca" é mais forte e fácil de lembrar do que "P@ssw0rd"
- nunca reaproveitar senhas ➜ a mesma senha em vários serviços significa que um vazamento compromete todos de uma vez
- autenticação multifator - MFA ➜ acesso exige um segundo fator (app, token, biometria)
  - nenhuma senha sozinha é suficiente
- gerenciador de senha ➜ permite usar uma senha longa e única por serviço, sem depender da memória
### ➥ Comprometimento de senhas
raramente uma senha é 'quebrada' por força bruta pura

- Vazamento de senha ➜ senha ou hash é exposta em um incidente de segurança de terceiros e reaparece em banco de dados de vazamento (DeHashed, HIBP)
- Reaproveitamento ➜ uma senha vazada em um serviço é testada automaticamente em dezenas de outros ➜ credential stuffing
- Phishing ➜ usuário é enganado e digita a senha diretamente em um site ou formulário falso
- Brute Force/Password Spray/Dicionário ➜ tentativas automatizadas e massivas ➜ eficazes contra senhas curtas ou previsíveis

---
## ➢ Introdução a testes de invasão
- comunicação entre computadores:
  - Rede Local - LAN ➜ poucos hosts
    - mesmo domínio físico ou lógico
    -  comunicação direta, geralmente via switch
  - Rede de Longa Distância - WAN ➜ interconecta redes locais distantes entre si
    - depende do roteamento entre redes
    - a própria internet é a maior WAN que existe
  - Internetworking
    - conjunto de protocolos que permite que redes diferentes, de fabricantes e tecnologias diferentes, conversem entre si
- Modelo OSI x TCP-IP
  - OSI é um modelo teórico e TCP-IP é um modelo prático
<div align="center">
    <img width="532" height="194" alt="image" src="https://github.com/user-attachments/assets/4cc38c7e-2af4-4e22-ade9-938efcea5be6" />

</div>      

## ➢ TCP-IP
- 4 camadas ➜ cada uma resolve um problema diferente da comunicação e tem suas próprias vulnerabilidades
### ➥ Camada de Aplicação
- onde os usuários e programas efetivamente se comunicam
- camada mais exposta a ataques ➜ bandeiras de serviços (banners), versões desatualizadas e credenciais fracas são os alvos mais comuns de reconhecimento inicial
- **responsável por:** definir como aplicações trocam dados: formato das imagens, quem inicia a conversa e o que cada lado espera receber
- protocolos:
  - HTTP/HTTPS ➜ navegação web (HTTPS - criptografado)
  - DNS ➜ traduz nomes em endereços IP
  - SSH ➜ acesso remoto administrativo, criptografado
  - FTP ➜ transferência de arquivos 
### ➥ Camada de Transporte
- organiza a entrega de dados entre processos (portas)
- TCP ➜ confiável e orientado a conexão
  - garante entrega e ordem
  - antes da troca de dados, cliente e servidor negociam o three-way handshake (SYN, SYN-ACK, ACK)
- UDP ➜ rápido e sem conexão
  - não garante entrega nem ordem
  - utilizado quando velocidade importa mais que confiabilidade ➜ DNS, streaming, VolP
- identificar se uma porta responde TCP ou UDP muda completamente a técnica de varredura e provável tipo de serviço atrás dela 
### ➥ Camada de Internet (Rede)
- responsável por endereçar hosts e encaminhar pacotes entre diferentes redes
- Internet Protocol - IP ➜ endereça cada host de forma única e leva o pacote de origem até o destino, rede após rede
- Roteamento ➜ cada roteador decide, com base na tabela de rotas, para qual próximo salto encaminhar o pacote
- ICMP ➜ protocolo de controle e diagnóstico
  - usado por ferramentas como ping e traceroute e por técnicas de reconhecimento de rede
- IPv4 X IPv6
  - IPv4
    - 32 bits ➜ cerca de 4,3 bilhões de endereços
    - notação decimal ➜ exemplo: 192.168.1.10
    - praticamente esgotou em 2011 ➜ sustentado por NAT atualmente   
  - IPv6
    - 128 bits ➜ praticamente inesgotável a quantidade de endereços
    - notação hexadecimal ➜ exemplo: 2001:db8::1 
### ➥ Camada de Rede
- coloca os dados fisicamente no meio de transmissão (cabo, fibra, rádio)
- Ethernet ➜ padrão para redes cabeadas locais
  - organiza os dados em quadros(frames) endereçados por MAC 
- Endereço MAC ➜ identificador físico, único por fabricante, gravado na placa de rede, usado apenas dentro do mesmo segmento local
- Wi-Fi ➜ versão sem fio do mesmo princípio, com desafios extras de segurança pela natureza aberta do meio de transmissão

## ➢ Endereçamento
### ➥ Classes de endereços IP e CIDR
- IPv4 é dividido em classes fixas
  - classe A
    - faixa de endereços: 1.0.0.0 - 127.255.255.255
    - /8
    - redes gigantes ➜ mais de 16 milhões de host ➜ fora de grande operadoras são raras 
  - classe B
    - faixa de endereços: 128.0.0.0 - 191.255.255.255
    - /16
    - redes médias ➜ comuns em universidades e empresas grande 
  - classe C
    - faixa de endereços: 192.0.0.0 - 223.255.255.255
    - /24
    - redes pequenas ➜ mais usada em redes locais e domésticas
- Classess Inter-Domain Routing (CIDR) ➜ permite dividir a rede em qualquer tamanho
  - indica o tamanho da rede diretamente na máscara
### ➥ Endereçamento IP e sub-redes
- todo host precisa de um endereço único
- estrutura de um IPv4: 192.168.1.10/24
  - 192.168.1 ➜ identifica a rede
  - .10 ➜ identifica o host
  - /24 ➜ máscara de sub-rede  
- sub-redes limitam o alcance de um ataque ➜ invasor dentro de uma sub-rede pequena enxerga menos host diretamente
- segmentação de rede é um controle de segurança ➜ separa a rede de convidados da rede administrativa
- entender endereçamento é pré-requisito para varredura de rede 

### ➥ Network Address Translation - NAT
- traduz endereços privados em um único endereço público, na saída para a internet
- faixas de IP privado -  não roteáveis na internet
  - 10.0.0.0/8 - 172.16.0.0/12 - 192.168.0.0/16 
- economiza IPs públicos
  - toda a rede local sai para a internet com único endereço IPv4 público ➜ essencial com esgotamento do IPv4
- ganho de segurança indireto
  - hosts internos não são diretamente endereçáveis pela internet
  - não substitui um firewall   
### ➥ Portas e serviços comuns
- porta identifica qual serviço, dentro do host, deve receber os dados

<div>
  <img width="600" height="202" alt="image" src="https://github.com/user-attachments/assets/068adac1-665c-43a6-938b-fcc4a823eebe" />
</div>

---
## ➢ Controle de rede
### ➥ Firewalls e ACLs
- primeiro controle de rede ➜ decidem, pacote a pacote, o que entra e sai com base em regras explicítas
- Firewall ➜ analisa o tráfego que passa por ele e aplica regras
  - permite ou bloqueia com base em IP de origem/destino, porta e protocolo
- Access Controll List- ACL ➜ lista ordenada de regras de permissões/negação, aplicadas em um roteador ou switch
- princípio prático ➜ negar tudo por padrão e liberar explicitamente só o que é necessário 
### ➥ VLANs e segmentação de rede
- dividir uma rede física em várias redes lógicas isoladas - mesmo cabo, tráfego separado
- VLAN - Virtual LAN ➜ agrupa portas de switch em domínios de broadcast separados, mesmo que os equipamentos estejam fisicamente na mesma rede ➜ como se fossem redes independentes
- isolamento por finalidade ➜ rede de convidados, rede administrativa e rede de servidores em VLANs separadas (mesmo compartilhando o mesmo switch físico)
- redução da superfície de ataque ➜ um host comprometido em uma VLAN não enxerga diretamente hosts de outras ➜ limita o movimento lateral de um invasor
- organização e desempenho ➜ também reduz tráfego de broadcast desnecessário e organiza a rede por departamento ou função
### ➥ Wi-Fi: WPA2/WPA3
- o meio de transmissão sem fio, por natureza é mais exposto ➜ qualquer um dentro do alcance pode ouvir
- rede aberta (sem senha) ➜ todo tráfego pode ser capturado por qualquer pessoa próxima
  - nunca deve ser usado para nada sensível sem VPN
- WPA2 ➜ padrão consolidado, com criptografia forte (se bem configurado)
  - ainda vulnerável a ataques de força bruta contra senhas fracas   
- WPA3 ➜ sucessor do WPA2
  - proteção adicional contra tentativas offline de quebra de senha e criptografia individualizada por sessão


---
## ➢ Vulnerabilidade
### ➥ Ataques comuns de rede
- ataques que exploram diretamente o funcionamento dos protocolos
#### Sniffing
- captura passiva do tráfego de rede
- exemplo: Wireshark
#### Spoofing
- falsificação de identidade na rede
  - IP spoofing ➜ forja o endereço de origem
  - ARP spoofing ➜ forja a tradução IP-MAC 
#### Man-in-the-Middle (MITM)
- atacante se posiciona entre duas partes e intercepta, ou altera, a comunicação sem que nenhuma delas perceba
#### Negação de Serviço (DoS/DDoS)
- sobrecarrega um serviço com requisições até torná-lo indisponível ➜ quebra a disponibilidade da tríade CIA
### ➥ Mirai Botnet
<div>

  <img width="616" height="188" alt="image" src="https://github.com/user-attachments/assets/c2078610-e6bb-4db0-9bd5-93647666c6fd" />
</div>

---
## ➢ Teste de invasão
- reconhecimento ➜ mapear IPs, sub-redes e hosts ativos na rede-alvo ➜ camada de Internet
- varredura de portas ➜ descobrir quais portas TCP/UDP estão abertas em cada host ➜ camada de Transporte
- enumeração de serviços ➜ identificar qual aplicação e versão responde em cada porta ➜ camada de Aplicação
- relato ➜ documentar tudo em um relatório técnico
  - teste de invasão sem laudo não tem valor formal 
### ➥ Fases de um teste de invasão
- metodologia como os PTES organizam o trabalho em fases
1) Planejamento e acordo - Rules of Engagement
    - define escopo, horários, o que pode ou não ser testado e a autorização formal por escrito
2) Reconhecimento
    - coleta de informações públicas e de rede sobre o alvo
3) Varredura e Enumeração
    - mapeamento detalhado de vulnerabilidades potenciais nos serviços encontrados
4) Exploração
    - tentativa controlada de uso de uma vulnerabilidade para obter acesso
5) Pós-exploração
    - avalia até onde o acesso obtido permitiria avançar, sem causar dano real
6) Relatório
    - documentação técnica das falhas encontradas, evidências e recomendações de correções
### ➥ Tipos de testes de invasão
- a quantidade de informação prévia dado ao testador muda a abordagem
- **Black box**
  - testador não recebe nenhuma informação prévia
  - simula um ataque externo real 
- **Grey box**
  - testador recebe informações parciais ➜ exemplo: uma conta de usuário comum
  - simula uma ameaça interna limitada 
- **White box**
  - testador recebe acesso completo ➜ topologia de rede, código-fonte, credenciais
  - foca em profundidade, não em descoberta 
### ➥ Teste sem autorização é crime
- Lei 12.737/2012 (Lei Carolina Dieckmann) — tipifica como crime a invasão de dispositivo informático alheio, mediante violação indevida de mecanismo de segurança, para obter, adulterar ou destruir dados
- autorização por escrito
  - todo teste de invasão profissional exige um contrato formal definindo escopo
- código penal
  - dependendo do caso, pode configurar outros crimes como dano ou violação de correspondência eletrônica  













