package inheritanceTest;

class A {
	String name = "A";
	int data = 10;
	
	public A() {System.out.println("�θ� ������");}
	
	void printName() {
		System.out.println(name);
	}
}

class B extends A {
	
	public B() {
//		super(); // �� �ᵵ �����Ϸ��� ������
		System.out.println("�ڽ� ������");
		this.data = 20; // �ڵ�����. this���� ������ super���� ã��
//		super(); // error. �׻� �θ� ���� �ö� �־�� ��
	}
	
	void printData() {
		System.out.println(data);
	}
}

public class InheritanceTest1 {
	public static void main(String[] args) {
		// �ڽ� �����ڸ� ȣ���ϸ� �˾Ƽ� �θ� �����ڸ� ȣ����
		B b = new B();
		b.printName(); // A
		b.printData(); // 20
	}
}
