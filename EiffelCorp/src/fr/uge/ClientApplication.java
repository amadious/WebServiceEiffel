package fr.uge;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import fr.uge.common.IEmployee;
import fr.uge.common.IMarket;
import fr.uge.common.IProduit;

public class ClientApplication {
	

public static void main(String[] args) {
		 try {
		 IMarket market = (IMarket) Naming.lookup("IfShareMarket");
		 market.getProduitDisponible();

		 IEmployee empl = new Employee("Djahida", "Harouche");
		
		 List<IProduit> listProduits =  market.getProduitDisponible();
		 System.out.println( "Liste des produits à vendre "+listProduits.size()+" :\n");
		 listProduits.forEach(p -> {
			try {
				System.out.println(p.getName());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		
		 //market.acheterProduit(listProduits.get(0), empl);
		 
	
		
		 }
		 catch (Exception e) {
		 System.out.println("Trouble " + e);
		 }
		 }


}