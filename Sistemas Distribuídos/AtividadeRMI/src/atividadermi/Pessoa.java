package atividadermi;

import java.io.Serializable;

public class Pessoa implements Serializable{
    
    String nome;
    String email;

    public Pessoa(String nome, String email) {
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

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", email=" + email + '}';
    }
    
    
    
    
}
