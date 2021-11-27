package fr.uge.common;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IProduit  extends Remote{
	
	public Long getProductId()throws RemoteException;
	
	public void setProductId(Long productId)throws RemoteException;

	public String getName()throws RemoteException;
	
	public void setName(String name)throws RemoteException;
	
	public double getPrice()throws RemoteException;
	
	public void setPrice(double price)throws RemoteException;	
	public IEmployee getVendeur() throws RemoteException;

}