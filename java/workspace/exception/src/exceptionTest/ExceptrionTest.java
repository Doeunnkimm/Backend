package exceptionTest;

public class ExceptrionTest {
	public static void main(String[] args) {
//		System.out.println(10/0); // 여기서 즉시 강제 종료되기 때문에 밑은 실행 X
//		// 이 오류의 객체를 저장해 놓고 사용하면 catch할 수 있음
//		System.out.println("반드시 실행되어야 하는 문장");
		
//		try {
//			System.out.println(10/0);
//		} catch (ArithmeticException e) {
//			System.out.println("0으로 나눌 수 없습니다.");
//		} catch (Exception e) {
//			// 모든 에러의 부모는 Exception
//			// 업캐스팅으로 가장 최상위 부모 타입으로
//			// 에러를 잡을 수는 있지만
//			// 세부적인 오류를 잡을 수는 없음
//			System.out.println("알 수 없는 오류");
//		}
//		System.out.println("반드시 실행되어야 하는 문장");
//	}
		
		int[] arData = new int[5];
		
//		arData[5] = 10; // 오류가 날 문장이므로 이게 try문으로 들어가야함
//		감싸고 alt + shift + z
		try {
			arData[5] = 10;
		} catch (NumberFormatException e) {
			// 날아온 에러와 위에 작성한 에러 타입이 다르면 못잡음
			e.printStackTrace(); // 오류 추적 -> 몇번째줄 오류, 오류 메시지
			System.out.println(e.getMessage()); // 오류 메시지만 출력
		} finally {
			// 위에서 에러를 못잡더라도 무조건 실행됨
			System.out.println("반드시 실행되어야 하는 문장");
		}
		// try/catch에서 잡지 못하면 이건 실행X
		System.out.println("이건 try/catch 밖에 문장");
	}
}
