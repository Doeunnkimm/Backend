package operTest;

import java.util.Scanner;

public class Oper2 {
	public static void main(String[] args) {
//		�� ���� ��Һ�
		Scanner sc = new Scanner(System.in);
		String msg = "�� ������ �Է��� �ּ���: ", result = "";
		int num1 = 0, num2 = 0;
		
		System.out.print(msg);
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		result = num1 > num2 ? "ū ��: " + num1 
				: num1 == num2 ? "�� ���� �����ϴ�" : "ū ��: " + num2;
		
		System.out.println(result);
	}
}