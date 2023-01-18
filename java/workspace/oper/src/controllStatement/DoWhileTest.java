package controllStatement;

import java.util.Scanner;

public class DoWhileTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String message = "1. 통신 요금 조회\n2. 분실 신고\n3. 통신사 이동\n0. 상담원 연결";
		 int choice = 0;
		 
		 
		 // 초기값 choice = 0이기 때문에
		 // do while문을 사용하지 않고
		 // while(choice != 0) {} 하게 되면
		 // 애초에 반복문이 돌지 않게 됨
		 // 그래서 한번은 그냥 물어보도록 do while 문을 사용해야 함
		 
		 do { // 그래도 한번은 돌아야 해!
			 System.out.println(message);
			 choice = sc.nextInt();
		 } while(choice != 0);
	}
}
