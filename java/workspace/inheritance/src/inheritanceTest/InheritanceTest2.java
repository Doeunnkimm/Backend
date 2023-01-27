package inheritanceTest;

class Human {
	String name;
	
//	�⺻ �����ڴ� ���� �����Ѵ�.
	public Human() { // �θ� Ŭ������ �� �⺻ �����ڸ� ����������
		// ������ �ڽ� Ŭ�������� ��� ���� ���� ����
	}
	
	public Human(String name) {
		super();
		this.name = name;
	}

	void eat() {
		System.out.println("�Ա�");
	}
	
	void sleep() {
		System.out.println("�ڱ�");
	}
	
	void walk() {
		System.out.println("�� �߷� �ȱ�");
	}
}

class Monkey extends Human {
//	@Override // �������� ���� �� ����
//	void walk() { // �������̵�
//		// �θ𲨸� �����ϰ� �ڽĿ��� �ٽ� �� ����
//		System.out.println("�� �� �Ǵ� �� �߷� �ȱ�");
//	}
	
//	����Ű �Լ� �̸��� ���� Ctrl+space �ϸ�
//	�������̵� �ɼ� ����
	@Override // ������̼�
	void walk() {
		// �θ� Ŭ������ �ִ� ����� �츮�� �ʹٸ�
		// super. .. ������ش�.
		// ���� ���Ӱ� �ۼ��ϰ� ������ �� ���� ���� �������ִ� ��
		super.walk(); // ������̼� �Ǳ� ���� walk();
		System.out.println("�� �߷� �ȱ�");
		
	}
}

public class InheritanceTest2 {
	public static void main(String[] args) {
		Human human = new Human();
		Monkey monkey = new Monkey();
		human.walk(); // �� �߷� �ȱ�
		monkey.walk(); // �� �߷� �ȱ� �� �߷� �ȱ�
	}
	
}
