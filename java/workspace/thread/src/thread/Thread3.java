package thread;

public class Thread3 implements Runnable {
	
	@Override
	public void run() {
		while(true) {
			System.out.println("작업중...");
			
//			자원의 로직의 차이에 따라 결정하면 됨
			
//			정상 종료 유도
			if(Thread.currentThread().isInterrupted()) { // 쓰레드를 멈추는 코드가 없을 경우
				break;
			}

//			try {
////				실행되는 순간 쓰레드가 종료됨
//				Thread.sleep(1000);
//			} catch (InterruptedException e) { // 쓰레드를 멈추는 코드가 있을 경우
////				정상종료를 유도
//				System.out.println("오류 발생...");
//				break;
//			}
		}
	}
}
