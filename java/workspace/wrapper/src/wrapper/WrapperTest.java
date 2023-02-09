package wrapper;

public class WrapperTest {
	public static void main(String[] args) {
		int data_i = 10;
		// boxing. ��ü�� ����� �� �ְ� �Ǵ� ��
//		Integer data_I = new Integer(data_i);	
		// �ڽ��� �ϸ� ���� ����
		// Integer Ŭ���� �ȿ� �ִ� �޼ҵ带 ��� ��� ����
		// ��ĳ���õ� ����
//		Integer data_I = Integer.valueOf(data_i);
		
//		System.out.println(data_I);
		
		// unBoxing
//		data_i = data_I.intValue(); 
		
		// auto boxing
		Integer data_I = data_i;
		// auto unboxing
		data_i = data_I;
		
		Integer num1 = new Integer(7); // �ڽ�
		Integer num2 = new Integer(3);
		Integer num3 = new Integer(7);
		
		int int1 = num1.intValue(); // ��ڽ�
		int int2 = num2.intValue();
		
		Integer result1 = num1 + num2; // ���������� ���� ��ڽ��ؼ� ����
		System.out.println(result1); // 10
		
		Integer result2 = int1 - int2;
		System.out.println(result2); // 4
		
		System.out.println(num1 > num2); // true <- �����ڽ�
		System.out.println(num1 == num2); // false
		System.out.println(num1 == num3); // false <- ��ü�� ������ڸ� ����ϸ� �ּҰ��� ��
		System.out.println(num1.equals(num3)); // true
		
		
	}
	
	
	
}
