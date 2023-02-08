package wrapper;

public class WrapperTest {
	public static void main(String[] args) {
		int data_i = 10;
		// boxing. 객체로 사용할 수 있게 되는 것
//		Integer data_I = new Integer(data_i);	
		// 박싱을 하면 좋은 점은
		// Integer 클래스 안에 있는 메소드를 모두 사용 가능
		// 업캐스팅도 가능
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
