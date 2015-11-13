package cashierDesks;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Customer extends Thread {

	Semaphore semaphore;
	Random random = new Random();
	Shop shop = new Shop();
	
	private String name;
	
	Customer(Semaphore sem, String name) {
		semaphore = sem;
		this.name = name;
		new Thread(this).start();
	}
		
	@Override
	public void run() {
		System.out.println("Customer " + name + " come to a shop and picking product.");
		try {
		System.out.println("Customer " + name + " stands in a queue.");
		semaphore.acquire();
		//purchase operations. 

		String product = "Milk";
		int amount = shop.amountOfProduct.get(product);
		System.out.println("Bought " + product);
		System.out.println("Amount of " + product + " after purchase: " + --amount);
		amount--;
		System.out.println("amount " + amount);
		shop.amountOfProduct.put(product, amount);
		
		//sysoutshop.amountOfProduct.get(product);
		
		//Thread.sleep(10); //Try to use random for value generation
		Thread.sleep((random.nextInt(5) + 1) * 1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Customer " + name + " left shop");
		semaphore.release();
	}
	
}
