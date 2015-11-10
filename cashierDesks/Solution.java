package cashierDesks;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Solution {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(5);
		Random random = new Random();
		
		
		for(int i = 1; i <= 20; i++) {
			new Customer(semaphore, " " + i);
			try {
				Thread.sleep((random.nextInt(4) + 1)*1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		/*Thread t = new Customer();
		Thread t1 = new Customer();
		Thread t2 = new Customer();
		Thread t3 = new Customer();
		//Customer customer = new Customer();
		//customer.start();
		t.start();
		t1.start();
		t2.start();
		t3.start();*/
	}

}
