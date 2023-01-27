package inheritanceTest;

class Human {
	String name;
	
//	기본 생성자는 직접 선언한다.
	public Human() { // 부모 클래스는 꼭 기본 생성자를 포함해주자
		// 없으면 자식 클래스에서 상속 받을 수가 없음
	}
	
	public Human(String name) {
		super();
		this.name = name;
	}

	void eat() {
		System.out.println("먹기");
	}
	
	void sleep() {
		System.out.println("자기");
	}
	
	void walk() {
		System.out.println("두 발로 걷기");
	}
}

class Monkey extends Human {
//	@Override // 가독성을 위해 꼭 쓰자
//	void walk() { // 오버라이딩
//		// 부모꺼를 무시하고 자식에서 다시 재 정의
//		System.out.println("두 발 또는 네 발로 걷기");
//	}
	
//	단축키 함수 이름을 쓰고 Ctrl+space 하면
//	오버라이딩 옵션 선택
	@Override // 어노테이션
	void walk() {
		// 부모 클래스에 있는 기능을 살리고 싶다면
		// super. .. 사용해준다.
		// 완전 새롭게 작성하고 싶으면 안 쓰고 새로 정의해주는 것
		super.walk(); // 어노테이션 되기 전의 walk();
		System.out.println("네 발로 걷기");
		
	}
}

public class InheritanceTest2 {
	public static void main(String[] args) {
		Human human = new Human();
		Monkey monkey = new Monkey();
		human.walk(); // 두 발로 걷기
		monkey.walk(); // 두 발로 걷기 네 발로 걷기
	}
	
}
