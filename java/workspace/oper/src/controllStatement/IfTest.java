package controllStatement;

import java.util.Scanner;

public class IfTest {
	public static void main(String[] args) {
//		�� ���� ��Һ�
		Scanner sc = new Scanner(System.in);
		String msg = "�� ������ �Է��� �ּ���: ", result = "";
		int num1 = 0, num2 = 0;
		
		System.out.print(msg);
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		if(num1 > num2) {
			result = "ū ��: " + num1;
		} else if (num1 != num2) {
			result = "ū ��: " + num2;
		} else {
			result = "�� ���� �����ϴ�.";
		}	
		System.out.println(result);
	}
}
