package thread;

public class Thread3 implements Runnable {
	
	@Override
	public void run() {
		while(true) {
			System.out.println("�۾���...");
			
//			�ڿ��� ������ ���̿� ���� �����ϸ� ��
			
//			���� ���� ����
			if(Thread.currentThread().isInterrupted()) { // �����带 ���ߴ� �ڵ尡 ���� ���
				break;
			}

//			try {
////				����Ǵ� ���� �����尡 �����
//				Thread.sleep(1000);
//			} catch (InterruptedException e) { // �����带 ���ߴ� �ڵ尡 ���� ���
////				�������Ḧ ����
//				System.out.println("���� �߻�...");
//				break;
//			}
		}
	}
}
