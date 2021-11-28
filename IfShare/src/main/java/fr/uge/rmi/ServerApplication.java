package fr.uge.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import fr.uge.common.*;


public class ServerApplication {
			
		 public static void main(String args[]) {
			 System.out.println("SERVEUR DEMARRE ");
			 try {
			  
			  IMarket market = new Market();
			  IProduit velo = new Produit("Velo", 199);
			  IProduit velo2 = new Produit("Velo2", 300);
			  IProduit livre = new Produit("Les miserables", 9);
			  //IProduit velo = new Produit("Velo", 199);
			  //IProduit velo = new Produit("Velo", 199);
			  
			  market.vendreProduit(velo2);
			  market.vendreProduit(velo);
			  market.vendreProduit(livre);
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  LocateRegistry.createRegistry(1099);
			  Naming.rebind("IfShareMarket", market);
			  // Naming.rebind("rmi://localhost/IfShareMarket", market);
			  }
			  catch (Exception e) {
			  System.out.println("Trouble: " + e);
			  }
			 }

}