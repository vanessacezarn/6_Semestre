package atividadermi;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import servidor.Pessoa;

public class GerarEmail extends UnicastRemoteObject implements IGerarEmail {
    public GerarEmail() throws RemoteException{
        
    }

    @Override
    public Pessoa gerarEmail(String s) throws RemoteException {
        Pessoa p = new Pessoa(s);
        return p;
    }    
}
