package ambiguity;

// ������ �̸��� �Ű������� ������ �ִ� Ŭ������ �������̽��� ���ÿ� ���
// �θ� Ŭ������ �켱�̶� ������ �߻����� ����
public class ClassB extends ClassA implements InterA {
	public static void main(String[] args) {
		// �θ� Ŭ���� �޼ҵ尡 ����
		new ClassB().printName();
	}
 }
