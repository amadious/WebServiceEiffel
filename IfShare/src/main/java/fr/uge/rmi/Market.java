package fr.uge.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import fr.uge.common.IEmployee;
import fr.uge.common.IMarket;
import fr.uge.common.IObs;
import fr.uge.common.IProduit;

public class Market extends UnicastRemoteObject implements IMarket {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ConcurrentHashMap<Long, IProduit> products = new ConcurrentHashMap<>();
	private final Set<IProduit> prodsVendus = new HashSet<>();
	private final IObs obs;

	public Market() throws RemoteException {
		super();
		obs = new Obs();
	}

	@Override
	public void acheterProduit(IProduit produit, IEmployee employee) throws RemoteException {
		if (products.get(produit.getProductId()) ==  null) {
			System.out.println(employee.getNom() + " en attente du produit " + produit.getName());
			obs.register(employee, produit);
			return;
		}
		IProduit p = products.remove(produit.getProductId());
		employee.a_achete(p);
		prodsVendus.add(p); // on supp et on l'ajoute aux produit vendu
		System.out.println(employee.getNom() + " a acheté le produit " + produit.getName());

	}

	@Override
	public void vendreProduit(IProduit produit, IEmployee employee) throws RemoteException {
		Objects.requireNonNull(employee);
		Objects.requireNonNull(produit);
		products.put(produit.getProductId(), produit);
		obs.disponible(produit, this);

	}

	@Override
	public void vendreProduit(IProduit produit) throws RemoteException {
		Objects.requireNonNull(produit);
		products.put(produit.getProductId(), produit);
		obs.disponible(produit, this);

	}

	public IProduit getProduit(Long idProduit) throws RemoteException {
			return products.get(idProduit);


	}

	@Override
	public List<IProduit> getProduitDisponible() throws RemoteException {
		return products.values().stream().collect(Collectors.toList());
	}

	public Set<IProduit> getProdsVendus() {
		return prodsVendus;
	}

}