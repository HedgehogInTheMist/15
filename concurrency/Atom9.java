package concurrency;

//A simple example of Atomic. 

import java.util.concurrent.atomic.*;

public class Atom9 {

	public static void main(String args[]) {
		new AtomThread("A");
		new AtomThread("B");
		new AtomThread("C");
	}
}

class SharedAtom {
	static AtomicInteger ai = new AtomicInteger(0);
}

// A thread of execution that increments count.
class AtomThread implements Runnable {
	String name;

	AtomThread(String n) {
		name = n;
		new Thread(this).start();
	}

	public void run() {

		System.out.println("Starting " + name);

		for (int i = 1; i <= 3; i++)
			System.out.println(name + " got: " + SharedAtom.ai.getAndSet(i));
	}
}
