package operTest;

public class Oper1 {
	public static void main(String[] args) {
		boolean isTrue = 10 > 6;
		
		System.out.println(10 == 11); // false
		System.out.println(10 > 3);
		System.out.println(isTrue);
		System.out.println(isTrue && 10 != 10);
		System.out.println(isTrue || 10 != 10);
		System.out.println(isTrue && !(10 != 10));
	}
}
