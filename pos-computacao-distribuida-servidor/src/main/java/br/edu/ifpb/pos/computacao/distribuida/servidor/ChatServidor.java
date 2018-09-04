package br.edu.ifpb.pos.computacao.distribuida.servidor;

import br.edu.ifpb.pos.computacao.distribuida.shared.Cliente;
import br.edu.ifpb.pos.computacao.distribuida.shared.Servidor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class ChatServidor extends UnicastRemoteObject implements Servidor {

    private List<Cliente> clientes;

    public ChatServidor() throws RemoteException {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void comentar(String nick, String mensagem) throws RemoteException {
        for (Cliente cliente : clientes) {
            cliente.atualizar(nick + ": " + mensagem);
        }
    }

    @Override
    public String inscrever(Cliente cliente) throws RemoteException {

        for (Cliente c : clientes) {
            if (c.getNick().equals(cliente.getNick())) {
                return "erro";
            }
        }

        clientes.add(cliente);
        System.out.println(cliente.getNick() + " conectado(a)!");

        return "ok";
    }

    @Override
    public void sairDoChat(Cliente cliente) throws RemoteException {
        String nick = cliente.getNick();
        clientes.remove(cliente);
        System.out.println(nick + " saiu.");
    }

}
