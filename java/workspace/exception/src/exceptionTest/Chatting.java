package exceptionTest;

import java.util.Scanner;

public class Chatting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String message = null;
		
		System.out.print("메시지: ");
		message = sc.nextLine();
		
//		if(message.equals("바보")) {
////			예외 발생
////			gc가 감지해야 강제 종료되는 것
////			throw는 gc에게 알려주는 것
//			try {
//				throw new BadWordException("비속어는 사용할 수 없습니다.");
//			} catch (BadWordException e) {
//				for(int i=0; i<message.length(); i++) {
//					System.out.print("*");
//				}
//			}
////			throw new BadWordException("비속어는 사용할 수 없습니다");
//		}
		
		if(message.equals("바보")) {
			System.out.println("계정 정지");
			throw new BadWordException("비속어는 사용할 수 없습니다.");
		}
		System.out.println("선플을 작성하셨군요!");
	}
}
