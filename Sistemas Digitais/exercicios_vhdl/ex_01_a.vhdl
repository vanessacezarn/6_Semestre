library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity componentes_sistema is
    A : in bit;
    B : in bit;
    C : in bit;
    D : in bit;
    W : out bit
end componentes_sistema;

architecture arquitetura_sistema of componentes_sistema is
    component component_or
        port(e: in bit; f: in bit; g: out bit)
    end component
    component component_and
        port(h: in bit; i: in bit; j: out bit)
    end component
    signal s1, s2 : bit;
    
begin
    or1 : component_or port map (e => A, f=> B, g => s1); 
    or2 : component_or port map (e => C, f=> D, g => s2);
    and: component_and port map(h => s1, i => s2, j =>W);
    
end arquitetura_sistema;
