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
		
		Integer num1 = new Integer(7); // 박싱
		Integer num2 = new Integer(3);
		Integer num3 = new Integer(7);
		
		int int1 = num1.intValue(); // 언박싱
		int int2 = num2.intValue();
		
		Integer result1 = num1 + num2; // 내부적으로 오토 언박싱해서 연산
		System.out.println(result1); // 10
		
		Integer result2 = int1 - int2;
		System.out.println(result2); // 4
		
		System.out.println(num1 > num2); // true <- 오토언박싱
		System.out.println(num1 == num2); // false
		System.out.println(num1 == num3); // false <- 객체에 동등연산자를 사용하면 주소값을 비교
		System.out.println(num1.equals(num3)); // true
		
		
	}
	
	
	
}
