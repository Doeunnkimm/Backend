package controllStatement;

import java.util.Scanner;

public class DoWhileTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String message = "1. ��� ��� ��ȸ\n2. �н� �Ű�\n3. ��Ż� �̵�\n0. ���� ����";
		 int choice = 0;
		 
		 
		 // �ʱⰪ choice = 0�̱� ������
		 // do while���� ������� �ʰ�
		 // while(choice != 0) {} �ϰ� �Ǹ�
		 // ���ʿ� �ݺ����� ���� �ʰ� ��
		 // �׷��� �ѹ��� �׳� ������� do while ���� ����ؾ� ��
		 
		 do { // �׷��� �ѹ��� ���ƾ� ��!
			 System.out.println(message);
			 choice = sc.nextInt();
		 } while(choice != 0);
	}
}
