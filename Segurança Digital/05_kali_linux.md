# Kali Linux
- distribuição Debian voltada especificamente para testes de invasão e auditoria de segurança
- mantida pela Offensive Security ➜  distro oficial usada em certificações como OSCP e em pentests profissionais no mundo
- ferramentas pré-instaladas ➜  Nmap, Wireshark, nikto, gobuster, enem4linux
- voltada para reconhecimento e exploração ➜  organizada por fase do teste de invasão: coleta, varredura, exploração, pós-exploração
## Estrutura do sistema - FHS
- Filesystem Hierarchy Standard (FHS) ➜ sistema de arquivo
- todo Linux organiza seus arquivos a partir de uma raiz única (/)
<div align="center">
  <img width="578" height="166" alt="image" src="https://github.com/user-attachments/assets/7f9778b7-e6d9-4c11-9c05-5701308a1d3d" />
</div>

### Navegação básica
|comando|explicação|
|:-----:|:--------:|
|pwd | mostra o diretório atual|
|ls  |lista o conteúdo do diretório atual|
|ls -la| lista tudo, inclusive ocultos, em formato detalhado(permissões, dono, tamanho|
|cd/caminho| muda para o diretório informado|
|cd ..| sobe um nível no diretório|
|cd ~ | vai direto para o diretório home do usuário|

### Manipulação de arquivos e diretórios
|comando|explicação|
|:-----:|:--------:|
|mkdir pasta | cria um novo diretório|
|touch arq.txt | cria um arquivo vazio|
|cp origem destino | copia um arquivo ou diretório (-r)|
|mv origem destino | move ou renomeia um arquivo|
|rm arquivo | remove um arquivo ou diretório (-r)|
|cat arquivo | exibe todo o conteúdo do arquivo|
|less arquivo | exibe o conteúdo com rolagem/paginação|
|nano / vim arquivo | abre editores de texto no terminal|
| head -n 20 arquivo | mostra as primeiras 20 linhas do arquivo |
| tail -n 20 arquivo | mostra as últimas 20 linhas do arquivo |
| tail -f /var/log/auth.log | acompanha um log em tempo real, linha a linha |
| wc - l resultado.txt | conta linhas (útil para saber quantas portas o grep encontrou) |


### Wildcards e Globbing
- padrões para selecionar vários arquivos de uma vez

|comando|explicação|exemplo|
|:-----:|:--------:|:-----:|
| * | qualquer sequência de caracteres | ls *.txt|
| ? | um único caracteres qualquer | ls arquivo?.txt|
| [abc] | qualquer caractere dentro do conjunto | ls img[12].png|
| {a,b} | expansão de chaves(brace expansion) | cp arquivi.{txt,bak} |

### Busca de arquivo: find e locate
- busca em toda a árvore de diretórios por nome, tipo ou permissão

|comando|explicação|
| :---: | :------: |
| find / -name "*.conf" | busca por nome a partir da raiz do sistema|
| find . tyoe f -ntime -7 | arquivos modificados nos últimos 7 dias |
| find / -perm -4000 2>/dev/null | arquivos com bit SUID (relevante para escalonamento de privilégio |
| locate nome | busca rápida usando um índice pré-construido (updatedb) |

### Links simbólicos
- atalho que aponta para outro arquivo ou diretório, sem duplicar

|comando | explicação|
| :---:  | :------: |
|ln - s alvo link | cria um link simbólico chamado 'link' apontado para 'alvo' |
| ls -l | mostra o link com uma seta (➜) indicando o alvo original |
| rm link | remove apenas o link (o arquivo original segue intacto) |

### Permissões- rwx e notação octal 
- cada arquivo tem permissões de leitura (r), escrita(w) e execução (x) para dono, grupo e outros

<div align="center">
  <img width="576" height="225" alt="image" src="https://github.com/user-attachments/assets/acb99295-5978-49d1-9918-0b37032dcae4" />
</div>

- notação octal: 754
  - dono tem todas as permissões: 4(r) + 2(w) + 1(x) = 7
  - grupo tem as permissões: 4(r) + 1(x) = 5 
  - outros: 4 (r)
- chmod ➜ altera as permissões de um arquivo
- chown ➜ altera o dono e/ou grupo de um arquivo
- SYN scan (-sS) monta pacotes TCP brutos (algo que o kernel só permite a processos com privilégios de root), por isso o nmap -sS e vários scripts do NSE pedem sudo (ele precisam de um nível de acesso o dono comum do sistema não tem por padrão)

### Usuários, grupos e privilégios
- sudo e su resolvem o mesmo problema de formas diferentes ➜ elevar privilégios
<div>
  <img width="600" height="162" alt="image" src="https://github.com/user-attachments/assets/5ffcad47-dd5f-456c-b5ed-eefb5c63337a" />
</div>

### mais comandos

| comando | explicação |
| :-----: | :--------: |
| man nmap | abre o manual completo do comando (q para sair)|
| nmap --help  | mostra um resumo rápido das opções de uso |
| apropos porta | busca comandos relacionados a um termo |
| man - k rede | equivalente a apropos |
| history | lista os comandos já executados na sessão |
| ctrl + r | busca reversa no histórico de comandos |
| tab | autocompleta comandos, caminhos e arquivos |
| alias nm="nmap -sV -T4" | cria atalho para comando longo |
| df -h | espaço livre e usado por partição, em formato legível |
| du -sh pasta/ | tamanho total de uma pasta específica |
| du -sh * (barra vertical) sort -h | ordena o tamanho das pastas do menor para o maior |
| tar -czvf pacote.tar .gz pasta/| compacta um diretório inteiro em um único arquivo |
| tar -xzvf pacote.tar .gz | extrai o conteúdo de um pacote .tar.gz |
| zip -r pacote.zip pasta/ | compacta em formato .zip |
| unzip paxote.zip | extrai o conteúdo de um arquivo .zip|

### Redirecionamentos e pipes
- conectar a saída de um comando a um arquivo ou à entrada de outro comando
<div>
  <img width="615" height="226" alt="image" src="https://github.com/user-attachments/assets/771fda81-2123-41c7-97de-2dd0e8bd19f4" />
</div>

- -oN também é redirecionamento

| comando | explicação |
| :-----: | :--------: |
| nmap -oN saida.txt | formato nativo do Nmap - equivalente a usar > por dento|
| nmap alvo > saida.txt  | redirecionamento genérico do shell |
| nmap alvo (barra vertical) grep opne | pipe - filtra a saída em tempo real, sem salvar em arquivo |

### Processos
- todo processo em execução, inclusive um scan em andamento, é um processo

| comando | explicação |
| :-----: | :--------: |
| ps | lista os processos em execução na sessão atual|
| ps aux | lista todos os processos do sistema, de todos os usuários |
| top/htop | monitor interativo de processos em tempo real (CPU, memória) |
| kill PID | encerra um processo pelo seu identificador (PID) |
| comando & | executa um comando em segundo plano(background) |

### Gerenciamento de Pacotes (apt)

| comando | explicação |
| :----:  | :--------: |
| apt update | atualiza a lista de pacotes disponíveis nos repositórios |
| apt upgrade | atualiza os pacotes já instalados para a versão mais recente |
| apt install gobuster | instala uma ferramenta específica |
| apt remove pacote | remove um pacote instalado |

### Comando de rede básicos

| comando | explicação |
| :----:  | :--------: |
| ip a | mostra as interfaces de rede e endereços IP da máquina |
| ss -tuln | lista as portas e conexões abertas localmente |
| ping alvo | testa conectividade básica (ICMP) com um host  |
| curl/wget URL | faz requisições HTTP direto do terminal |
| nc host porta | conecta manualmente a um serviço (banner grabbing) |

### Conectando a host remotos : SSH

| comando | explicação |
| :----:  | :--------: |
| ssh usuario@host | conecta a um host remoto via SSH |
| ssh -p 2222 usuario@host | especifica uma porta diferente da padrão 22 |
| scp arquivo usuario@host:/destino | copia um arquivo para o host remoto |
| ssh-keygen | gera um par de chaves para autenticação sem senha |

### Variáveis de ambiente e PATH
- como o terminal sabe onde encontrar o executável de um comando como nmap
- variável de ambiente ➜ um valor nomeado disponível para os programas da sessão
- PATH ➜ lista de diretórios onde o shell procura executáveis
- export VAR=valor ➜ define uma variável de ambiente na sessão atual

