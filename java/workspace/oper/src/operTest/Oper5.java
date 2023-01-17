package operTest;

public class Oper5 {
	public static void main(String[] args) {
		int data = 10;
//		data = data + 1;
//		data += 1;
//		data++;
		System.out.println(data++); // 10 후위형은 다음줄부터 반영이 됨
		System.out.println(data); // 11
		
		System.out.println(++data); // 12 전위형은 이번줄부터 반드시 반영이 됨
		
	}
}
