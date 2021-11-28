package fr.uge;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import accountSolde.AccountBalance;
import accountSolde.AccountBalanceServiceLocator;
import accountSolde.AccountBalanceSoapBindingStub;

public class Main {
	public static void main(String[] args) throws ServiceException, RemoteException { 
		 
	    AccountBalance serviceBank = new AccountBalanceServiceLocator().getAccountBalance(); 
		 
		((AccountBalanceSoapBindingStub) serviceBank).setMaintainSession(true); 
		 
		serviceBank.addClient(1);
		serviceBank.addClient(2);
		serviceBank.transfert(1, 1000);
		serviceBank.transfert(2, 3000);

		serviceBank.pay(1, 50);
		serviceBank.pay(2, 500);
		
		System.out.println(serviceBank.getMoney(1)+"/"+serviceBank.getMoney(2)); 
	}
}
