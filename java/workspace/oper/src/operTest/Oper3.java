package operTest;

import java.util.Scanner;

public class Oper3 {
	public static void main(String[] args) {
//		����ڿ��� Ű�� �Է¹ް� 
//		������� ������ ���
//		�Ǽ���� �Ǽ��� ���
//		��) 183 -> 183 ���
//			183.5 -> 183.5 ���
//			180.0 -> 180 ���
		
		Scanner sc = new Scanner(System.in);
		String msg = "Ű�� �Է����ּ���: ", format = null;
		double height = 0.0;
		boolean isInteger = false;
		int length = 0;
		
		System.out.print(msg);
		height = sc.nextDouble();
		
		length = (height - (int)height + "").length() - 2; // 0. ���̸� �������ִ� ��
		isInteger = height - (int)height == 0;
		format = isInteger ? "%.0f" : "%."+ length +"f";
		
		System.out.printf(format, height);

	}
}
