package concurrency;

//An example of CyclicBarrier. 

import java.util.concurrent.*;

public class CB4 {
	public static void main(String args[]) {
		CyclicBarrier cb = new CyclicBarrier(3, new BarAction());

		System.out.println("Starting");

		new MyThreadCB(cb, "A");
		new MyThreadCB(cb, "B");
		new MyThreadCB(cb, "C");
		
		/*new MyThreadCB(cb, "D");
		new MyThreadCB(cb, "E");
		new MyThreadCB(cb, "F");*/

	}
}

// A thread of execution that uses a CyclicBarrier.
class MyThreadCB implements Runnable {
	CyclicBarrier cbar;
	String name;

	MyThreadCB(CyclicBarrier c, String n) {
		cbar = c;
		name = n;
		new Thread(this).start();
	}

	public void run() {

		System.out.println(name);

		try {
			cbar.await();
		} catch (BrokenBarrierException exc) {
			System.out.println(exc);
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
	}
}

// An object of this class is called when the
// CyclicBarrier ends.
class BarAction implements Runnable {
	public void run() {
		System.out.println("Barrier Reached!");
	}
}