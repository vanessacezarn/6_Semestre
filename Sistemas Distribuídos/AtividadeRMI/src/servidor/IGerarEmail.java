/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servidor;
import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IGerarEmail extends Remote {
    public Pessoa gerarEmail (String s) throws RemoteException;
}
