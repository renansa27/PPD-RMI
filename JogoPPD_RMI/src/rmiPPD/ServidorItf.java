package rmiPPD;

import java.rmi.Remote;
import java.rmi.RemoteException;
//import java.rmi.server.RemoteRef;

public interface ServidorItf extends Remote {

    /**
     *
     * @param userName
     * @param chatMessage
     * @throws RemoteException
     */
    public void updateChat(String userName, String chatMessage) throws RemoteException;

    /**
     *
     * @param ref
     * @throws RemoteException
     */
    //public void passIDentity(RemoteRef ref) throws RemoteException;

    /**
     *
     * @param details
     * @throws RemoteException
     */
    public void registerListener(String[] details) throws RemoteException;

    /**
     *
     * @param userName
     * @throws RemoteException
     */
    public void leaveChat(String userName) throws RemoteException;

    /**
     *
     * @param privateGroup
     * @param privateMessage
     * @throws RemoteException
     */
    public void sendPM(int[] privateGroup, String privateMessage) throws RemoteException;
    
    /**
     *
     * @param map
     * @throws RemoteException
     */
    public void updateMap(String map) throws RemoteException;
    
    /**
     *
     * @param cor
     * @throws java.rmi.RemoteException
     */
    public void updateSurrender(String cor) throws RemoteException;
}
