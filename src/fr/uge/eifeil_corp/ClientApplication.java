package fr.uge.eifeil_corp;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import fr.uge.common.IMarket;
import fr.uge.ifshare.Market;

public class ClientApplication {
	
	 public static void main(String args[]) {
		 try {
		  
		  IMarket market = new Market();
		  LocateRegistry.createRegistry(1099);
		  Naming.rebind("IfShareMarket", market);
		  // Naming.rebind("rmi://localhost/IfShareMarket", market);
		  
		  }
		  catch (Exception e) {
		  System.out.println("Trouble: " + e);
		  }
		 }

}