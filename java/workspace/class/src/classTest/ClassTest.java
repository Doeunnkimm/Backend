package classTest;

class A {
	int data;
	
	A(String name) {
		System.out.println(name);
	}
	
//	�ڹٴ� �Ű����� �����ε� �ּҰ��� �����Ѵ�(�޼ҵ� �̸��� ������).
	A(int data) {
//		this���� ������ ��ü�� �ּҰ��� ������ ����
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
		A b = new A("ȫ�浿");
//		System.out.println(a); // classTest.A@4926097b <- �ʵ��� �ּҰ��� �� ����
//		System.out.println(b); // classTest.A@762efe5d <- ������ �ּҰ� ��� �ٸ��� �Ҵ�
//		a.printData();
	}
}
