package accountSolde;

public class AccountBalance {
	private final Integer id = 0;
	private Double money = 0d;
	 
	    public void transfert(Double val){
	        money += val;
	    }

	    public boolean pay(Double val){ 
	        if (money >= val){
	            money -= val;
	            return true;
	        }else{
	            return false;
	        }
	    }

	    public Double getMoney(){
	        return money;
	    }
	    
}
