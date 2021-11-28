package fr.uge.common;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;



public interface IProduit  extends Remote{
	
	public Long getProductId()throws RemoteException;
	
	public void setProductId(Long productId)throws RemoteException;

	public String getName()throws RemoteException;
	
	public void setName(String name)throws RemoteException;
	
	public double getPrice()throws RemoteException;
	
	public void setPrice(double price)throws RemoteException;	
	public States getEtat() throws RemoteException;	
	public List<IAvisProduit> getAvis() throws RemoteException;
	
	public void addAvis(IAvisProduit avis) throws RemoteException;
	public void setEtat(IProduit.States etat) throws RemoteException;
	
	public enum States {

		BON_ETAT, TRES_BON_ETAT, NEUF
	}

}