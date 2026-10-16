package Model;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * Representa uma pessoa cadastrada no sistema, armazena nomeCompleto, dtNascimento e e-mail
 * Utiliza Serializable para permitir que objetos Pessoa sejam enviados através da rede
 * utilizando streams de objetos
 */
public class Pessoa implements Serializable{

    private String nomeCompleto;
    private LocalDate dtNascimento;
    private String email;

    public Pessoa(String nomeCompleto, LocalDate dtNascimento) {
        this.nomeCompleto = nomeCompleto;
        this.dtNascimento = dtNascimento;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nomeCompleto, other.nomeCompleto)) {
            return false;
        }
        return Objects.equals(this.dtNascimento, other.dtNascimento);
    }  
    
    @Override
    public int hashCode() {
        return Objects.hash(nomeCompleto, dtNascimento);
    }

    @Override
    public String toString() {
        return nomeCompleto + " - " + dtNascimento + " - " + email;
    }
    
    

}
