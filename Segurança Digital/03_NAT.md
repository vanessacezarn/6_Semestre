# Protocolo de Rede
- principais protocolos, suas portas, transporte e função
<div align="center">
  <img width="540" height="196" alt="image" src="https://github.com/user-attachments/assets/2e7e3a5e-bb1d-4dab-b5d3-43e107a02e92" />
</div>

- DHCP: como um host recebe um endereço ➜ cada host da rede local precisa receber um endereço IP
  - Discover ➜ host novo envia um broadcast perguntando "há algum serviço DHCP nesta rede?"   
  - Offer ➜ servidor DHCP responde oferecendo um endereço IP disponível, com máscara, gateway e DNS
  - Request ➜  host solicita formalmente o uso do endereço oferecido (pode haver mais de um servidor)
  - Acknowledge ➜ servidor confirma a concessão (lease) ➜ host passa a usar o endereço por um período
  
- conhecida como DORA ➜ é o endereço que o NAT vai precisar traduzir na saída para internet

### Endereços IP válido e inválido
- nem todo endereço IPv4 pode circular livremente na internet pública
- endereço válido ➜ público
  - roteável na internet
  - único no mundo todo ➜ atribuído por uma entidade regional a provedores e organizações
  - é o endereço que um servidor precisa ter para ser alcançado por qualquer host da internet
- endereço inválido ➜ privado
  - não roteável na internet
  - reservado pela RFC 1918 para uso interno em redes locais
  - roteadores da internet descartam pacotes com esses endereços de origem ou destino ➜ por isso ele precisa ser traduzido antes de sair
#### Faixas de endereços reservadas
- além das faixas privadas (RFC 1918) existem outras faixas de uso especial que também circulam na internet pública

| Faixa |  CIDR |  Uso |
| :---: | :---: | :---:|
| 10.0.0.0 - 10.255.255.255 | 10.0.0.0/8 | redes privadas ➜ comum em empresas grandes |
| 172.16.0.0 - 172.31.255.255 | 172.16.0.0/12 | redes privadas ➜ comum em provedores e data centers |
| 192.168.0.0 - 192.168.255.255 | 192.168.0.0/16 | redes privadas ➜ a mais usada em redes domésticas |
| 127.0.0.0 - 127.255.255.255 | 127.0.0.0/8 | loopback ➜ o próprio host (127.0.0.1) |
| 169.254.0.0 - 169.254.255.255 | 169.254.0.0/16 | link-local/APIPA - atributo quando o DHCP falha |

- roteadores da internet possuem por convenção (RFC 1918), regras para descartar qualquer pacote cujo endereço de origem ou destino pertença a uma faixa privada
  - qualquer pacote saindo de 192.168.1.10 diretamente para a internet seria simplesmente descartado no primeiro roteador do provedor
 
- consequência prática ➜ host com endereço privado não consegue, sozinho, se comunicar com a internet pública ➜ falta um endereço real no cabeçalho do pacote
- o que isso resolve? um dispositivo de borda precisa reescrever o endereço de origem antes do pacote sair da rede local ➜ esse dispositivo faz NAT

- cenário mais comum de uma rede doméstica ou de uma pequena empresa ➜ uma rede inteira em um único IP público
  - contrato do provedor ➜ o provedor de internet normalmente entrega apenas um endereço IPv4 público por contrato residencial
  - dezenas de dispositivos ➜ celulares, notebooks,... cada um recebe um endereço privado do roteador via DHCP
  - um só 'portão de saída' ➜ todos precisam sair para a internet usando o mesmo endereço público
---
## NAT - Network Address Translation
- técnica pela qual um dispositivo de rede (tipicamente um roteador) reescreve, em tempo real, os endereços IP e as portas, dos pacotes que atravessam ele, permitindo que hosts com endereços privados se comuniquem com a internet pública através de um único endereço válido
- 'vive' na borda da rede ➜ roteadores domésticos, firewalls corporativos e gateways de nuvem são os pontos mais comuns onde a NAT é aplicado
#### Funcionamento
- o que muda no cabeçalho do pacote ao atravessar o roteador
  - roteador guarda a correspondência em uma tabela de tradução 
| momento | IP de origem | porta de origem | IP de destino|
| :----:  | :----------: | :-------------: | :-----------:|
| antes do NAT (rede local) | 192.168.1.10 | 51422 | 200.150.10.5 |
| depois do NAT (internet)  | 203.0.113.7 | 40001 | 200.150.10.5 |
| resposta chega no roteador| 200.150.10.5 | 80 | 203.0.113.7:40001 |
| depois do NAT (volta à rede local) | 200.150.10.5 | 80 | 192.168.1.10:51422 |

### Static NAT
- tradução fixa, um-para-um, entre um endereço privado e um endereço público
- como funciona ➜ cada endereço IP privado é mapeado permanentemente para um endereço IP público específico ➜ relação nunca muda
- quando usar ➜ servidores internos que precisam ser sempre alcançados pelo menos endereço externo, como um servidor de e-mail ou um site
- custo ➜ consome um endereço público para cada host mapeado ➜ pouco escalável quando os endereços públicos são escassos

### Dynamic NAT
- tradução um-para-um ➜a partir de um pool de endereços públicos disponíveis
- funcionamento ➜ roteador mantém um conjunto de endereços públicos e atribui um deles temporariamente, a cada host que precisa sair para a internet
- uso ➜ empresas com vários endereços públicos contratados, mas menos do que o total de hosts internos ativos ao mesmo tempo
- limite ➜ se todos os endereços do pool estiverem em uso, o próximo host que tentar sair para a internet fica bloqueado até haver um endereço livre

###  Port Address Translation- PAT/NAT Overload
- mais utilizado
- muitos hosts privados compartilhando um único endereço público, diferenciado pela porta
- funcionamento ➜ todos os host internos saem usando o mesmo endereço IP público, o que os diferencia é a porta de origem, reescrita pelo roteador para cada conexão
- onde está ➜ modo padrão dos roteadores domésticos e da grande maioria das redes corporativas ➜ geralmente chamada apenas de NAT
- vantagem ➜ permite dezenas de milhares de hosts internos compartilhando um único endereço IPv4 público, otimizando um recurso escasso

#### tabela de tradução do PAT

| IP interno | porta interna | IP público | porta traduzida | destino |
| :----:  | :----------: | :-------------: | :-----------:| :------:  |
| 192.168.1.10 | 51422   | 203.0.113.7 | 40001 | 200.1500.10.5:80|
| 192.168.1.11 | 50110   | 203.0.113.7 | 40002 |142.250.0.14:443|
| 192.168.1.10 | 51422   | 203.0.113.7 | 40003 |13.107.42.14:443|
| 192.168.1.15 | 50110   | 203.0.113.7 | 40004 |200.150.10.5:80|

### Rastreando uma tradução NAT
- cenário: 192.168.0.20 acessa um site na porta 443 através de um roteador com IP público 187.45.10.30
1) pacote sai do host ➜ origem 192.168.0.20:53210 ➜ destino: 8.8.4.4:443
2) roteador aplica NAT ➜ reescreve a origem para 187.45.10.30:61010 e registra a tradução em sua tabela
3) resposta chega ao roteador ➜ servidor responde 187.45.10.30:61010, o único endereço que conhece
4) roteador desfaz o NAT ➜ consulta a tabela, identifica 192.168.0.20:53210 e reencaminha o pacote para dentro da rede

### NAT de saída X NAT de entrada
- saída ➜ outbound
  - automático e transparente
  - quando um host interno inicia a conexão, o roteador cria a tradução automaticamente e sabe para onde devolver a resposta ➜ é o caso de qualquer navegação normal
- entrada ➜ inbound
  - não existe por padrão
  - se alguém de fora tentar iniciar uma conexão com um host interno, o roteador não sabe para qual máquina privada encaminhar o pacote ➜ descarta a tentativa  

### Port Forwarding e DMZ
- como expor um serviço interno de propósito, de forma controlada
- port forwardind ➜ regra explícita, porta por porta
  - o administrador cria uma regra dizendo: “tudo que chegar na porta pública X deve ser encaminhado para o host interno Y, na porta Z”
  - é o caminho correto para expor um serviço específico, como um servidor de jogos ou uma câmera
- DMZ (host exposto) ➜ todo o tráfego, sem filtro
  - encaminha para um único host interno todo o tráfego não tratado por outra regra — na prática, remove a proteção do NAT para essa máquina
  - deve ser evitado fora de laboratório ou de um cenário muito bem 
controlado

### Consequências do NAT
- protocolos que precisam ser 'alcançáveis' de fora sofrem com a tradução de endereços
- P2P (torrent, blockchain)
  - cada participante precisa aceitar conexões de outros pares ➜ sem um regra de entrada 2 host atrás de NAT têm dificuldade de se enxergar diretamente
- VoIP e videochamadas
  - protocolo como SIP carregam o IP interno dentro dos dados do pacote, não só no cabeçalho ➜ NAT comum não sabe reescrever isso
- jogos onlines ➜ Sessões multiplayer hospedadas por um jogador (P2P) exigem que outros consigam se conectar diretamente a ele — geralmente requer port forwarding

#### NAT traversal
- técnica usada por aplicações modernas para funcionar mesmo atrás de um ou mais NATs
- STUN - Session Traversal Utilities for NAT
  - descobre o endereço público
  - um servidor externo informa ao host qual endereço público e porta o NAT está usando para ele, permitindo compartilhar isso com o outro lado da conexão
- TURN - Traversal Using Relays around NAT
  - retransmite quando não dá
  - quando a conexão direta é impossível (NAT muito restritivo), um servidor intermediário retransmite todo o tráfego entre as duas pontas
- ICE - Interactive Connectivity Establishment
  - escolhe a melhor rota
  - framework que testa várias possibilidades e escolhe automaticamente a que funciona ➜ usado por WebRTC em videochamadas no navegador

<div align="center">
  <img width="610" height="409" alt="image" src="https://github.com/user-attachments/assets/598a5fa0-4dd0-4063-a1ce-cd7f15493eaf" />
</div>


# NAT e Segurança
- resolve ➜ oculta a topologia interna
  - invasor externo não consegue endereçar diretamente um host atrás do NAT — ele só enxerga o endereço público do roteador
  - isso dificulta o reconhecimento direto de hosts internos   
- não resolve ➜ não filtra, não inspeciona, não autentica
  - NAT não decide o que é tráfego malicioso, não aplica regras de acesso e não substitui um firewall com inspeção de pacotes
  - sempre deve ser complementado por controles explícitos. 
