``` .vhdl
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity componentes_sistema is
    A,B,C : in bit;
    X : out bit
end componentes_sistema;

architecture arquitetura_sistema of componentes_sistema is
    component component_and
        port(e: in bit; f: in bit; g: out bit)
    end component
    component component_or
        port(h: in bit; i: in bit; j: out bit)
    end component
      
    signal s1, s2 : bit;
    
begin
    and1 : component_and port map (e => A, f=> B, g => s1); 
    and2 : component_and port map (e => B, f=> C, g => s2);
    or: component_or port map(h => s1, i => s2, j =>X);
    
end arquitetura_sistema;
```
<div align="center">
  <img width="202" height="129" alt="{FA843EE8-2C4B-49CE-B597-1C530770B981}" src="https://github.com/user-attachments/assets/e2cff904-24d7-4258-9610-68b69006b065" />
  
</div>
