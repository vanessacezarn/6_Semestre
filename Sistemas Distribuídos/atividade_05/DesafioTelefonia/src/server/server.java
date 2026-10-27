package server;

import Arquivo.CarregarArquivo;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.HashMap;
import model.Sessao;
import rmi.IVerificaSessao;
import rmi.VerificaSessao;

public class server {
    /*Endereço usado para registrar o serviço remoto*/
    String HOST_URL = "rmi://localhost/VerificaSessao";

    public server() {
        try {
            /*O servidor carrega as sessões do arquivo e armazena os dados em um HashMap*/
            HashMap<String, Sessao> sessoes = new HashMap<>();

            String caminhoProjeto = System.getProperty("user.dir");
            String caminhoArquivo = caminhoProjeto + "/telephony_sessions.txt";
            
            CarregarArquivo.carregarArquivo(sessoes, caminhoArquivo);
            System.out.println("Sessões carregadas: " + sessoes.size());
            
            /*Inicia o registro RMI, que permite localizar os serviços remotos*/
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

            /*Cria o objeto remoto VerificaSessao, que verifica as sessoes*/
            IVerificaSessao objetoRemoto = new VerificaSessao(sessoes);

            /*Registra o objeto remoto para que os clientes possam acessá-lo*/
            Naming.bind(HOST_URL, objetoRemoto);
            System.out.println("Servidor online e à espera de clientes...");

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

    public static void main(String args[]) {
        new server();
    }
}
