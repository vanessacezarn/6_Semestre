# Sistemas Digitais
### ➤ Competências da disciplina
 ➥ Unidade 1: Flip-flops e latches

 ➥ Unidade 2: Projeto de circuitos sequenciais por meio de máquinas de estados finitos

 ➥ Unidade 3: Conversão digital-analógico e analógico-digital

 ➥ Unidade 4: Noções de HDL
 
---
### ➤ orientações para o semestre:
- revisar conceitos de:
  - portas lógicas: circuitos lógicos compostos por elementos de chaveamento que implementa as operações booleanas
    - |Porta Lógica|Símbolo|Tabela Verdade|Expressão|
      | :----:  |  :----: | :----:| :----: |
      |and|<img width="53" height="45" alt="{E5EF024D-53E6-4EC1-8817-A6954055BBC6}" src="https://github.com/user-attachments/assets/9428bc69-7578-4bfe-a468-edb15ccd816f" />|<img width="94" height="119" alt="{C7FD2CB1-5C56-463B-98B9-C1616AF4F290}" src="https://github.com/user-attachments/assets/11d46537-b328-4bea-a14f-2894ffec6a60" />|S = A ⋅ B|
      |or|<img width="54" height="44" alt="{BEEE519F-BEAC-4057-92DC-CAD4450212A0}" src="https://github.com/user-attachments/assets/75aea25c-8edf-4c79-b5ac-b7c46df2862e" />|<img width="93" height="116" alt="{3FD34B19-BD15-425A-8D13-DEA5C0953546}" src="https://github.com/user-attachments/assets/41dbe9bd-55a0-42cc-8924-899b0c1ae5ea" />|S = A + B|
      |not|<img width="55" height="48" alt="{4E441449-0226-4E1C-9658-B4C52894CD95}" src="https://github.com/user-attachments/assets/96ce2acf-337a-4c79-b3b1-1cb1cf524fcd" />|<img width="65" height="77" alt="{098E9C67-3EE3-4C68-A809-B7E104A0E0BF}" src="https://github.com/user-attachments/assets/c1f051e9-db80-4bb9-bd30-fd6152056c94" />|S = Ā|
      |nand|<img width="53" height="46" alt="{C860E5BB-A8BC-4F27-88CF-1AEB4575606F}" src="https://github.com/user-attachments/assets/29718781-587d-4a9c-a116-6b97102429db" />|<img width="94" height="113" alt="{2A283A96-2D8E-49C7-A11E-D77158E43E87}" src="https://github.com/user-attachments/assets/fe4e4760-e6cb-4e82-a55b-3f31a1073c16" />|<img width="76" height="28" alt="image" src="https://github.com/user-attachments/assets/9ecd7f3d-f51b-4cad-8623-59433ccb4a96" />|
      |nor|<img width="55" height="50" alt="{40CBB5E6-83C0-40B0-AB9C-95254F62C78A}" src="https://github.com/user-attachments/assets/2aeed55b-7004-4bee-babe-71e44e532a5a" />|<img width="94" height="124" alt="{2867F826-2F06-4925-9D42-70DFB2E5DD71}" src="https://github.com/user-attachments/assets/0f5bb536-c8aa-49c2-baf6-ce1a6d4dfc01" />|<img width="82" height="20" alt="image" src="https://github.com/user-attachments/assets/493d873c-2d84-4e26-b017-9733239afa1e" />|
      |xor|<img width="54" height="50" alt="{FD4BA8DA-E070-4576-872F-C869F2FF975E}" src="https://github.com/user-attachments/assets/6d806df0-bd9c-4dbb-9b00-8a7b918683a8" />|<img width="94" height="113" alt="{2A19B8ED-D7E1-4ED9-BDC9-D6CF1D59D2CB}" src="https://github.com/user-attachments/assets/36b80d45-15ca-4282-bfcb-a2a16da41a41" />|<img width="79" height="28" alt="image" src="https://github.com/user-attachments/assets/0c341d41-6772-44f5-b7fe-921e2efbd1d3" />
      |xnor|<img width="54" height="52" alt="{87CAE584-B3C1-47E5-8910-2E3823839C36}" src="https://github.com/user-attachments/assets/dc8d2179-825c-43ef-96b6-f1b0cd1e4571" />|<img width="90" height="110" alt="{015993A1-CF8C-4134-988E-51959C4E6F02}" src="https://github.com/user-attachments/assets/07c3b3b9-c2c7-427f-9fd7-511de740eadf" />|<img width="82" height="21" alt="image" src="https://github.com/user-attachments/assets/3c144af1-9f15-4ca3-9e18-338963ff881a" />


  - sistemas analógicos: são sistemas eletrônicos que processam sinais contínuos no tempo e na magnitude, variam infinitamente entre valores mínimos e máximos. Exemplos comuns incluem o som ambiente, a temperatura e os discos de vinil
  - sistemas digitais: sistemas eletrônicos que processam informações por meio de valores discretos (finitos), utilizam o sistema binário, representando dados exclusivamente por dois estados: 0 (desligado) e 1 (ligado). Computadores, smartphones e memórias flash são exemplos de tecnologias puramente digitais.
  - circuitos digitais: são os componentes eletrônicos que realizam  processamento dos sistemas digitais, usam combinações de portas lógicas para manipular impulsos elétricos de tensão e executar operações aritméticas e lógicas.
  - equações booleanas:
    - soma do produto: soma das saídas que são 1
    - produto da soma (não vai ser utilizado) 
- por que o computador utiliza binário? pq ele trabalha com energia
- quais os níveis de tensão que representam 0 e 1?
  - 0 ➜ 0v - 0,8v
  - 1 ➜ 2,5v - 5v
