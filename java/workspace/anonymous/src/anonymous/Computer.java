package anonymous;

public class Computer {
	public static void main(String[] args) {
		// 인터페이스를 바로 사용하기
		// 바로 인터페이스 지정받기
		Game rpg = new Game() { // 하나의 클래스 <- 안에 메소드가 선언되어 있어서
			// 익명 클래스는 구현되지 않은 필드를 구현하려고 생성
			// Game() 이라는 생성자가
			// 익명 클래스를 메모리에 올려서 주소값을 가져와 줌
			// Game 인터페이스를 메모리에 올리는게 아니라
			// 구현한 구현체를 메모리에 올려서 주소값을 가져오는 것
			
			// 익명 클래스는 지금 Game 인터페이스의 자식 클래스이기 때문에
			// Game rpg = new Game() {...} 은 업캐스팅
			// 따라서 익명 클래스 내부에서 더 선언을 해 봤자
			// 업 캐스팅 되면서 다 잘려버림
			
			// 익명 클래스에서 구현을 해서 메모리에 올리는 것
			// 익명 클래스는 Game 인터페이스의 자식 클래스
			// 자식 클래스는 무조건 부모 타입이므로
			// 인터페이스는 구현 X
			
			// 익명 클래스는 재활용 하지 않겠다는 의미
			// 일회성
			
			@Override
			public void play() {
				System.out.println("게임 스타트");
			}
			
			@Override
			public void exit() {
				System.out.println("게임 오버");
			}
		};
		
		rpg.play();
	}
}
