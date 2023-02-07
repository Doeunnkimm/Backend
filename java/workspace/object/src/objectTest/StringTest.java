package objectTest;

public class StringTest {
	public static void main(String[] args) {
		// 똑같은게 2개 있다는 건
		// 목적이 다르다는 것
		
		// 값에 focus
		// 필드를 메모리에 올리고
		// constant pull에 "ABC"에 할당
		// 여기에 할당 되었다는 건 주소값이 생겼다는 것
		String data1 = "ABC";
		// 기존에 있는 주소값을 가지게 됨
		// 주의할 점은 필드의 주소는 다르지만
		// 값의 주소는 같음
		String data2 = "ABC";
		
		// 필드에 focus
		String data3 = new String("ABC");
		String data4 = new String("ABC");
		
		// 필드 안에 있는 문자 값을 비교
		System.out.println(data1 == data2); // true
		// .intern()을 자동으로 붙여줌
		// 원래는 필드의 주소를 비교해야 하는데
		// 위 메소드 때문에 값의 주소를 비교
		System.out.println(data3 == data4); // false
		// .intern() : 필드 안에 들어있는 문자열의 값을 비교해줌
		System.out.println(data3.intern() == data4.intern()); // true
		
		// equals()는 String 클래스에서
		// 필드의 문자열 값만 비교하도록 재정의한 메소드
		// 우리는 숫자도 equals로 쓸 수 있도록 재정의 필요
		System.out.println(data1.equals(data2)); // true
		System.out.println(data3.equals(data4)); // true
	}
}
