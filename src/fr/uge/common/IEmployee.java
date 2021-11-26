package fr.uge.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEmployee extends Remote{
	public long getId() throws RemoteException;

	public String getPrenom() throws RemoteException;

	public String getNom() throws RemoteException;


}
