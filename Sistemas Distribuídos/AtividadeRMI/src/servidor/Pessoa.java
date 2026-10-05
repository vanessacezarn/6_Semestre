package servidor;

import java.io.Serializable;

public class Pessoa implements Serializable{
    String nome;
    String email;

    public Pessoa(String nome) {
        this.nome = nome;
        this.email = gerarEmail();
    }

    public Pessoa() {
    }
    
    
    private String gerarEmail(){
        String palavras[];
        palavras = this.nome.split(" ");
        String email = palavras[0]+"."+palavras[palavras.length-1]+"@ufn.edu.br";
        email = email.toLowerCase();
        return email;
    }
    
    
    
}
