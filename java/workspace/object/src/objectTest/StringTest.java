package objectTest;

public class StringTest {
	public static void main(String[] args) {
		// �Ȱ����� 2�� �ִٴ� ��
		// ������ �ٸ��ٴ� ��
		
		// ���� focus
		// �ʵ带 �޸𸮿� �ø���
		// constant pull�� "ABC"�� �Ҵ�
		// ���⿡ �Ҵ� �Ǿ��ٴ� �� �ּҰ��� ����ٴ� ��
		String data1 = "ABC";
		// ������ �ִ� �ּҰ��� ������ ��
		// ������ ���� �ʵ��� �ּҴ� �ٸ�����
		// ���� �ּҴ� ����
		String data2 = "ABC";
		
		// �ʵ忡 focus
		String data3 = new String("ABC");
		String data4 = new String("ABC");
		
		// �ʵ� �ȿ� �ִ� ���� ���� ��
		System.out.println(data1 == data2); // true
		// .intern()�� �ڵ����� �ٿ���
		// ������ �ʵ��� �ּҸ� ���ؾ� �ϴµ�
		// �� �޼ҵ� ������ ���� �ּҸ� ��
		System.out.println(data3 == data4); // false
		// .intern() : �ʵ� �ȿ� ����ִ� ���ڿ��� ���� ������
		System.out.println(data3.intern() == data4.intern()); // true
		
		// equals()�� String Ŭ��������
		// �ʵ��� ���ڿ� ���� ���ϵ��� �������� �޼ҵ�
		// �츮�� ���ڵ� equals�� �� �� �ֵ��� ������ �ʿ�
		System.out.println(data1.equals(data2)); // true
		System.out.println(data3.equals(data4)); // true
	}
}
