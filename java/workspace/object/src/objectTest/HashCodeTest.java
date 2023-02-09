package objectTest;

import java.util.Random;

public class HashCodeTest {
	public static void main(String[] args) {
		Random random = new Random();
		String data1 = "ABC"; // 사실 상 변수에는 필드의 주소값이 담겨있음
		String data2 = new String("ABC"); // 사실 상 변수에는 필드의 주소값이 담겨있음
		
		// hashCode는 Object 클래스에서 재정의된 것
		// 값의 주소값이 뜨도록 되어 동일함
		// 따라서 data1.equals(data2) 는 true
		// 즉, 두 해쉬코드도 같도록 hashCode도 재정의된 것
		System.out.println(data1.hashCode()); // 64578
		System.out.println(data2.hashCode()); // 64578
		
		System.out.println(data1.equals(data2)); // true
		System.out.println(data1 == data2);
		// 뒤에 .toString()이 생략되어 있기 때문에
		// 출력하면 해쉬코드값이 나오게 됨
		// 동일한 버전이라면 동일한 해쉬코드가 나오게 됨
		// 정확한 메모리 주소는 아님
//		System.out.println(random.hashCode());
	}
}
