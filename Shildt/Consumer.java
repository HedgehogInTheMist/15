package Shildt;

public class Consumer extends Thread{
	Shared shared;
	Consumer(Shared shared) {
		this.shared = shared;
		new Thread(this, "Потребитель").start();
	}

	@Override
	public void run() {
		//while(true) {
		for(int i = 0; i < 8; i++) {	
		shared.getN();
		}
		//}
	}
	
	
}
