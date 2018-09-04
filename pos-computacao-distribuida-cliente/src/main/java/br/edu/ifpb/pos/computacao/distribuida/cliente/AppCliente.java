package br.edu.ifpb.pos.computacao.distribuida.cliente;

import br.edu.ifpb.pos.computacao.distribuida.shared.Cliente;
import br.edu.ifpb.pos.computacao.distribuida.shared.Servidor;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class AppCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o seu nick: ");
        String nick = scanner.nextLine();

        try {
            Servidor servidor = (Servidor) Naming.lookup("//localhost:1099/Servidor");
            Cliente cliente = new ChatCliente(nick);

            String retorno = servidor.inscrever(cliente);

            if (retorno.equals("ok")) {
                System.out.println(cliente.getNick() + " conectado(a)!");
                String msg;

                while (true) {
                    msg = scanner.nextLine();
                    servidor.comentar(nick, msg);
                    if (msg.equals("sair")) {
                        servidor.sairDoChat(cliente);
                        System.out.println(nick + " saiu.");
                        System.exit(0);
                    }
                }
            } else {
                System.out.println("Já existe um usuario com essse nick.");
                System.exit(0);
            }

        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(AppCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
