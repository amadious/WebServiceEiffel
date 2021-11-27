package fr.uge.ifshare;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;

import fr.uge.common.IEmployee;
import fr.uge.common.IMarket;
import fr.uge.common.IProduit;
import fr.uge.eifeil_corp.Employee;

public class ServerApplication {
			
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