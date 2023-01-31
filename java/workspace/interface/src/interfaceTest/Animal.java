package interfaceTest;

// 인터페이스에는 상수와 추상 메소드만 선언 가능!!!!
public interface Animal {
	final static int nose = 1;
	int eyes = 2; // 알아서 상수
	
	abstract void sitDown();
	void showHands(); // 알아서 추상 메소드
	void touchNose();
	void waitNow();
}
