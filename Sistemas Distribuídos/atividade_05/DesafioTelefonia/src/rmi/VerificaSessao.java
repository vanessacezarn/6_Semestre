package rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import model.Sessao;

/*implementa o serviço remoto*/
public class VerificaSessao extends UnicastRemoteObject implements IVerificaSessao {
    /*sessoes carregadas pelo servidor*/
    private HashMap<String, Sessao> sessoes;
    /*recebe e armazena o mapa de sessoes*/
    public  VerificaSessao(HashMap<String, Sessao> sessoes) throws RemoteException{
        this.sessoes = sessoes;
    }
    
    @Override
    public String verificaSessao(String numeroCelular) throws RemoteException{
        /*busca a sessao pelo numero informado*/
        Sessao sessao = sessoes.get(numeroCelular);
        /*verifca e retorna os dados da sessao*/
        if (sessao != null){
            return sessao.getDadosSessao();
        }
        return null;/*para casode não existir uma sessao para o numero informado*/
    }
}

