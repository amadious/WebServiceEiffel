/**
 * AccountBalanceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package accountSolde;

public class AccountBalanceServiceLocator extends org.apache.axis.client.Service implements accountSolde.AccountBalanceService {

    public AccountBalanceServiceLocator() {
    }


    public AccountBalanceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AccountBalanceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AccountBalance
    private java.lang.String AccountBalance_address = "http://localhost:8080/Banque/services/AccountBalance";

    public java.lang.String getAccountBalanceAddress() {
        return AccountBalance_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AccountBalanceWSDDServiceName = "AccountBalance";

    public java.lang.String getAccountBalanceWSDDServiceName() {
        return AccountBalanceWSDDServiceName;
    }

    public void setAccountBalanceWSDDServiceName(java.lang.String name) {
        AccountBalanceWSDDServiceName = name;
    }

    public accountSolde.AccountBalance getAccountBalance() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AccountBalance_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAccountBalance(endpoint);
    }

    public accountSolde.AccountBalance getAccountBalance(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            accountSolde.AccountBalanceSoapBindingStub _stub = new accountSolde.AccountBalanceSoapBindingStub(portAddress, this);
            _stub.setPortName(getAccountBalanceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAccountBalanceEndpointAddress(java.lang.String address) {
        AccountBalance_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (accountSolde.AccountBalance.class.isAssignableFrom(serviceEndpointInterface)) {
                accountSolde.AccountBalanceSoapBindingStub _stub = new accountSolde.AccountBalanceSoapBindingStub(new java.net.URL(AccountBalance_address), this);
                _stub.setPortName(getAccountBalanceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AccountBalance".equals(inputPortName)) {
            return getAccountBalance();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://accountSolde", "AccountBalanceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://accountSolde", "AccountBalance"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AccountBalance".equals(portName)) {
            setAccountBalanceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
