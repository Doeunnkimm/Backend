package classTest;

import java.util.Scanner;

class SuperCar {
	String brand;
	String color;
	int price;
	boolean engine;
	String password;
	int errorCount;
	
//	초기화 블록
//	객체가 생성이 되면 매번 다음 블록이 실행된다.
	{
		this.password = "0000";
	}
	
	// 처음부터 뭐를 넣을지 모르는 상황을 위해
	// 기본 생성자까지 오버로딩 해준다.
	public SuperCar() {	}
	
	public SuperCar(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

//	시동켜기
//	엔진 상태를 확인하고
//	시동이 꺼져있다면, "시동 켜짐" 출력
//	시동이 켜져있다면, "시동이 이미 켜져있습니다." 출력
//	boolean engineStart() {
//		if(!engine) {
//			engine = true;
//			return true; // 잘 시행되었다.
//		}
//		return false; // 잘 안 시행되었다.
//	}
	
//	엔진이 켤 수 있는 상태에서만
//	아래 메소드를 실행하면 됨
	void engineStart() {
		engine = true;
	}
	
//	시동끄기
//	엔진 상태를 확인하고
//	시동이 꺼져있다면, "시동 꺼짐" 출력
//	시동이 켜져있다면, "시동이 이미 꺼져있습니다." 출력
	boolean engineStop() {
		if(engine) {
			engine = false;
			return true;
		}
		return false;
	}
	
//	void engineStop() {
//		engine = false;
//	}
	
//	시동을 켜기 위해서 비밀번호 4자리를 입력받아야 한다.
//	3번 연속 잘못 이벽했을 시 "경찰 출동" 출력
//	※ 문자열 비교는 equals()로 비교한다.
//	"ABC".equals("문자열")
	boolean checkPassword(String password) {
		// 들어온 비밀번호값이 기존 비밀번호와 일치하는지
		// 맞으면 true를 리턴. 틀리면 false를 리턴하는
		// 역할이 다!
		return this.password.equals(password);
	}
}

public class ClassTask1 {
	public static void main(String[] args) {
		SuperCar mom = new SuperCar("페라리", "빨간색", 68_000);
//		mom.brand = "페라리";
		Scanner sc = new Scanner(System.in);
		String menu = "1. 시동켜기\n2. 시동끄기";
		int choice = 0;
		String password = null;
		
		while(true) {
			System.out.println(menu);
			choice = sc.nextInt();
			boolean check = false;
			
			switch(choice) {
			case 1: // 시동켜기
				// 먼저 시동의 상태 확인하기
				if(!mom.engine) { // 시동을 켤 수 있는 상태
					System.out.print("비밀번호: ");
					password = sc.next();
					if(mom.checkPassword(password)) {
						mom.engineStart();
						System.out.println("시동 꺼짐");
						mom.errorCount = 0; // 비밀번호 맞추면 초기화
						break;
					}
					mom.errorCount++;
					System.out.println(mom.errorCount + "회 비밀번호 오류");
					if(mom.errorCount == 3) {
						System.out.println("경찰 출동");
						// 여기에서의 break는 switch문을 탈출하는 
						// 따라서 flag를 찍어주고 완전히 while문 탈출
						check = true;
						break;
					}
					break;
				}
				System.out.println("이미 시동이 켜져있습니다.");
				break;
				
			case 2: // 시동끄기
				if(mom.engineStop()) {
					System.out.println("시동 꺼짐");
					check= true;
					break;
				}
				System.out.println("이미 시동이 꺼져있습니다.");
				break;
			}
			
			if(check) {
				break;
			}
	}
		
//		while(true) {
//			System.out.println(menu);
//			choice = sc.nextInt();
//			switch(choice) {
//			case 1:
//				if(mom.engineStart()) {
//					System.out.println("시동 켜짐");
//					break;
//				}
//				System.out.println("시동이 이미 켜져있습니다.");
//				break;
//			case 2:
//				if(mom.engineStop()) {
//					System.out.println("시동 꺼짐");
//					break;
//				}
//				System.out.println("시동이 이미 꺼져있습니다.");
//				break;
//			}
//		}
		
	}
}
