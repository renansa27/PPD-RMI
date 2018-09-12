package rmiPPD;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Registrador {

    public static void main(String args[]) {

        JTextField ip = new JTextField();
        JTextField porta = new JTextField();
        Object[] servidor = {
            "Ip", ip,
            "Porta", porta
        };
        int opcao = JOptionPane.showConfirmDialog(null, servidor, "Dados para conexão", JOptionPane.CANCEL_OPTION);
        if (opcao == JOptionPane.OK_OPTION) {
            try {
                LocateRegistry.createRegistry(Integer.parseInt(porta.getText()));
                ServidorPPD obj = new ServidorPPD();

                try {
                    //Registra no servidor de nomes
                    Naming.rebind("//" + ip.getText() + "/GameService", obj);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Registrador.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Servidor Registrado!");

            } catch (RemoteException ex) {
                Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não criado!");
        }
    }
}
