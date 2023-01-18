package controllStatement;

import java.util.Scanner;

public class DoWhileTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String message = "1. 통신 요금 조회\n2. 분실 신고\n3. 통신사 이동\n0. 상담원 연결";
		 int choice = 0;
		 
		 do { // 그래도 한번은 돌아야 해!
			 System.out.println(message);
			 choice = sc.nextInt();
		 } while(choice != 0);
	}
}
