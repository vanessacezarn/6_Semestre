package atividadermi;

import java.rmi.Naming;
import javax.swing.JOptionPane;

public class Client {
    public static void main(String[] args){
        try {
            IGerarEmail cliente = (IGerarEmail) Naming.lookup("rmi://10.103.16.2/GerarEmail");
            String frase = JOptionPane.showInputDialog("Digite uma nome completo: ");
            //Pessoa p = cliente.gerarEmail(frase);
            System.out.println(cliente.gerarEmail(frase));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
