package rmiPPD;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.RemoteRef;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorPPD extends UnicastRemoteObject implements ServidorItf {

    private ArrayList<Jogador> clients = new ArrayList<>();

    public ServidorPPD() throws RemoteException {
        super();
        System.out.println("Servidor criado!");
    }

    public String sayHello(String ClientName) throws RemoteException {
        System.out.println(ClientName + " sent a message");
        return "Hello " + ClientName + " from group chat server";
    }

    /**
     * Send a string ( the latest post, mostly ) to all connected clients
     *
     * @param name
     * @param nextPost
     * @throws java.rmi.RemoteException
     */
    @Override
    public void updateChat(String name, String nextPost) throws RemoteException {
        String message = (name + " : " + nextPost);
        sendToAll(message);
    }

    /**
     * Receive a new client remote reference
     *
     * @param ref
     * @throws java.rmi.RemoteException
     */
    /*@Override
    public void passIDentity(RemoteRef ref) throws RemoteException {
        //System.out.println("\n" + ref.remoteToString() + "\n");
        try {
            System.out.println("\n" + ref.toString());
        } catch (Exception e) {
        }
    }//end passIDentity
    */

    /**
     * Receive a new client and display details to the console send on to
     * register method
     *
     * @param details
     * @throws java.rmi.RemoteException
     */
    @Override
    public void registerListener(String[] details) throws RemoteException {
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(details[0] + " has joined the chat session");
        System.out.println(details[0] + "'s hostname : " + details[1]);
        System.out.println(details[0] + "'sRMI service : " + details[2]);
        registerJogador(details);
    }

    /**
     * register the clients interface and store it in a reference for future
     * messages to be sent to, ie other members messages of the chat session.
     * send a test message for confirmation / test connection
     *
     * @param details
     */
    private void registerJogador(String[] details) {
        try {
            ClienteItf nextClient = (ClienteItf) Naming.lookup("rmi://" + details[1] + "/" + details[2]);
            clients.add(new Jogador(details[0], nextClient));
            if(clients.size() == 2){
                clients.get(0).getClient().registraCorPeca("azul");
                clients.get(1).getClient().registraCorPeca("vermelho");
                sendToAll("[Server]: " + "O jogador azul sempre começa\n");
            }
            updateUserList();
        } catch (RemoteException | MalformedURLException | NotBoundException e) {
        }
    }

    /**
     * Update all clients by remotely invoking their updateUserList RMI method
     */
    private void updateUserList() {
        String[] currentUsers = getUserList();
        clients.forEach((Jogador c) -> {
            try {
                c.getClient().updateUserList(currentUsers);
            } catch (RemoteException ex) {
                Logger.getLogger(ServidorPPD.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    /**
     * generate a String array of current users
     *
     * @return
     */
    private String[] getUserList() {
        // generate an array of current users
        String[] allUsers = new String[clients.size()];
        for (int i = 0; i < allUsers.length; i++) {
            allUsers[i] = clients.get(i).getName();
        }
        return allUsers;
    }

    /**
     * Send a message to all users
     *
     * @param newMessage
     */
    public void sendToAll(String newMessage) {
        clients.forEach((c) -> {
            try {
                c.getClient().messageFromServer(newMessage);
            } catch (RemoteException e) {
            }
        });
    }

    /**
     * remove a client from the list, notify everyone
     *
     * @param userName
     * @throws java.rmi.RemoteException
     */
    @Override
    public void leaveChat(String userName) throws RemoteException {

        for (Jogador c : clients) {
            if (c.getName().equals(userName)) {
                System.out.println("\n" + userName + " left the chat session");
                System.out.println(new Date(System.currentTimeMillis()));
                clients.remove(c);
                sendToAll("\n[Server] : Seu oponente abandonou o jogo, você venceu!\n");
                break;
            }
        }
        if (!clients.isEmpty()) {
            updateUserList();
        }
    }

    /**
     * A method to send a private message to selected clients The integer array
     * holds the indexes (from the chatters vector) of the clients to send the
     * message to
     *
     * @param privateGroup
     * @param privateMessage
     * @throws java.rmi.RemoteException
     */
    @Override
    public void sendPM(int[] privateGroup, String privateMessage) throws RemoteException {
        Jogador pc;
        for (int i : privateGroup) {
            pc = clients.get(i);
            pc.getClient().messageFromServer(privateMessage);
        }
    }

    @Override
    public void updateMap(String map) throws RemoteException {
        clients.forEach((Jogador c) -> {
            try {
                c.getClient().atualizaTabuleiro(map);
            } catch (RemoteException e) {
            }
        });
    }

    @Override
    public void updateSurrender(String cor) throws RemoteException {
        clients.forEach((Jogador c) -> {
            try {
                c.getClient().desistenciaJogador(cor);
            } catch (RemoteException ex) {
                Logger.getLogger(ServidorPPD.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
}
