package ambiguity;

public class ClassC implements InterA, InterB {
	// ��ȣ�� ������ ������ ��
	// default void printName() {System.out.println("InterA");}
	
	// �׳� �ƿ� ������ �ع����� ��
	// ����� ���������� ������ �ϴ� ���̰�
	// ���� ����� ������ �θ� ��Ī�ؼ� ����ϸ� ��
	@Override
	public void printName() {
		// InterA�� ������ �װ� ����Ǵ� ��
		// InterB�� ������ �װ� ����Ǵ� ��
		InterA.super.printName();
	}
}
