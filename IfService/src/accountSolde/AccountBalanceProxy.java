package accountSolde;

public class AccountBalanceProxy implements accountSolde.AccountBalance {
  private String _endpoint = null;
  private accountSolde.AccountBalance accountBalance = null;
  
  public AccountBalanceProxy() {
    _initAccountBalanceProxy();
  }
  
  public AccountBalanceProxy(String endpoint) {
    _endpoint = endpoint;
    _initAccountBalanceProxy();
  }
  
  private void _initAccountBalanceProxy() {
    try {
      accountBalance = (new accountSolde.AccountBalanceServiceLocator()).getAccountBalance();
      if (accountBalance != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)accountBalance)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)accountBalance)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (accountBalance != null)
      ((javax.xml.rpc.Stub)accountBalance)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public accountSolde.AccountBalance getAccountBalance() {
    if (accountBalance == null)
      _initAccountBalanceProxy();
    return accountBalance;
  }
  
  public void transfert(int id, double val) throws java.rmi.RemoteException{
    if (accountBalance == null)
      _initAccountBalanceProxy();
    accountBalance.transfert(id, val);
  }
  
  public boolean pay(int id, double val) throws java.rmi.RemoteException{
    if (accountBalance == null)
      _initAccountBalanceProxy();
    return accountBalance.pay(id, val);
  }
  
  public void addClient(int id) throws java.rmi.RemoteException{
    if (accountBalance == null)
      _initAccountBalanceProxy();
    accountBalance.addClient(id);
  }
  
  public double getMoney(int id) throws java.rmi.RemoteException{
    if (accountBalance == null)
      _initAccountBalanceProxy();
    return accountBalance.getMoney(id);
  }
  
  
}