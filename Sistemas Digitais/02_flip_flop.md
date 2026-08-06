# Flip-Flop
- circuito digital sequencial que têm a capacidade de armazenar 1 bit de informação
- funcionam como a menor unidade de memória em um sistema digital
- operam com 2 estados estáveis (0 e 1) ➜ muda de estado a partir de um sinal de sincronismo ➜ **CLOCK**
- tipos:
  - SR (Set-Reset) ➜ entradas para ativar e desativar saídas
  - JK ➜ inverte o estado quando ambas entradas são 1 (elimina a condição inválida do SR)
  - D (dado/data) ➜ copia o valor diretamente da entrada para saída
  - T (toggle) ➜ iuando T = 1, alterna o estado da saída a cada pulso de clock; quando T = 0, mantém o estado atual.
- Preset (PR) ➜ força a saída Q = 1, independentemente do clock
  - utilizado para inicializar o flip-flop em nível lógico 1
  - também chamado de Set Assíncrono
- Clear (CLR) ➜ força a saída Q = 0, independentemente do clock
  - utilizado para reinicializar o flip-flop em nível lógico 0
  - também chamado de Reset Assíncrono   

<div align="center">
  
|Tipo|Tabela Verdade|Símbolo|
| :----:  |  :----: |:----:|
| SR |<img width="113" height="110" alt="image" src="https://github.com/user-attachments/assets/75ac5bf0-78c3-4d19-ba70-a980907c18e6" />|<img width="81" height="65" alt="image" src="https://github.com/user-attachments/assets/90c47262-a10c-4670-bb50-95783206e9f4" />|
| JK |<img width="105" height="112" alt="image" src="https://github.com/user-attachments/assets/297d3522-73d6-43e7-8788-0b9a71475b7a" />|<img width="86" height="93" alt="image" src="https://github.com/user-attachments/assets/2fca0c12-cdd5-400e-a661-30534cb3e364" />|
| D  |<img width="93" height="111" alt="image" src="https://github.com/user-attachments/assets/4e1a92fa-e22b-421a-835e-49b77f19cabe" />|<img width="86" height="85" alt="image" src="https://github.com/user-attachments/assets/211dbe68-2131-4c59-8d99-9a41d96e1809" />|
| T  |<img width="119" height="124" alt="image" src="https://github.com/user-attachments/assets/fb7d2392-ac26-4cad-bf17-3915829d1e0e" />|<img width="86" height="85" alt="image" src="https://github.com/user-attachments/assets/07403e2c-05b0-45fa-906a-7ad1dcbf9e98" />|
</div>

### Mestre-Escravo
- dois flip-flops interligados ➜ saída do Mestre um aciona a entrada do Escravo
- cuidado: no primeiro clock somente o mestre pode sofrer mudança de estado
  - Clock ativo: Mestre recebe os dados; Escravo permanece inalterado.
  - Mudança do clock: Escravo copia o estado do Mestre para a saída. 


<div align="center">
  <img width="392" height="144" alt="{4330B7B3-C797-459F-944F-7C7B79264366}" src="https://github.com/user-attachments/assets/d9840da4-5fe4-4c40-a4f7-f7f0c133d639" width="40%" />
  ---
  <img width="397" height="143" alt="{7375615D-8159-4A79-B7B5-958F14373872}" src="https://github.com/user-attachments/assets/8f1fe08e-00fb-4d8b-bfa3-5bed57524e93" width="40%" />

</div>

### Exercícios:
<div align="center">
  <img width="1355" height="531" alt="{607B9B7A-A28D-489F-9763-C545C5BD8753}" src="https://github.com/user-attachments/assets/356a75be-36ed-4dbe-9317-d9895390cba1" />

  <img width="399" height="128" alt="image" src="https://github.com/user-attachments/assets/c783415c-d2d0-41ae-bee0-bdac91e49004" />
  <img width="444" height="144" alt="image" src="https://github.com/user-attachments/assets/b5232f28-d388-4b57-a59b-23fbcd5e9bd1" />

  <img width="540" height="207" alt="image" src="https://github.com/user-attachments/assets/0b422096-3fa6-4b94-a9b7-fb83ac7eb005" />
  <img width="452" height="236" alt="image" src="https://github.com/user-attachments/assets/f8919c71-bbe1-48a5-abe4-4482e0141bde" />




</div>



