package fr.uge.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.uge.common.IEmployee;
import fr.uge.common.IMarket;
import fr.uge.common.IObs;
import fr.uge.common.IProduit;


public class Obs extends UnicastRemoteObject implements IObs {
	private static final long serialVersionUID = 1L;
	private final HashMap<IProduit,List<IEmployee>> observateurs = new HashMap<>();
	

	protected Obs() throws RemoteException {
		super();
	}

	
	@Override
	public void register(IEmployee emp, IProduit produit) throws RemoteException {
		observateurs.compute(produit, (k, v) -> {
			if(v == null)
				v = new ArrayList<>(); 
			v.add(emp);
			return v;
		});
	}

	@Override
	public void disponible(IProduit produit, IMarket market) throws RemoteException {
				if( observateurs.get(produit) == null )
					return;
				
				IEmployee empl = observateurs.get(produit).remove(0);
				if(empl == null)
					return;
				
				empl.onDisponible(produit);
				market.acheterProduit(produit,empl);
	}

}