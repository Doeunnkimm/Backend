package inputTest;

import java.util.Scanner;

public class InputTask {
	public static void main(String[] args) {
//		�� ������ �Է��� �� ���� ��� ���
//		��, next()�� ����Ѵ�.
		
		Scanner sc = new Scanner(System.in);
		String msg = "�� ������ �Է��� �ּ���: ";
		int num1 = 0, num2 = 0, result = 0;
		
		System.out.print(msg);
		num1 = Integer.parseInt(sc.next());
		num2 = Integer.parseInt(sc.next());
		
		result = num1 * num2;
		
		System.out.printf("%d * %d = %d", num1, num2, result);
		
	}
}
