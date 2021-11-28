package fr.uge.common;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IObs extends Remote {
	
	public void register( IEmployee employee, IProduit produit) throws RemoteException; // engistre l'observeur
	public void disponible(IProduit produit, IMarket market)throws RemoteException;
}