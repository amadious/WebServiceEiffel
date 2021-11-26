package fr.uge.ifshare;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import fr.uge.common.IEmployee;
import fr.uge.common.IObs;
import fr.uge.common.IProduit;

import java.util.HashMap;
import java.util.List;


public class Obs extends UnicastRemoteObject implements IObs {
	private static final long serialVersionUID = 1L;
	private final HashMap<IProduit,List<IEmployee>> ps = new HashMap<>();
	

	protected Obs() throws RemoteException {
		super();
	}

	
	@Override
	public void register(IEmployee p, IProduit produit) throws RemoteException {
		
	}


	@Override
	public boolean disponible(IProduit produit) throws RemoteException {
		return true;
	}


	public HashMap<IProduit,List<IEmployee>> getPs() {
		return ps;
	}


}
