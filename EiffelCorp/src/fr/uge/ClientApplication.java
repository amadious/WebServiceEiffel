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
					System.out.println(p.getName());
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
		 
		 afficherProduit(market.getProduitDisponible());
		 
		 market.acheterProduit(p, galox);
		 market.acheterProduit(p, smail);
		 market.vendreProduit(p, djahida);
		 market.vendreProduit(p, galox);
		 }
		 catch (Exception e) {
		 System.out.println("Trouble " + e);
		 }
		 }


}