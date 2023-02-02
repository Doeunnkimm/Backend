package lambdaTest;

public class LambdaTest {
	public static void main(String[] args) {
		// 이것도 업캐스팅
		// 익명 클래스를 대신 해서 람다식으로 사용하는 방법
		
//		익명 클래스를 사용하거나 람다식을 사용하는 것에 있어서
//		동작 원리는 전혀 차이가 없다.
//		그렇기에 더 간결한 람다를 선호한다.
		
//		LambdaInter lambdaInter = new LambdaInter() {
//			
//			@Override
//			public boolean checkMultipleOf10(int number) {
//				return number % 10 == 0;
//			}
//		};
		
		LambdaInter lambdaInter = n -> n % 10 == 0;
		System.out.println(lambdaInter.checkMultipleOf10(20));
	}
}
