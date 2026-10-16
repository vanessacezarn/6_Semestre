package Controller;

import Model.Pessoa;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
/**
 * Responsável pela comunicação entre a interface gráfica do cliente e o servidor.
 * Estabelece a conexão utilizando Socket TCP, envia os dados da pessoa e recebe do
 * servidor o objeto Pessoa processado.
 */
public class ClienteController {
    private final int porta = 50000;
    
    public Pessoa enviarPessoa(Pessoa pessoa) throws IOException, ClassNotFoundException{
        Socket cliente = new Socket("localhost",porta);
        
        //envia Pessoa para o servidor
        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
        saida.flush();
        saida.writeObject(pessoa);
        
        //recebe Pessoa criada ou localizada no servidor
        ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
        
        Pessoa resposta = (Pessoa) entrada.readObject();
        
        entrada.close();
        saida.close();
        cliente.close();
        
        return resposta;
    }
    
}
