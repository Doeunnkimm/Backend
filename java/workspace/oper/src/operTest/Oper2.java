package operTest;

import java.util.Scanner;

public class Oper2 {
	public static void main(String[] args) {
//		두 정수 대소비교
		Scanner sc = new Scanner(System.in);
		String msg = "두 정수를 입력해 주세요: ", result = "";
		int num1 = 0, num2 = 0;
		
		System.out.print(msg);
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		result = num1 > num2 ? "큰 값: " + num1 
				: num1 == num2 ? "두 수는 같습니다" : "큰 값: " + num2;
		
		System.out.println(result);
	}
}
