package accountSolde;

import java.util.HashMap;
import java.util.Map;

public class AccountBalance {
	private Map<Integer, Double> accountBalance = new HashMap<>();
	
	public void transfert(Integer id ,Double val){
	    accountBalance.computeIfPresent(id,(k,v) -> v+val );
	}

	public boolean pay(Integer id ,Double val){ 
	    if (accountBalance.getOrDefault(id,0d) >= val){
	        accountBalance.compute(id, (k,v) -> v-val);
	        return true;
	     }else{
	        return false;
	     }
	 }

	    public Double getMoney(Integer id){
	        return accountBalance.getOrDefault(id,0d);
	    }
	    
	    public void addClient(Integer id) {
	    	accountBalance.putIfAbsent(id, 0d);
	    }
	    
}
