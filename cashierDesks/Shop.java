package cashierDesks;

import java.util.HashMap;

public class Shop {

	private static HashMap<String, Integer> amountOfProduct = new HashMap<>();
		
	private static HashMap<String, Integer> productPrice = new HashMap<>();

	Shop() {
		amountOfProduct.put("Bread", 10);
		amountOfProduct.put("Milk", 5);
		amountOfProduct.put("Butter", 4);
		amountOfProduct.put("Yougurn", 3);
		amountOfProduct.put("Kefir", 7);
	}
	
	Shop shop = new Shop();
	
	
	
	
}
