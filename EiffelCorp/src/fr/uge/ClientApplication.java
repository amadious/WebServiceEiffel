package fr.uge;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import fr.uge.common.IEmployee;
import fr.uge.common.IMarket;
import fr.uge.common.IProduit;

public class ClientApplication {
	
	private static void afficherProduit(List<IProduit> listProduits) {
		 System.out.println( "Liste des produits A  vendre :");
		 listProduits.forEach(p -> {
				try {
					System.out.println(p.getName() + " " +p.getPrice()  + " Euros,  etat : " + p.getEtat() );
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			});
	}
	
	private static void afficherAvis( IProduit p) throws RemoteException {
		p.getAvis().forEach(a ->{

				try {
					System.out.println("Avis de " +a.getOwner().getNom() + "."+a.getOwner().getPrenom() );
					System.out.println( "note : " + a.getNote() + ", " +a.getCommentaire() ) ;
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			
		});
	}

public static void main(String[] args) {
		 try {
		 IMarket market = (IMarket) Naming.lookup("IfShareMarket");
		 
		 market.getProduitDisponible();
		 
		 IEmployee djahida = new Employee("Djahida", "Harouche");
		 IEmployee galox = new Employee("gallox", "gallox");
		 IEmployee smail = new Employee("smail", "smail");
		
		 List<IProduit> listProduits =  market.getProduitDisponible();
		 afficherProduit(listProduits);
		 
		 IProduit p = listProduits.get(0);
		 
		 market.acheterProduit(p, djahida);
		 p.addAvis(new AvisProduit("Trop bien ce projet", 5, djahida));
		 //afficherProduit(market.getProduitDisponible());
		 
		 market.acheterProduit(p, galox);

		 market.acheterProduit(p, smail);
		 market.vendreProduit(p, djahida);
		 p.addAvis(new AvisProduit("je suis d'accord avec djahida", 4, galox));
		 market.vendreProduit(p, galox);
		 
		 p.addAvis(new AvisProduit("je suis d'accord avec gallox", 4, smail));
		 
		 afficherAvis(p);
		 }
		 catch (Exception e) {
		 System.out.println("Trouble " + e);
		 }
		 }


}