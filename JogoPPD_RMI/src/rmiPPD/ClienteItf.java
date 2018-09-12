/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiPPD;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author renan
 */
public interface ClienteItf extends Remote {
    
    /**
     *
     * @param cor
     * @throws java.rmi.RemoteException
     */
    public void registraCorPeca(String cor) throws RemoteException;
    
    /**
     *
     * @param map
     * @throws RemoteException
     */
    public void atualizaTabuleiro(String map) throws RemoteException;
    
    /**
     *
     * @param message
     * @throws RemoteException
     */
    public void messageFromServer(String message) throws RemoteException;

    /**
     *
     * @param currentUsers
     * @throws RemoteException
     */
    public void updateUserList(String[] currentUsers) throws RemoteException;
    
    /**
     *
     * @param cor
     * @throws RemoteException
     */
    public void desistenciaJogador(String cor) throws RemoteException;
}