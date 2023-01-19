package stringTest;

public class StringTest {
	public static void main(String[] args) {
		String data = "ABC"; // 내부적으로는 3칸 배열처럼 들어간것
		System.out.println(data.length()); // 3
		System.out.println(data.charAt(1)); // B
		System.out.println(data.indexOf('A')); // 0
	}
}
