package thread;

public class TreadTest {
	public static void main(String[] args) {
//		우리는 지금까지 main이라는 thread에서 작업했던 것
//		각자의 자원을 만든 것
//		Thread1 thread1 = new Thread1("★");
//		Thread1 thread2 = new Thread1("♥");
		
//		단일로 실행됨
//		운영체제는 모르기 때문에
//		따라서 운영체제에게 멀티로 사용하겠다고 알려줘야 함
//		우리는 단일로 만들어놓고 멀티로 사용할 것이기 때문에
//		단일을 멀티로 나눠주는 작업 필요 -> start
//		thread1.run();
//		thread2.run();
		
//		스케줄링 : 단일 쓰레드를 멀티 쓰레드로 바꿔주는 작업
//		하나의 처리 경로를 여러 처리 경로로 나눠주는 작업
//		멀티로 설계해도 default가 단일이기 때문에
//		start를 통해 실행을 해야 단일이 멀티가 됨!
//		start는 부모 Tread에 선언된 메소드임
//		thread1.start();
//		thread2.start();
		
//		자원을 공유하는 경우
//		Runnable mineral = new Thread2();

//		Runnable이 인터페이스이기 때문에
//		아래처럼 바로 구현해서 사용해도 됨
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
//		자원을 공유하려고 쓰레드 2개 만듦
		Thread t1 = new Thread(mineral, "?");
		Thread t2 = new Thread(mineral, "!");
		
//		t1.start();
//		t2.start();
		
//		join을 사용한 쓰레드가 끝나고 나서 나머지 쓰레드가 실행된다.
//		단, 이미 join() 전에 start()된 쓰레드는 멈출 수 없다.
		t1.start();
		try {t1.join();} catch (InterruptedException e) {;}
		
		t2.start();
		
//		main thread가 가장 먼저 실행됨
		System.out.println("메인쓰레드 종료");
	}
}
