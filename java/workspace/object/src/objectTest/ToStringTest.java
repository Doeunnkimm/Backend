package objectTest;

public class ToStringTest {
	public static void main(String[] args) {
		// �ڹٿ����� ���� �޸� �ּҸ� �� �� ����
		Student student = new Student(1, "�ѵ���");
		// toString()�� ������ �ʾƵ� ����
		// �̶� �ּҸ� ���ϴ� �� �ƴ϶� �ʱ�ȭ�� �ʵ带 �ٷ� ���� �ʹٸ�
		// toString()�� �������̵��ؼ� �ʵ带 ����ϵ���
		System.out.println(student.toString());
	}
}
