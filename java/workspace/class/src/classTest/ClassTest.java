package classTest;

class A {
	int data;
	
	A(String name) {
		System.out.println(name);
	}
	
//	자바는 매개변수 개수로도 주소값을 구분한다(메소드 이름이 같더라도).
	A(int data) {
//		this에는 접근한 객체의 주소값을 가지고 있음
//		System.out.println(this);
		this.data = data;
		System.out.println(data);
	}
	
	void printData() {
		System.out.println(data);
	}
}

public class ClassTest {
	public static void main(String[] args) {
		A a = new A(10);
		A b = new A("홍길동");
//		System.out.println(a); // classTest.A@4926097b <- 필드의 주소값이 들어가 있음
//		System.out.println(b); // classTest.A@762efe5d <- 생성자 주소가 계속 다르게 할당
//		a.printData();
	}
}
