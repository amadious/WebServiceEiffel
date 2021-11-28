/**
 * ConvertisseurService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package currencyService;

public interface ConvertisseurService extends javax.xml.rpc.Service {
    public java.lang.String getConvertisseurAddress();

    public currencyService.Convertisseur getConvertisseur() throws javax.xml.rpc.ServiceException;

    public currencyService.Convertisseur getConvertisseur(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
