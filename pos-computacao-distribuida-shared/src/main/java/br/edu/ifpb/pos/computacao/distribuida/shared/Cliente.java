package br.edu.ifpb.pos.computacao.distribuida.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Edilva
 */
public interface Cliente extends Remote {

    void atualizar(String mensagem) throws RemoteException;
    
    String getNick() throws RemoteException;
}
