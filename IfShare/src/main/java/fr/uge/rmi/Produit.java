package fr.uge.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import fr.uge.common.IProduit;


public class Produit extends UnicastRemoteObject implements IProduit{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static AtomicLong generateurId = new AtomicLong(1L);
	private Long productId;
	private String name;
	private double price;

	
	
	public Produit(String name, double price) throws RemoteException {
		Objects.requireNonNull(name);
		if (price <= 0)
        {
            throw new IllegalArgumentException("Price can't be negative");
        }
		this.productId = generateurId.getAndIncrement();
		this.name = name.toUpperCase();
		this.price = price;
	}
	
	public Long getProductId() throws RemoteException {
		return productId;
	}
	public void setProductId(Long productId) throws RemoteException {
		this.productId = productId;
	}
	public String getName() throws RemoteException{
		return name;
	}
	public void setName(String name) throws RemoteException {
		this.name = name.toUpperCase();
	}
	public double getPrice() throws RemoteException {
		return price;
	}
	public void setPrice(double price) throws RemoteException {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name,productId);
	}
	
	@Override
    public boolean equals(Object obj){
        if(obj == null) return false;

          if(obj instanceof Produit && this == obj) return true;
          Produit produit = (Produit)obj;
          try {
			return ( productId == produit.getProductId() && name.equalsIgnoreCase(produit.name));
		} catch (RemoteException e) {
			return false;
		}
    }
	

	@Override
	public String toString(){
		return "Product [productId=" + productId + ", name=" + name + ", price="
				+ price + "]";
	}

	

}