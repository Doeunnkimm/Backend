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
	}
}
