package Server;

import Model.Pessoa;
import View.ServidorInterface;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Responsável por aguardar conexões de clientes utilizando Socket TCP. Para cada 
 * cliente conectado, uma nova ClienteThread é criada
 *
 * A execução do servidor ocorre em uma thread própria, evitando que a interface 
 * gráfica fique bloqueada durante a espera por novas conexões.
 */
public class Servidor extends Thread {
    private ArrayList<Pessoa> lista;
    private ServidorInterface interfaceServidor;

    public Servidor(ArrayList<Pessoa> lista, ServidorInterface interfaceServidor) {
        this.lista = lista;
        this.interfaceServidor = interfaceServidor;
    } 

    @Override
    public void run() {
        try {
            int portaServidor = 50000;
            ServerSocket servidor = new ServerSocket(portaServidor);
            System.out.println("Servidor ouvindo a porta: " + portaServidor);

            while (true) {
                Socket cliente = servidor.accept();
                ClienteThread thread = new ClienteThread(cliente, lista,interfaceServidor);
                thread.start();
            }
        }catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }       
    }
    
}