package rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;

/*interface do servico remoto*/
public interface IVerificaSessao extends Remote{
        /*recebe o numero do celular e retorna os dados da sessao*/
        public String verificaSessao(String numeroCelular) throws RemoteException;

}
