package inheritanceTest;

class A {
	String name = "A";
	int data = 10;
	
	public A() {System.out.println("부모 생성자");}
	
	void printName() {
		System.out.println(name);
	}
}

class B extends A {
	
	public B() {
//		super(); // 안 써도 컴파일러가 실행함
		System.out.println("자식 생성자");
		this.data = 20; // 자동참조. this에서 없으면 super에서 찾음
//		super(); // error. 항상 부모가 먼저 올라가 있어야 함
	}
	
	void printData() {
		System.out.println(data);
	}
}

public class InheritanceTest1 {
	public static void main(String[] args) {
		// 자식 생성자를 호출하면 알아서 부모 생성자를 호출함
		B b = new B();
		b.printName(); // A
		b.printData(); // 20
	}
}
