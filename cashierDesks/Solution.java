package cashierDesks;

import java.util.concurrent.Semaphore;

public class Solution {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(2);
		
		
		
		for(int i = 0; i < 20; i++) {
			new Customer(semaphore, "Покупатель 1");
			try {
				Thread.sleep(1000);
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
