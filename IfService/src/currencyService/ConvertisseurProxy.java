package currencyService;

public class ConvertisseurProxy implements currencyService.Convertisseur {
  private String _endpoint = null;
  private currencyService.Convertisseur convertisseur = null;
  
  public ConvertisseurProxy() {
    _initConvertisseurProxy();
  }
  
  public ConvertisseurProxy(String endpoint) {
    _endpoint = endpoint;
    _initConvertisseurProxy();
  }
  
  private void _initConvertisseurProxy() {
    try {
      convertisseur = (new currencyService.ConvertisseurServiceLocator()).getConvertisseur();
      if (convertisseur != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)convertisseur)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)convertisseur)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (convertisseur != null)
      ((javax.xml.rpc.Stub)convertisseur)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public currencyService.Convertisseur getConvertisseur() {
    if (convertisseur == null)
      _initConvertisseurProxy();
    return convertisseur;
  }
  
  public double convert(java.lang.String from, java.lang.String target, double amount) throws java.rmi.RemoteException{
    if (convertisseur == null)
      _initConvertisseurProxy();
    return convertisseur.convert(from, target, amount);
  }
  
  
}