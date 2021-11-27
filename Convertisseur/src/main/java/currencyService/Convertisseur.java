package currencyService;

import java.util.HashMap;
import java.util.Map;

public class Convertisseur {
	
	private final Map<String, Double> exchangeRates = new HashMap<String, Double>(){{
		put("EUR2EUR", 1d);
		put("EUR2TND", 3.26d);
		put("EUR2USD", 1.13d);
		put("EUR2DZD", 154.19d);
		put("EUR2CAD", 1.56d);
		put("EUR2DHM", 10.84d);
		put("EUR2FRA", 1.08d);
		put("EUR2JPY", 124.45d);
		put("EUR2GBP", 0.9d);
	
		}};
	
	public Double convert(String from, String target, Double amount) {
		String change = from+"2"+target;
		
		return amount*exchangeRates.get(change);
	}

}