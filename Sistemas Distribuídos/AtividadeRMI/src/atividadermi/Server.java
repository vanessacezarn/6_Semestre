package atividadermi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    
    String HOST_URL = "rmi://localhost/GerarEmail";
    
    public Server(){
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            GerarEmail objetoRemoto = new GerarEmail();
            Naming.bind(HOST_URL, objetoRemoto);
            System.out.println("Servidor online e no aguardo....");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    public static void main(String args[]) {
        new Server();
    }
}

