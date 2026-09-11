package Model;

import java.time.LocalDate;

public class Pessoa {

    private String nomeCompleto;
    private LocalDate dtNascimento;
    private String email;

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

    public Pessoa(String nomeCompleto, LocalDate dtNascimento) {
        this.nomeCompleto = nomeCompleto;
        this.dtNascimento = dtNascimento;
    }

    public Pessoa() {
    }
    

    

}
