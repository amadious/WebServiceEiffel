/**
 * AccountBalance.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package accountSolde;

public interface AccountBalance extends java.rmi.Remote {
    public void transfert(int id, double val) throws java.rmi.RemoteException;
    public double getMoney(int id) throws java.rmi.RemoteException;
    public boolean pay(int id, double val) throws java.rmi.RemoteException;
    public void addClient(int id) throws java.rmi.RemoteException;
}
