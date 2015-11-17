package Shildt;

public class Producer extends Thread{
	Shared shared;
	
	Producer(Shared shared) {
		this.shared = shared;
		new Thread(this, "Поставщик").start();
	}

	@Override
	public void run() {
		int n = 0;
		//while(true) {
		for(int i = 0; i < 8; i++) {	
		shared.setN(n++);
		}
	//	}
	}
}
