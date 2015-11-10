import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class InThread implements Runnable{
  public void run() {System.out.println("running...");  }
}

	public class Quest {
		public static void main(String[] args) {
			ExecutorService exec = Executors.newFixedThreadPool(2);
			exec.execute(new InThread());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			exec.execute(new InThread());
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			exec.execute(new InThread());
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			exec.execute(new InThread());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			exec.execute(new InThread());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			exec.execute(new InThread());
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			exec.shutdown(); 
			while (!exec.isTerminated()) {   
				
			}
}}
