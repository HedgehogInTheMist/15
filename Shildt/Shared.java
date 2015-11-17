package Shildt;

public class Shared {
	int n;
	boolean valueSet = false;
	synchronized int getN() {
		while(valueSet)
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Получено: " + n);
		valueSet = true;
		notify();
		return n;
	}
	
	synchronized void setN(int n) {
		while(!valueSet)
		try{
			wait();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		this.n = n;
		System.out.println("Отправлено: " + n);
		valueSet = false;
		notify();
	}
}
