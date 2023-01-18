package controllStatement;

import java.util.Scanner;

public class ForTask {
	public static void main(String[] args) {
//		1~100까지 출력
		for(int i=0; i<100; i++) {
			System.out.println(i+1);
		}
		
//		100~1까지 출력
		for(int i=0; i<100; i++) {
			System.out.println(100-i);
		}
		
//		1~100까지 중 짝수만 출력
		for(int i=1; i<= 50; i++) {
			System.out.println(i*2);
		}
		
//		1~10까지 합 출력
		int sum = 0;
		for(int i=1; i<=10; i++) {
			sum += i;
		}
		System.out.println("1~10까지의 합: " + sum);
		
//		1~n까지 합 출력(n은 입력받는다)
		String msg = "n을 입력해 주세요: ";
		int n = 0, sum = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print(msg);
		n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			sum += i;
		}
//		
//		System.out.println("1~" + n + "까지의 합: " + sum);
		
//		A~F까지 출력
		for(int i=0; i<26; i++) {
			System.out.println((char)(65+i));
		}
		
//		A~F까지 중 C제외하고 출력(continue 사용하지 않기)
		for(int i=0; i<6; i++) {
			if (i != 2) {
				System.out.println((char)(65+i));
			}
		}
		
//		0 1 2 3 0 1 2 3 출력
		for(int i=0; i<12; i++) {
			System.out.print((4+i) % 4);
		}
		
//		aBcDe...Z 출력
		for(int i=0; i<26; i++) {
			System.out.println((char)(i%2 == 0 ? i+97 : i+65));
		}
		
		
	}
}
