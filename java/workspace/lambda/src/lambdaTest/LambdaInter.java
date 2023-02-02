package lambdaTest;

@FunctionalInterface
// 어노테이션으로 함수형 인터페이스로 사용하겠다고 명시
// 함수형 인터페이스 안에서는 추상 메소드 단 한 개
public interface LambdaInter {
	public boolean checkMultipleOf10(int number);
}
