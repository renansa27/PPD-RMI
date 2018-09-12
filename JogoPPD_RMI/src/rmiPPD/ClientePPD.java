package rmiPPD;

import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author renan
 */
public class ClientePPD extends UnicastRemoteObject implements ClienteItf {

    ClienteFramePPD chatGUI;
    //private String hostName = chatGUI.ipServidor;
    private String serviceName = "GameService";
    public String name;
    public String clientServiceName;
    protected ServidorItf servidor;
    protected boolean connectionProblem = false;

    /**
     * @param aChatGUI
     * @param userName
     * @throws java.rmi.RemoteException
     */
    public ClientePPD(ClienteFramePPD aChatGUI, String userName) throws RemoteException {
        super();
        this.chatGUI = aChatGUI;
        this.name = userName;
        this.clientServiceName = "ClientListenService_" + userName;
    }

    public void registerWithServer(String[] details) {
        try {
            servidor.registerListener(details);
        } catch (RemoteException e) {
            System.out.println(e);
        }
    }

    public void startClient() throws RemoteException {
        String[] details = {name, chatGUI.ipServidor, clientServiceName};

        try {
            Naming.rebind("rmi://" + chatGUI.ipServidor + "/" + clientServiceName, this);
            servidor = (ServidorItf) Naming.lookup("rmi://" + chatGUI.ipServidor + "/" + serviceName);
        } catch (ConnectException e) {
            System.out.println("Erro:" + e);
            connectionProblem = true;
        } catch (NotBoundException | MalformedURLException me) {
            connectionProblem = true;
        }
        if (!connectionProblem) {
            registerWithServer(details);
        }
        System.out.println("Client Listen RMI Server is running...\n");
    }

    @Override
    public void messageFromServer(String message) throws RemoteException {
        System.out.println(message);
        chatGUI.AreaTextoReceber.append(message);
    }

    @Override
    public void registraCorPeca(String cor) {
        chatGUI.corPeca = cor;
        if ("azul".equals(cor)) {
            chatGUI.vez = true;
        }
        chatGUI.SuaCor.setText(name + ": " + cor);
    }

    @Override
    public void updateUserList(String[] currentUsers) throws RemoteException {

        if (currentUsers.length < 2) {

        }
    }

    private void verificarGanhador(String mapaJogo) {
        if ("BVAAV".equals(mapaJogo) || "VBAVA".equals(mapaJogo) && (("azul".equals(chatGUI.corPeca) && chatGUI.vez == false) || "vermelho".equals(chatGUI.corPeca) && chatGUI.vez == true)) {
            //Azul vence
            if ("azul".equals(chatGUI.corPeca)) {
                chatGUI.AreaTextoReceber.append("[Server] : " + "Parabéns " + name + ", você venceu!\n");
            } else {
                chatGUI.AreaTextoReceber.append("[Server] : " + name + ", você perdeu!\n");
            }
            reiniciaJogo();
        } else if (("ABVAV".equals(mapaJogo) || "BAVVA".equals(mapaJogo)) && (("azul".equals(chatGUI.corPeca) && chatGUI.vez == true) || "vermelho".equals(chatGUI.corPeca) && chatGUI.vez == false)) {
            //Vermelho vence
            if ("vermelho".equals(chatGUI.corPeca)) {
                chatGUI.AreaTextoReceber.append("[Server] : " + "Parabéns " + name + ", você venceu!\n");
            } else {
                chatGUI.AreaTextoReceber.append("[Server] : " + name + ", você perdeu!\n");
            }
            reiniciaJogo();
        }
    }

    @Override
    public void desistenciaJogador(String cor) {

        if ("azul".equals(cor)) {
            //Azul vence
            if ("vermelho".equals(chatGUI.corPeca)) {
                chatGUI.AreaTextoReceber.append("[Server] : " + "Parabéns " + name + ", você venceu!\n");
            } else {
                chatGUI.AreaTextoReceber.append("[Server] : " + name + ", você perdeu!\n");
            }
            reiniciaJogo();
        } else if ("vermelho".equals(cor)) {
            //Azul vence
            if ("azul".equals(chatGUI.corPeca)) {
                chatGUI.AreaTextoReceber.append("[Server] : " + "Parabéns " + name + ", você venceu!\n");
            } else {
                chatGUI.AreaTextoReceber.append("[Server] : " + name + ", você perdeu!\n");
            }
            reiniciaJogo();
        }
    }

    private void reiniciaJogo() {
        chatGUI.mapaJogo = "AABVV";
        if ("azul".equals(chatGUI.corPeca)) {
            chatGUI.vez = true;
        } else if("vermelho".equals(chatGUI.corPeca)){
            chatGUI.vez = false;
        }
        try {
            servidor.updateMap(chatGUI.mapaJogo);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteFramePPD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizaTabuleiro(String map) throws RemoteException {
        char[] posicoesRecebidas = map.toCharArray();
        chatGUI.mapaJogo = map;
        chatGUI.vez = !chatGUI.vez;
        for (int i = 0; i < 5; i++) {
            switch (posicoesRecebidas[i]) {
                case 'A':
                    switch (i) {
                        case 0:
                            chatGUI.button1.setBackground(new java.awt.Color(51, 51, 240));
                            break;
                        case 1:
                            chatGUI.button2.setBackground(new java.awt.Color(51, 51, 240));
                            break;
                        case 2:
                            chatGUI.button3.setBackground(new java.awt.Color(51, 51, 240));
                            break;
                        case 3:
                            chatGUI.button4.setBackground(new java.awt.Color(51, 51, 240));
                            break;
                        default:
                            chatGUI.button5.setBackground(new java.awt.Color(51, 51, 240));
                            break;
                    }
                    break;
                case 'V':
                    switch (i) {
                        case 0:
                            chatGUI.button1.setBackground(new java.awt.Color(255, 0, 0));
                            break;
                        case 1:
                            chatGUI.button2.setBackground(new java.awt.Color(255, 0, 0));
                            break;
                        case 2:
                            chatGUI.button3.setBackground(new java.awt.Color(255, 0, 0));
                            break;
                        case 3:
                            chatGUI.button4.setBackground(new java.awt.Color(255, 0, 0));
                            break;
                        default:
                            chatGUI.button5.setBackground(new java.awt.Color(255, 0, 0));
                            break;
                    }
                    break;
                case 'B':
                    switch (i) {
                        case 0:
                            chatGUI.button1.setBackground(new java.awt.Color(255, 255, 255));
                            break;
                        case 1:
                            chatGUI.button2.setBackground(new java.awt.Color(255, 255, 255));
                            break;
                        case 2:
                            chatGUI.button3.setBackground(new java.awt.Color(255, 255, 255));
                            break;
                        case 3:
                            chatGUI.button4.setBackground(new java.awt.Color(255, 255, 255));
                            break;
                        default:
                            chatGUI.button5.setBackground(new java.awt.Color(255, 255, 255));
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        verificarGanhador(chatGUI.mapaJogo);
    }
}