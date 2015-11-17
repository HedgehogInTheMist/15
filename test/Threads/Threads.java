package test.Threads;

public class Threads implements Runnable {
	String name;
	Threads() {
		this.name = name;
		new Thread(this, "Thread 1").start();
	}
	
	

	@Override
	public void run() {
		
		for(int i = 0; i < 10; i ++) {
			System.out.println(i + " ");
		}
		try {
			wait();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		return 
	}

}
