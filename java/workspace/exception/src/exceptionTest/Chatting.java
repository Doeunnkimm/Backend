package exceptionTest;

import java.util.Scanner;

public class Chatting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String message = null;
		
		System.out.print("�޽���: ");
		message = sc.nextLine();
		
//		if(message.equals("�ٺ�")) {
////			���� �߻�
////			gc�� �����ؾ� ���� ����Ǵ� ��
////			throw�� gc���� �˷��ִ� ��
//			try {
//				throw new BadWordException("��Ӿ�� ����� �� �����ϴ�.");
//			} catch (BadWordException e) {
//				for(int i=0; i<message.length(); i++) {
//					System.out.print("*");
//				}
//			}
////			throw new BadWordException("��Ӿ�� ����� �� �����ϴ�");
//		}
		
		if(message.equals("�ٺ�")) {
			System.out.println("���� ����");
			throw new BadWordException("��Ӿ�� ����� �� �����ϴ�.");
		}
		System.out.println("������ �ۼ��ϼ̱���!");
	}
}
