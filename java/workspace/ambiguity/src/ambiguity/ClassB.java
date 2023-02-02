package ambiguity;

// 동일한 이름과 매개변수를 가지고 있는 클래스와 인터페이스를 동시에 상속
// 부모 클래스가 우선이라 에러가 발생하지 않음
public class ClassB extends ClassA implements InterA {
	public static void main(String[] args) {
		// 부모 클래스 메소드가 실행
		new ClassB().printName();
	}
 }
