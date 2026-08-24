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
---
## ➢ Modelo TCP-IP, endereçamento e portas de serviço
---
## ➢ Ataques de rede comuns e um estudo de caso real
---
## ➢ Fases e tipos de um teste de invasão autorizado
