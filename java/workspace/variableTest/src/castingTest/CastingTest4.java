package castingTest;

public class CastingTest4 {
	public static void main(String[] args) {
		System.out.println("1" + 3 + 9); // 139
		System.out.println(Integer.parseInt("1") + 3 + 9); // 13
		System.out.println("3.9" + 9); // 3.99
		System.out.println(Double.parseDouble("3.9") + 9); // 12.9
	}
}
