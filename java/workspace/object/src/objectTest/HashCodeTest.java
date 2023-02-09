package objectTest;

import java.util.Random;

public class HashCodeTest {
	public static void main(String[] args) {
		Random random = new Random();
		String data1 = "ABC"; // ��� �� �������� �ʵ��� �ּҰ��� �������
		String data2 = new String("ABC"); // ��� �� �������� �ʵ��� �ּҰ��� �������
		
		// hashCode�� Object Ŭ�������� �����ǵ� ��
		// ���� �ּҰ��� �ߵ��� �Ǿ� ������
		// ���� data1.equals(data2) �� true
		// ��, �� �ؽ��ڵ嵵 ������ hashCode�� �����ǵ� ��
		System.out.println(data1.hashCode()); // 64578
		System.out.println(data2.hashCode()); // 64578
		
		System.out.println(data1.equals(data2)); // true
		System.out.println(data1 == data2);
		// �ڿ� .toString()�� �����Ǿ� �ֱ� ������
		// ����ϸ� �ؽ��ڵ尪�� ������ ��
		// ������ �����̶�� ������ �ؽ��ڵ尡 ������ ��
		// ��Ȯ�� �޸� �ּҴ� �ƴ�
//		System.out.println(random.hashCode());
	}
}
