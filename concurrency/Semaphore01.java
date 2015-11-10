package concurrency;

import java.util.Random;

//A simple semaphore example. 
import java.util.concurrent.Semaphore;

public class Semaphore01 {

	public static void main(String args[]) {
		Semaphore sem = new Semaphore(2);

		new IncThread(sem, "A");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new DecThread(sem, "B");
		new DecThread(sem, "C");
		new DecThread(sem, "D");
		new DecThread(sem, "E");
		new DecThread(sem, "G");
		new DecThread(sem, "sdfwfwe");

	}
}

// A shared resource.
class Shared {
	static int count = 5;
}

// A thread of execution that increments count.
class IncThread implements Runnable {
	String name;
	Semaphore sem;

	IncThread(Semaphore s, String n) {
		sem = s;
		name = n;
		new Thread(this).start();
	}

	public void run() {

		System.out.println("Starting " + name);

		try {
			// First, get a permit.
			System.out.println(name + " is waiting for a permit.");
			sem.acquire();
			System.out.println(name + " gets a permit.");

			// Now, access shared resource.
			//for (int i = 0; i < 5; i++) {
				Shared.count++;
				System.out.println(name + ": " + Shared.count);

				// Now, allow a context switch -- if possible.
				Thread.sleep(10);
			//}
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}

		// Release the permit.
		System.out.println(name + " releases the permit.");
		sem.release();
	}
}

// A thread of execution that deccrements count.
class DecThread implements Runnable {
	String name;
	Semaphore sem;

	DecThread(Semaphore s, String n) {
		sem = s;
		name = n;
		new Thread(this).start();
	}

	public void run() {

		System.out.println("Starting " + name);

		try {
			// First, get a permit.
			System.out.println(name + " is waiting for a permit.");
			sem.acquire();
			System.out.println(name + " gets a permit.");

			// Now, access shared resource.
			//for (int i = 0; i < 5; i++) {
				Shared.count--;
				if(Shared.count <= 0) {
					System.out.println(name + ": " + "”шел не солоно хлебавши");
				} else
				System.out.println(name + ": " + Shared.count);

				// Now, allow a context switch -- if possible.
				Random random = new Random();
				Thread.sleep((random.nextInt(9) + 1) * 500);
			//}
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}

		// Release the permit.
		System.out.println(name + " releases the permit.");
		sem.release();
	}
}
