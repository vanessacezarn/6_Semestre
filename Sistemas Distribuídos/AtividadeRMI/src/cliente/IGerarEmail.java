package cliente;

import java.rmi.RemoteException;
import java.rmi.Remote;
import servidor.Pessoa;

public interface IGerarEmail extends Remote {
    public Pessoa gerarEmail (String s) throws RemoteException;
}
