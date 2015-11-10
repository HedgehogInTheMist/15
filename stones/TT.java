package stones;

import java.util.concurrent.Semaphore;

class Buyer extends Thread {
	Semaphore sem;;
	Cashbox cb;
	String name;
	public Buyer(Cashbox cb, String name, Semaphore sem){
		this.cb = cb;
		this.name = name;
		start();
		this.sem = sem;
	}
	
	public void run() {
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print(name + ": ");
		for (int i=1; i<=10; i++) {
			cb.payment((int)(Math.random()*10));
		}
		System.out.println();
		sem.release();
	}
}

class Cashbox{

	public Cashbox(){
		
	}
	
	public void payment(int i) {
		System.out.print(i + " ");
	}

}

public class TT {

	public static void main(String[] args) {
		
		Semaphore sem = new Semaphore(1);

		Cashbox cb = new Cashbox();
		new Buyer(cb, "One", sem);
		new Buyer(cb, "Two", sem);
		new Buyer(cb, "Three", sem);
		new Buyer(cb, "Four", sem);
		
	}

}
