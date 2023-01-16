package castingTest;

public class CastingTest1 {
	public static void main(String[] args) {
//		자동 형변환
		System.out.println(5 / 2); // 2
		System.out.println(5.0 / 2); // 2.0
		
//		강제 형변환
		System.out.println((double)5 / 2); // 2.5
		System.out.println((int)8.43 + 2.59); // 10.59
		System.out.println((int)(8.43 + 2.59)); // 11
		System.out.println((int)8.43 + (int)2.59); // 10
	}
}
