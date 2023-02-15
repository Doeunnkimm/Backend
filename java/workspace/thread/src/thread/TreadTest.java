package thread;

public class TreadTest {
	public static void main(String[] args) {
//		�츮�� ���ݱ��� main�̶�� thread���� �۾��ߴ� ��
//		������ �ڿ��� ���� ��
//		Thread1 thread1 = new Thread1("��");
//		Thread1 thread2 = new Thread1("��");
		
//		���Ϸ� �����
//		�ü���� �𸣱� ������
//		���� �ü������ ��Ƽ�� ����ϰڴٰ� �˷���� ��
//		�츮�� ���Ϸ� �������� ��Ƽ�� ����� ���̱� ������
//		������ ��Ƽ�� �����ִ� �۾� �ʿ� -> start
//		thread1.run();
//		thread2.run();
		
//		�����ٸ� : ���� �����带 ��Ƽ ������� �ٲ��ִ� �۾�
//		�ϳ��� ó�� ��θ� ���� ó�� ��η� �����ִ� �۾�
//		��Ƽ�� �����ص� default�� �����̱� ������
//		start�� ���� ������ �ؾ� ������ ��Ƽ�� ��!
//		start�� �θ� Tread�� ����� �޼ҵ���
//		thread1.start();
//		thread2.start();
		
//		�ڿ��� �����ϴ� ���
//		Runnable mineral = new Thread2();

//		Runnable�� �������̽��̱� ������
//		�Ʒ�ó�� �ٷ� �����ؼ� ����ص� ��
		Runnable mineral = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
//		�ڿ��� �����Ϸ��� ������ 2�� ����
		Thread t1 = new Thread(mineral, "?");
		Thread t2 = new Thread(mineral, "!");
		
//		t1.start();
//		t2.start();
		
//		join�� ����� �����尡 ������ ���� ������ �����尡 ����ȴ�.
//		��, �̹� join() ���� start()�� ������� ���� �� ����.
		t1.start();
		try {t1.join();} catch (InterruptedException e) {;}
		
		t2.start();
		
//		main thread�� ���� ���� �����
		System.out.println("���ξ����� ����");
	}
}
