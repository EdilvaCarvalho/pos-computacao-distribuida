package br.edu.ifpb.pos.computacao.distribuida.cliente;

import br.edu.ifpb.pos.computacao.distribuida.shared.Cliente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Edilva
 */
public class ChatCliente extends UnicastRemoteObject implements Cliente {

    private String nick;

    public ChatCliente(String nick) throws RemoteException {
        this.nick = nick;
    }

    @Override
    public void atualizar(String mensagem) throws RemoteException {
        System.out.println(mensagem);
    }

    @Override
    public String getNick() throws RemoteException {
        return this.nick;
    }

}
