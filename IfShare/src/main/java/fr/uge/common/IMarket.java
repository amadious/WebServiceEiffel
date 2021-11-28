package fr.uge.common;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;



public interface IMarket extends Remote{
	
	
	public void acheterProduit(IProduit produit, IEmployee employee) throws RemoteException;
	public void vendreProduit(IProduit produit, IEmployee employee) throws RemoteException;
	public List<IProduit> getProduitDisponible() throws RemoteException;
	public IProduit getProduit(Long IdProduit)throws RemoteException;
	
	public void vendreProduit(IProduit produit) throws RemoteException;

}