package test.Threads;

public class IncreaseNumber implements Runnable {
	int number;
	boolean check = true;
	
/*	IncreaseNumber(int number) {
		this.number = number;
		new Thread(this, "Thread 1").start();
	}*/
	
	@Override
	public void run() {
		print10();
	}
	
	synchronized void print10() {
		while(check) 
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		int number = 1;
		for (int i = 1; i <= 10; i++) {
			System.out.print(Thread.currentThread().getName());
			for (int j = 1; j <= 10; j++) {
				System.out.print(" " + number + " ");
				number++;
			}
			System.out.println();
			notify();
			check = true;
		}
	}

}
