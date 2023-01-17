package controllStatement;

import java.util.Scanner;

public class IfTest {
	public static void main(String[] args) {
//		두 정수 대소비교
		Scanner sc = new Scanner(System.in);
		String msg = "두 정수를 입력해 주세요: ", result = "";
		int num1 = 0, num2 = 0;
		
		System.out.print(msg);
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		if(num1 > num2) {
			result = "큰 값: " + num1;
		} else if (num1 != num2) {
			result = "큰 값: " + num2;
		} else {
			result = "두 수가 같습니다.";
		}	
		System.out.println(result);
	}
}
