package controllStatement;

import java.util.Scanner;

public class ForTask {
	public static void main(String[] args) {
//		1~100���� ���
		for(int i=0; i<100; i++) {
			System.out.println(i+1);
		}
		
//		100~1���� ���
		for(int i=0; i<100; i++) {
			System.out.println(100-i);
		}
		
//		1~100���� �� ¦���� ���
		for(int i=1; i<= 50; i++) {
			System.out.println(i*2);
		}
		
//		1~10���� �� ���
		int sum = 0;
		for(int i=1; i<=10; i++) {
			sum += i;
		}
		System.out.println("1~10������ ��: " + sum);
		
//		1~n���� �� ���(n�� �Է¹޴´�)
		String msg = "n�� �Է��� �ּ���: ";
		int n = 0, sum = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print(msg);
		n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			sum += i;
		}
//		
//		System.out.println("1~" + n + "������ ��: " + sum);
		
//		A~F���� ���
		for(int i=0; i<26; i++) {
			System.out.println((char)(65+i));
		}
		
//		A~F���� �� C�����ϰ� ���(continue ������� �ʱ�)
		for(int i=0; i<6; i++) {
			if (i != 2) {
				System.out.println((char)(65+i));
			}
		}
		
//		0 1 2 3 0 1 2 3 ���
		for(int i=0; i<12; i++) {
			System.out.print((4+i) % 4);
		}
		
//		aBcDe...Z ���
		for(int i=0; i<26; i++) {
			System.out.println((char)(i%2 == 0 ? i+97 : i+65));
		}
		
		
	}
}
