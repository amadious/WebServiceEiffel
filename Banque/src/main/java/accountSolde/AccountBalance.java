package accountSolde;

import java.util.concurrent.ConcurrentHashMap;

public class AccountBalance {
	private ConcurrentHashMap<Integer, Double> accountBalance = new ConcurrentHashMap<>();
	
	public void transfert(Integer id ,Double val){
		//accountBalance.computeIfPresent(id,(k,v) -> v+val );
		if (accountBalance.containsKey(id)) {
			accountBalance.replace(id, accountBalance.get(id) + val);
		}
	    
	}

	
	public boolean pay(Integer id ,Double val){ 
	    if (accountBalance.getOrDefault(id,0d) >= val){
	        //accountBalance.compute(id, (k,v) -> v-val);
			accountBalance.replace(id, accountBalance.get(id) - val);
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
