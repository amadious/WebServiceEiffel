package fr.uge.ifshare;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
	private ConcurrentHashMap<Long, List<IProduit>> products = new ConcurrentHashMap<>(); // id de l'employer vers list
																							// de produit
	private final IObs obs= new Obs();

	public Market() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void acheterProduit(IProduit produit, IEmployee employee) throws RemoteException {
		if(! getProduitDisponible().contains(produit)) {
			obs.register(employee, produit);
		}
		else {
			//products.get(employee.getId()).ge
			
		}
	}

	@Override
	public void vendreProduit(IProduit produit, IEmployee employee) throws RemoteException {
		Objects.requireNonNull(employee);
		Objects.requireNonNull(produit);
		if(products.get(employee.getId()) == null)
			products.put(employee.getId(), new ArrayList<IProduit>());
		
		long emplId = employee.getId();
		products.compute(emplId, (k, v) -> {
			v.add(produit);
			return v;
		});
		
		obs.disponible(produit);

	}

	public IProduit getProduit(Long IdProduit) throws RemoteException {
		return null;

	}

	@Override
	public List<IProduit> getProduitDisponible() throws RemoteException {
		return products.values().stream().flatMap(List::stream).collect(Collectors.toList());
	}
	


}