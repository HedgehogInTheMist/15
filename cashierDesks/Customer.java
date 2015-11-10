package cashierDesks;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Customer extends Thread {

	Semaphore semaphore;
	Random random = new Random();
	
	private String name;
	private ArrayList<String> listOfPurchase = new ArrayList<>();
	private int amountOfMoney;
	
	Customer(Semaphore sem, String name) {
		semaphore = sem;
		this.name = name;
		new Thread(this).start();
	}
	
	/*Customer(String name, ArrayList<String> purchse, int amount) {
		this.name = name;
		this.listOfPurchase = purchse;
		this.amountOfMoney = amount;
	}*/
	
	@Override
	public void run() {
		System.out.println("Customer " + name + " come to a shop and picking product.");
		try {
		System.out.println("Customer " + name + " stands in a queue.");
		semaphore.acquire();
		//purchase operations. 
		
		
		//Thread.sleep(10); //Try to use random for value generation
		Thread.sleep((random.nextInt(5) + 1) * 1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Customer " + name + " left shop");
		semaphore.release();
	}
	
}
