/**
 * Convertisseur.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package currencyService;

public interface Convertisseur extends java.rmi.Remote {
    public double convert(java.lang.String from, java.lang.String target, double amount) throws java.rmi.RemoteException;
}
