package Server;

import Model.Pessoa;
import View.ServidorInterface;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Thread responsável pelo atendimento de um cliente conectado ao servidor.
  * Recebe um objeto Pessoa, verifica se ele já está cadastrado, gera o e-mail para 
  * novos cadastros, adiciona a pessoa à lista e devolve o objeto processado ao cliente
 *
 * O acesso à lista compartilhada é sincronizado para evitar condições de corrida 
 * entre diferentes clientes.
 *
 */

public class ClienteThread extends Thread {
    private Socket cliente;
    private ArrayList<Pessoa>lista;
    private ServidorInterface interfaceServidor;

    public ClienteThread(Socket cliente, ArrayList<Pessoa> lista, ServidorInterface interfaceServidor) {
        this.cliente = cliente;
        this.lista = lista;
        this.interfaceServidor = interfaceServidor;
    }

    public void run(){
        try{
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            Pessoa pessoa = (Pessoa) entrada.readObject();
            interfaceServidor.adicionarLog("Pessoa recebida: " + pessoa.getNomeCompleto()+ " - " + pessoa.getDtNascimento());
            Pessoa pessoaEncontrada = null;
            boolean pessoaNova = false;
            //verificar se a Pessoa já existe
            synchronized(lista){
                if (lista.contains(pessoa)) {
                    for (Pessoa p : lista) {
                        if (p.equals(pessoa)) {
                            pessoaEncontrada = p;
                            break;
                        }
                    }
                } else {
                    // Gerar o e-mail
                    String[] partesNome = pessoa.getNomeCompleto().split("\\s+");
                    String primeiroNome = partesNome[0].toLowerCase();
                    String ultimoSobrenome = partesNome[partesNome.length - 1].toLowerCase();
                    int anoNascimento = pessoa.getDtNascimento().getYear();
                    String email =  primeiroNome + "."+ ultimoSobrenome + "." + anoNascimento + "@ufn.edu.br";
                    pessoa.setEmail(email);
                    // Adicionar na lista
                    lista.add(pessoa);
                    pessoaEncontrada = pessoa;
                    pessoaNova = true;
                }
            }
            
            //informa a interface 
            if(pessoaNova){
                interfaceServidor.adicionarLog("E-mail gerado: " +pessoa.getEmail());
                interfaceServidor.adicionarPessoa(pessoa);
            }else{
                interfaceServidor.adicionarLog("Pessoa já cadastrada");
            }
            
            // Devolver a Pessoa para o cliente
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            
            saida.flush();
            saida.writeObject(pessoaEncontrada);

            saida.close();
            entrada.close();
            cliente.close();
            

        }catch(IOException | ClassNotFoundException e){
            System.out.println("Erro no atendimento ao cliente: " + e.getMessage());
        }
    }            
}   