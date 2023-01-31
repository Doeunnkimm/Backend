package abstractTest;

public abstract class Electronics {
	// 무조건 재정의 해라
	public abstract void on(); // 추상 메소드
	public abstract void off(); 
	
	// 맘대로 해라
	public void printProduct() {}; // 일반 메소드
	
	// 재정의 하지마라
	public final void sos() {System.out.println("긴급전화 119 연락");}
}
