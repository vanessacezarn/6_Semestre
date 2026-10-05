package cliente;

import java.rmi.Naming;
import javax.swing.JOptionPane;
import servidor.Pessoa;

public class Client {
    public static void main(String[] args){
        try {
            IGerarEmail cliente = (IGerarEmail) Naming.lookup("rmi://10.103.16.2/GerarEmail");
            String frase = JOptionPane.showInputDialog("Digite uma nome completo: ");
            Pessoa p = cliente.gerarEmail(frase);
            System.out.println("A pessoa com o email gerado é: ");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
