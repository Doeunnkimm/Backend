package inputTest;

import java.util.Scanner;

public class InputTask {
	public static void main(String[] args) {
//		두 정수를 입력한 뒤 곱셈 결과 출력
//		단, next()만 사용한다.
		
		Scanner sc = new Scanner(System.in);
		String msg = "두 정수를 입력해 주세요: ";
		int num1 = 0, num2 = 0, result = 0;
		
		System.out.print(msg);
		num1 = Integer.parseInt(sc.next());
		num2 = Integer.parseInt(sc.next());
		
		result = num1 * num2;
		
		System.out.printf("%d * %d = %d", num1, num2, result);
		
	}
}
