package objectTest;

public class ToStringTest {
	public static void main(String[] args) {
		// 자바에서는 실제 메모리 주소를 알 수 없음
		Student student = new Student(1, "한동석");
		// toString()을 붙이지 않아도 붙음
		// 이때 주소를 원하는 게 아니라 초기화된 필드를 바로 보고 싶다면
		// toString()을 오버라이딩해서 필드를 출력하도록
		System.out.println(student.toString());
	}
}
