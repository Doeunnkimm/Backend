package exceptionTest;

public class ExceptrionTest {
	public static void main(String[] args) {
//		System.out.println(10/0); // ���⼭ ��� ���� ����Ǳ� ������ ���� ���� X
//		// �� ������ ��ü�� ������ ���� ����ϸ� catch�� �� ����
//		System.out.println("�ݵ�� ����Ǿ�� �ϴ� ����");
		
//		try {
//			System.out.println(10/0);
//		} catch (ArithmeticException e) {
//			System.out.println("0���� ���� �� �����ϴ�.");
//		} catch (Exception e) {
//			// ��� ������ �θ�� Exception
//			// ��ĳ�������� ���� �ֻ��� �θ� Ÿ������
//			// ������ ���� ���� ������
//			// �������� ������ ���� ���� ����
//			System.out.println("�� �� ���� ����");
//		}
//		System.out.println("�ݵ�� ����Ǿ�� �ϴ� ����");
//	}
		
		int[] arData = new int[5];
		
//		arData[5] = 10; // ������ �� �����̹Ƿ� �̰� try������ ������
//		���ΰ� alt + shift + z
		try {
			arData[5] = 10;
		} catch (NumberFormatException e) {
			// ���ƿ� ������ ���� �ۼ��� ���� Ÿ���� �ٸ��� ������
			e.printStackTrace(); // ���� ���� -> ���°�� ����, ���� �޽���
			System.out.println(e.getMessage()); // ���� �޽����� ���
		} finally {
			// ������ ������ ������� ������ �����
			System.out.println("�ݵ�� ����Ǿ�� �ϴ� ����");
		}
		// try/catch���� ���� ���ϸ� �̰� ����X
		System.out.println("�̰� try/catch �ۿ� ����");
	}
}
