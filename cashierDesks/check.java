package cashierDesks;

import java.util.HashMap;
import java.util.Random;
//A simple lock example. 
import java.util.concurrent.locks.ReentrantLock;

public class check {

	public static void main(String args[]) {
		ReentrantLock lock = new ReentrantLock();

		new LockThread(lock, "���������� A");
		new LockThread(lock, "���������� B");
		new LockThread(lock, "���������� C");
		new LockThread(lock, "���������� D");
		new LockThread(lock, "���������� E");
		new LockThread(lock, "���������� F");
		new LockThread(lock, "���������� G");
		new LockThread(lock, "���������� H");
		new LockThread(lock, "���������� K");
		

	}
}

//A SharedLock resource.
class SharedLock {
//	static int count = 0;
//	static int count2 = 0;
	static int[] count = new int[2];
	static HashMap<String, Integer> cD = new HashMap<>();
		
	cashier.put("����� �1");
	
	
}

//A thread of execution that increments count.
class LockThread implements Runnable {
	String name;
	ReentrantLock lock;

	LockThread(ReentrantLock lk, String n) {
		lock = lk;
		name = n;
		new Thread(this).start();
	}

	public void run() {

		System.out.println("Starting " + name);

		try {
			// First, lock count.
			System.out.println(name + " is waiting to lock count.");
			lock.lock();
			//System.out.println(name + " is locking count.");

			int[] count = new int[3];
			
			SharedLock sharedLock = new SharedLock();
				
			Random random = new Random();
			int randIndex = random.nextInt(3) + 1;
			//int randIndex = (Math.random() < 0.5) ? 0 : 1;
			
			System.out.println(name + ": " + "��� �������� � ����� " + sharedLock.cashier.get(random.nextInt(3) + 1) + " " +  "-m");
			
			/*if (randIndex == 0) {
				//SharedLock.count++;
				SharedLock.count[randIndex]++;
				System.out.println(name + ": " + "��� �������� � ����� " + (randIndex + 1) + " " + SharedLock.count[0] + "-m");
			} else {
				SharedLock.count[randIndex]++;
				System.out.println(name + ": " + "��� �������� � ����� " + (randIndex + 1) + " " + SharedLock.count[1] + "-m");
			}
			*/
			
//			SharedLock.count++;
			//System.out.println(name + ": " + SharedLock.count);

			// Now, allow a context switch -- if possible.
		//	System.out.println(name + " is sleeping.");
			Thread.sleep(1000);
		} catch (InterruptedException exc) {
			System.out.println(exc);
		} finally {
			// Unlock
		//	System.out.println(name + " is unlocking count.");
			lock.unlock();
		}
	}
}