package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoThreads extends Thread {
	public static void main(String[] args) throws InterruptedException, IOException {

		System.out.println("Enter \"start\" for starting threads or (q/Q) for Exit: ");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String userAnswer;
		userAnswer = bufferedReader.readLine();
		boolean check = false;
		//while (true) {
			switch (userAnswer) {
			case "start":
				
				while(!check)
				new Thread("Thread 1:") {
					public void run() {
						print10();
						try {
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
				}.start();
				
				new Thread("Thread 2:") {
					public void run() {
						print10();
					}
				}.start();
				break;
			
			case "q":
				break;
			}
		//}
	}

	/**
	 * Print numbers from 1 up to 100. Feeding 10 numbers in line separeted with
	 * space
	 */
	public synchronized static void print10() {
		// public static void print10() {
		int number = 1;
		for (int i = 1; i <= 10; i++) {
			System.out.print(Thread.currentThread().getName());
			for (int j = 1; j <= 10; j++) {
				System.out.print(" " + number + " ");
				number++;
			}
			System.out.println();
		}
	}
}

