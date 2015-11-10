package concurrency;

//A simple example that uses an Executor. 

import java.util.concurrent.*;

class Executor6 {
	public static void main(String args[]) {
		CountDownLatch cdl = new CountDownLatch(5);
		CountDownLatch cdl2 = new CountDownLatch(5);
		CountDownLatch cdl3 = new CountDownLatch(5);
		CountDownLatch cdl4 = new CountDownLatch(5);
		ExecutorService es = Executors.newFixedThreadPool(2);

		System.out.println("Starting");

		// Start the threads.
		es.execute(new MyThreadExecutor(cdl, "A"));
		es.execute(new MyThreadExecutor(cdl2, "B"));
		es.execute(new MyThreadExecutor(cdl3, "C"));
		es.execute(new MyThreadExecutor(cdl4, "D"));

		try {
			cdl.await();
			cdl2.await();
			cdl3.await();
			cdl4.await();
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}

		es.shutdown();
		System.out.println("Done");
	}
}

class MyThreadExecutor implements Runnable {
	String name;
	CountDownLatch latch;

	MyThreadExecutor(CountDownLatch c, String n) {
		latch = c;
		name = n;

		new Thread(this);
	}

	public void run() {

		for (int i = 0; i < 5; i++) {
			System.out.println(name + ": " + i);
			latch.countDown();
		}
	}
}
