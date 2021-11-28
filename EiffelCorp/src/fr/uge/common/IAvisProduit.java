package fr.uge.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAvisProduit extends Remote {
	

	public String getCommentaire() throws RemoteException;
	public String getNote() throws RemoteException;
	public IEmployee getOwner() throws RemoteException;

}
