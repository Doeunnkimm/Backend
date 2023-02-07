package objectTest;

public class EqualsTest {
	public static void main(String[] args) {
		Student student = new Student(1, "한동석");
		// 실제 상황에서 비교해 보면
		// 값이 같으면 동일하다고 판단해야 함
		// 주소값이 달라서 다르다고 판단하는 것이 아니라
		// 따라서 equals()를 재정의 해야함
		
		// 필드 주소를 비교하는 것이 아니라
		// 필드의 값을 비교하고 싶다면 equals()를 재정의
		boolean isSame = student.equals(new Student(1, "한동석"));
		System.out.println(isSame);
				
	}
}
