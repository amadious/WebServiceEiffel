/**
 * AccountBalanceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package accountSolde;

public interface AccountBalanceService extends javax.xml.rpc.Service {
    public java.lang.String getAccountBalanceAddress();

    public accountSolde.AccountBalance getAccountBalance() throws javax.xml.rpc.ServiceException;

    public accountSolde.AccountBalance getAccountBalance(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
