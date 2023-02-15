package thread;

public class Thread2 implements Runnable {

	@Override
	public void run() {
//		자원에 접근한 thread 이름을 알아냄
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		}
		
	}
}
