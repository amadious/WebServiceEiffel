package fr.uge.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEmployee extends Remote{
	public long getId() throws RemoteException;

	public String getPrenom() throws RemoteException;

	public String getNom() throws RemoteException;
	public void a_achete(IProduit produit) throws RemoteException;
	public void onDisponible(IProduit produit) throws RemoteException;


}