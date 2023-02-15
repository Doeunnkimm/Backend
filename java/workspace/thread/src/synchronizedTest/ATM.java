package synchronizedTest;

import java.util.Iterator;

public class ATM implements Runnable {
	
	private int money;
	
	public ATM() {
		this.money = 10000;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			withdraw();
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		}
	}
	
//	자원의 공유 문제 발생 시 동기화를 사용하여, 멀티 환경에서 특정 부분을 단이 환경으로
//	바꿔줘야 한다.
	public synchronized void withdraw() {
//		synchronized (this) { // 자원을 구현한 객체(자원의 주인) : mutex
			// 해당 객체 안에서 run을 객체 했으므로
			// this를 적음
			// 이 블록 안의 코드는 단일로 처리
			// 여러 자원이 한번에 들어올 수가 없음
			
			// 무조건 한번이 출금이 완료되어야 다음 사람이 출금이 되도록
			this.money -= 1000;
			
			System.out.println(Thread.currentThread().getName() + "이(가) 1000원 출금");
			System.out.println("현재 잔액: " + this.money + "원");
//		}
	}
}
