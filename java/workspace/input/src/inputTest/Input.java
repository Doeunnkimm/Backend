package inputTest;

import java.util.Scanner;

public class Input {
	public static void main(String[] args) {
//		3���� ������ �� ���� �Է¹��� �� ���� ���
//		nextInt() : �Է¹��� ����
		
		
		Scanner sc = new Scanner(System.in);
		String msg = "�� ������ �Է��� �ּ���: ";
		int num1 = 0, num2 = 0, num3 = 0, result = 0;
		
		System.out.print(msg);
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		
		result = num1 + num2 + num3;
		
		System.out.printf("%d + %d + %d = %d", num1, num2, num3, result);
		
		
	}
}
