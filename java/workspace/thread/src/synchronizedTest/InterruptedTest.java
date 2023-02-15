package synchronizedTest;

import thread.Thread3;

public class InterruptedTest {
	public static void main(String[] args) {
		Thread3 mineral = new Thread3();
		
		Thread thread = new Thread(mineral);
		
		thread.start();
		
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
//		InterruptedException를 일부로 발생시키는 것
		thread.interrupt();
		
//		프로세스 종료
//		쓰레드 모두 종료
		System.exit(0);
	}
}
