package synchronizedTest;

import thread.Thread3;

public class InterruptedTest {
	public static void main(String[] args) {
		Thread3 mineral = new Thread3();
		
		Thread thread = new Thread(mineral);
		
		thread.start();
		
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
//		InterruptedException�� �Ϻη� �߻���Ű�� ��
		thread.interrupt();
		
//		���μ��� ����
//		������ ��� ����
		System.exit(0);
	}
}
