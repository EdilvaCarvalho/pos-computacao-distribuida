package br.edu.ifpb.pos.computacao.distribuida.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Edilva
 */
public interface Servidor extends Remote {

    void comentar(String nick, String mensagem) throws RemoteException;

    String inscrever(Cliente cliente) throws RemoteException;

    void sairDoChat(Cliente cliente) throws RemoteException;
}
