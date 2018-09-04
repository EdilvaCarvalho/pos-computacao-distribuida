package br.edu.ifpb.pos.computacao.distribuida.servidor;

import br.edu.ifpb.pos.computacao.distribuida.shared.Servidor;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class AppServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Servidor servidor;
        try {
            servidor = new ChatServidor();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("//localhost:1099/Servidor", servidor);
            System.out.println("Servidor conectado.");
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(AppServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
