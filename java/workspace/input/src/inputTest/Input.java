package inputTest;

import java.util.Scanner;

public class Input {
	public static void main(String[] args) {
//		3개의 정수를 한 번에 입력받은 후 덧셈 출력
//		nextInt() : 입력받은 정수
		
		
		Scanner sc = new Scanner(System.in);
		String msg = "세 정수를 입력해 주세요: ";
		int num1 = 0, num2 = 0, num3 = 0, result = 0;
		
		System.out.print(msg);
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		
		result = num1 + num2 + num3;
		
		System.out.printf("%d + %d + %d = %d", num1, num2, num3, result);
		
		
	}
}
