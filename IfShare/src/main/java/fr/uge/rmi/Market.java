package fr.uge.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import fr.uge.common.IEmployee;
import fr.uge.common.IMarket;
import fr.uge.common.IObs;
import fr.uge.common.IProduit;

public class Market extends UnicastRemoteObject implements IMarket {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final List<IProduit> products = new ArrayList<>();
	private final Set<IProduit> prodsVendus = new HashSet<>();
	private final IObs obs;

	public Market() throws RemoteException {
		super();
		obs = new Obs();
	}

	@Override
	public void acheterProduit(IProduit produit, IEmployee employee) throws RemoteException {
		if (!getProduitDisponible().contains(produit)) {
			obs.register(employee, produit);
			return;
		}
		int index = findByNameAndSeller(produit);
		if (index > 0) {
			prodsVendus.add(products.remove(index)); // on supp et on l'ajoute aux produit vendu
		}
	}

	// return -1 si pas trouvé.
	private int findByNameAndSeller(IProduit p) throws RemoteException {
		int i = 0;
		for (IProduit curr : products) {
			if (Objects.equals(p.getName(), curr.getName()) && Objects.equals(p.getVendeur(), curr.getVendeur())) {
				return i;
			}
			++i;
		}
		return -1;
	}

	@Override
	public void vendreProduit(IProduit produit, IEmployee employee) throws RemoteException {
		Objects.requireNonNull(employee);
		Objects.requireNonNull(produit);
		products.add(produit);
		obs.disponible(produit, this);

	}

	public IProduit getProduit(Long IdProduit) throws RemoteException {
		return null; //TODO remove ?

	}

	@Override
	public List<IProduit> getProduitDisponible() throws RemoteException {
		return products;
	}

	public Set<IProduit> getProdsVendus() {
		return prodsVendus;
	}

}