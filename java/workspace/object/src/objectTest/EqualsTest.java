package objectTest;

public class EqualsTest {
	public static void main(String[] args) {
		Student student = new Student(1, "�ѵ���");
		// ���� ��Ȳ���� ���� ����
		// ���� ������ �����ϴٰ� �Ǵ��ؾ� ��
		// �ּҰ��� �޶� �ٸ��ٰ� �Ǵ��ϴ� ���� �ƴ϶�
		// ���� equals()�� ������ �ؾ���
		
		// �ʵ� �ּҸ� ���ϴ� ���� �ƴ϶�
		// �ʵ��� ���� ���ϰ� �ʹٸ� equals()�� ������
		boolean isSame = student.equals(new Student(1, "�ѵ���"));
		System.out.println(isSame);
				
	}
}
