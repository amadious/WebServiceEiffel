package fr.uge;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

import fr.uge.common.IAvisProduit;
import fr.uge.common.IEmployee;

public class AvisProduit extends UnicastRemoteObject implements IAvisProduit {
	private static final long serialVersionUID = 1L;
	private final int note;
	private final String Commentaire;
	private final IEmployee owner;
	


	public AvisProduit(String commentaire, int note, IEmployee owner) throws RemoteException {
		super();
		Objects.requireNonNull(commentaire);
		Objects.requireNonNull(owner);
		if( note > 5 || note < 0 )
			throw new IllegalArgumentException("note doit etre compris entre 1 et 5");
		
		this.Commentaire = commentaire;
		this.note = note;
		this.owner = owner;
		
	}


	@Override
	public String getCommentaire() throws RemoteException {
		return Commentaire;
	}


	@Override
	public String getNote() throws RemoteException {
		return note + "/5";
	}


	@Override
	public IEmployee getOwner() throws RemoteException {
		return owner;
	}

}
