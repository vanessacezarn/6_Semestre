# Varredura de portas
- varredura ➜ descobrir portas abertas e serviços ativos no alvo
- port scanning ➜ técnica de enviar pacotes especialmente formados para um conjunto de portas de um host, e interpretar as repostas, ou falta delas, para descobrir quais serviços estão escutando ali
  - reconhecimento passivo (whois, DNS) revela domínios e IPs, já a varredura revela o que está ativo neles
- 3 estados possíveis de uma porta ➜ de acordo com a resposta que um scanner recebe ao rodar um SYN
  - SYN-ACK ➜ porta aberta ➜ serviço responde normalmente
  - RST ➜ porta fechada ➜ host ativo, porta sem serviço
  - sem resposta ➜ porta está sendo filtrada ➜ firewall descartou o pacote
- tipos de scan TCP

| tipo | tambémChamado | funcionamento | características |
|:----:|:---------:    | :----------: |  :-------:|   
|SYN scan|Half-open/stealth|envia SYN, recebe SYN-ACK, mas nunca completa com ACK|rápido e mais usado, exige privilégio administrativo|
|Connect scan|TCP connect|completa o handshake normalmente, como uma aplicação real|mais lento e detectável, não exige privilégio especial|
|ACK scan|-|envia apena ACK, sem handshake prévio|não detecta porta aberta, mapeia regras de firewall|
|FIN/NULL/XMAS|Scan stealth|envia flags incomuns fora de contexto|tenta passar despercebido por firewalls simples|

- velocidade da varredura ➜ timing templates
  - flag -T define o equilíbrio entre velocidade e discrição
    - -T4 ➜ padrão recomendado
    -  -T0/-T1 servem para evasão deliberada
    -  -T5 arrisca perder respostas
<div align="center">
  <img width="707" height="93" alt="image" src="https://github.com/user-attachments/assets/8048615d-fb54-46ac-a41b-a4d1d97a5eb3" />
</div> 

- diferença entre varredura TCP e UDP
  - TCP ➜ possui handshake
    - handshake: processo de negociação e autenticação entre dois dispositivos para estabelecer uma conexão segura e confiável
    - ausência de resposta significa geralmente que a porta está sendo filtrada ➜ comportamento previsível e rápido de interpretar
  - UDP ➜ sem hanshake
    - sem resposta ➜ porta aberta ou filtrada
      - forma de confirmar ➜ enviar um payload específico do protocolo e esperar uma resposta, ou não, da aplicação
    - processo mais lento e difícil
- um scan de fora para dentro atinge apenas o endereço público do roteador
  - antes do NAT o scan vê apenas o ip público e as portas explicitamente encaminhadas
  - depois de de um acesso inicial ➜ quando consegue acessar um host, o invasor enxerga a rede local como qualquer outro dispositivo dela
<div align="center">
  <img width="671" height="296" alt="image" src="https://github.com/user-attachments/assets/5172c098-89d7-4fe3-9fa8-a313d3039064" />

</div>

## Nmap - Network Mapper
- ferramenta padrão de mercado, criada em 1997 e de código aberto
- utilizada em pentests profissionais, CTFs e certificações da área
- realiza:
  - varre portas TCP/UDP
  - identifica versões de serviços
  - detecta sistema operacional
  - roda scripts de enumeração
- onde roda:
  - linha de comando: Linux, Windows e macOS
  - interface gráfica - Zenmap
- dominá-la facilita aprender outras ferramentas

### sintaxe 
- nmap [flag] [alvo]

| Flag | Significado |
| :---:| :---: |
|-sS | SYN scan (half-open), tipo padrão e mais usado |
|-sT | connect scan, completa o handshake, não exige privilégio|
|-sU | varreduras de portas UDP |
|-sV | detecta a versão do serviço rodando em cada porta aberta |
|-O| tenta identificar o sistema operacional do alvo|
|-p| define quais portas varrer |
|-A| modo agressivo, combina -sV, -O e scripts básicos|
|-T4| define a velocidade do scan|
 
### exemplos de comandos nmap
  - varre todas as 65.535 portas TCP com SYN scan ➜ reconhecimento completo, mas lento
    - ```
      nmap -sS -p alvo
      ```
  - detecta versões de serviços e roda os scripts padrão do NSE ➜ bom para um primeiro relatório
    - ```
      nmap -sV -sC alvo
      ```
  - ignora a checagem de hosts ativos (-Pn) ➜ útil quando o alvo bloqueia ping mas as portas respondem
    - ```
      nmap -Pn -p 80,243 alvo
      ```
  - Combina varredura UDP e TCP na mesma execução, especificando portas por protocolo.
    - ```
      nmap -sU -sS -p U:53,T:22,80 alvo
      ```
  - Salva a saída em um arquivo de texto ➜ essencial para documentar um teste de invasão.
    - ```
      nmap -oN saida.txt alvo
      ```
- qual scan escolher
<div align="center">
  <img width="616" height="285" alt="image" src="https://github.com/user-attachments/assets/35ff86ac-c624-4f75-9bcd-a7acc2e20fd5" />
</div>

### Fingerprinting
- pistas do sistema
- -O compara características da pilha TCP/IP do alvo com uma base de assinaturas conhecidas

|pista|windows|linux|
| :---:| :---: | :---: |
|TTL inicial| 18|64|
|tamanho de janela TCP| 65.535 ou 8.192|5.840 ou 29.200|
|ordem das opções TCP|MSS, NOP, WS, SACK|MSS, SCAK, TS, NOP,WS|
|resposta a pacotes malformados|varia por versão| segue RFC de forma mais estrita

- TTL ➜ pista mais rápida de observar]
  - um TTL de 64 chegando com 61 sugere ~3 saltos até o alvo

---

# Enumeração
- comparada a varredura é mais estreita e profunda
- extrai detalhes de um serviço por vez
### Banner grabbing
- pergunta diretamente ao serviço quem é ele
  - muitos serviços se 'apresentam' ao aceitar uma conexão ➜ essa apresentação é o banner
    - geralmente revela ➜ software e versão exata em uso
- Remover headers desnecessários, especialmente X-Powered-By, X-AspNet-Version e equivalentes
- Desabilitar banners detalhados em SSH, FTP, SMTP etc., quando o serviço permitir
- Não criar banners falsos como principal defesa. Isso é security through obscurity e scanners normalmente conseguem fazer fingerprinting por outros meio
- Manter serviços atualizados. Ocultar a versão reduz reconhecimento, mas não corrige vulnerabilidade
- Fechar portas e serviços desnecessários com firewall/security groups
- Restringir serviços administrativos por VPN, allowlist de IP ou rede interna
- Usar reverse proxy/WAF para evitar exposição direta de aplicações e servidores backend

### O que cada protocolo revela

|serviço|porta|o que enumeração revela|
| :---:| :---: | :---: |
|SMB | 445 | nome do domínio, compartilhamentos, versão do windows, usuários locais |
| FTP | 21 | se aceita login anônimo, versão do servidor, listagem de diretórios |
| SSH | 22 | versão do OpenSSH, algoritmos de criptografia aceitos|
|HTTP/HTTPS | 80/443| tecnologia do servidor web, CMS, diretórios expostos, certificados TLS |
| SNMP | 161 | configuração de rede, uptime, até mesmo credenciais |
| DNS | 53 | transferência de zona mal configurada pode revelar todos os hosts de um domínio|

### Nmap Scripting Engine - NSE
- Nmap também roda scripts de enumeração até a detecção de vulnerabilidaes
- roda uma bateria de scripts de detecção de vulnerabilidade conhecidas contra serviços web encontrados
   -  ```
      nmap --script vuln -p 80,443 192.168.1.20
      ```
- --script default ➜ scripts seguros e rápidos, rodados com -sV -A
- --script safe ➜ não afetam o alvo, apenas coletam informações
- --script vuln ➜ procuram vulnerabilidades conhecidas especificamente

##### outras ferramentas de enumeração
- enum4linux ➜ enumeração completa de compartilhamentos e usuários SMB/Windows
- smbclient ➜ navega e acessa compartilhamentos MB diretamente, como um cliente
- nikto ➜ varredura de vulnerabilidade específica em servidores web
- gobuster/dirb ➜ descobre diretórios e arquivos escondidos em um servidor web

|ferramenta|ponto forte| limitação|
| :---:| :---: | :---: |
| Nmap | detecção de versão, NSE, fingerprinting | mais lento em varreduras muito grande |
| Masscan | varre a internet inteira em minutos| não faz detecção de versão por padrão, menos preciso |
| Zenmap | interface gráfica do Nmap |  Mesmas limitações de velocidade do Nmap |

 - Na prática: Masscan para descobrir hosts ativos em escala, Nmap para aprofundar em cada um

### Evasão
- fragmentação de pacotes (-f) ➜ divide o pacote FTP em fragmentos menores ➜ dificulta a inspeção por firewalls simples
  - firewalls simples inspecionam pacote a pacote ➜ fragmentação pequena dificulta essa análise 
- decoy scan (-D) ➜ mistura IPs falsos com reais ➜ dificulta saber qual origem é o testador de fato


---
### Varredura não autorizada é crime
- A Lei 12.737/2012 tipifica a invasão de dispositivo alheio — e varrer portas de um sistema sem autorização já pode ser enquadrado como preparação ou tentativa, dependendo do contexto e da intenção


