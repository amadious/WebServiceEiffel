package fr.uge;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import fr.uge.common.IEmployee;
import fr.uge.common.IProduit;

public class Employee extends UnicastRemoteObject implements IEmployee{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static AtomicLong generateurId = new AtomicLong(1L);
    private final long id;
    private final String nom;
    private final String prenom;
    private final List<IProduit> produitsAchetes;
    
	public Employee(String nom, String prenom)throws RemoteException{
		this.nom = nom;
		this.prenom = prenom;
		this.id = generateurId.getAndIncrement();
		produitsAchetes = new ArrayList<>();
	
	}

	public List<IProduit> getProduitsAchetes() {
		return produitsAchetes;
	}

	public String getPrenom() throws RemoteException{
		return prenom;
	}

	public String getNom() throws RemoteException{
		return nom;
	}

	@Override
	public long getId() throws RemoteException{
		return id;
	}

	@Override
	public void onDisponible(IProduit produit) throws RemoteException {
		System.out.println("Produit dispo :" + produit.getName() + "\n vous l'avez acheté ");
		
		
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(id, nom, prenom);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;

		if (! (obj instanceof Employee))
			return false;
		
		Employee other = (Employee) obj;
		
		try {
			return other.getId() == id && other.getNom() == nom && other.getPrenom() == prenom;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public void a_achete(IProduit produit) throws RemoteException {
		produitsAchetes.add(produit);
	}
    
    

}