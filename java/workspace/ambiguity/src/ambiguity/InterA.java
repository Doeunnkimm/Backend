package ambiguity;

public interface InterA {
	// �ڵ����� abstract�� ���� �ʵ���
	// �Ϲ� �޼ҵ��� ��� default
	default void printName() {
		System.out.println("InterA");
	}
}
