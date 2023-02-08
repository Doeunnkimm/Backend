package exceptionTest;

// Exception은 컴파일러가 체크 <- 강제 종료 하기 싫음
// RuntimeException은 컴파일러가 검사하지 않기 때문에 try/catch 하라고 하지 않음(빌드 또는 런타임 에러)
// 따라서 무조건 강제 종료 시키고 싶다면 try/catch를 잡지말아야 하므로
// RuntimeException을 사용해야 함

public class BadWordException extends RuntimeException /* Exception */ {
	public BadWordException(String message) {
		// 콘솔창에 message를 찍어주게됨
		super(message); // 부모의 생성자에 message를 전달
	}
}
