package rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class encurtaUrl extends UnicastRemoteObject implements IencurtaUrl{

    public encurtaUrl() {
    }
    
    
    
    public String encurtaUrl(String numeroCelular) throws RemoteException{
        
        return null;/*para casode não existir uma sessao para o numero informado*/
    }
}
