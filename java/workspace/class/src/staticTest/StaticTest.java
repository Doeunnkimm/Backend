package staticTest;

class Data {
	int data = 10; // 인스턴스 변수
	// 모든 객체들이 공유해야 할 때 static 필드를 선언함
	static int data_s = 10; // 클래스 변수
	
	void increase() {
		System.out.println(++data);
	}
	
	void increase_s() {
		System.out.println(++data_s);
	}
}

public class StaticTest {
	public static void main(String[] args) {
		Data data1 = new Data();
		Data data2 = new Data();
		
//		클래스 변수를 바꾸면
//		Data 클래스의 인스턴스들은 모두 이 값을 공유함
		Data.data_s = 20;
		
//		System.out.println(data1.data_s);
//		System.out.println(data2.data_s);
//		
//		data1.data = 20;
//		
//		System.out.println(data1.data);
//		System.out.println(data2.data);
		
		Data data = new Data();
//		
//		System.out.println(data.data); // 10
//		// static은 객체로 접근하는 것이 아니라 클래스로 접근
//		// 속해있는 클래스를 알려주기만 하면 됨
//		System.out.println(Data.data_s); 
		
//		data.increase_s();
//		data.increase_s();
//		data.increase_s();
//		data.increase_s();
//		data.increase_s();
//		
//		data = new Data();
//				
//		data.increase_s(); // 값 초기화 X
//		data.increase_s();
//		data.increase_s();
//		data.increase_s();
//		data.increase_s();
//		
		data.increase();
		data.increase();
		data.increase();
		data.increase();
		
		data = new Data(); // 주소 바꿈
		
		data.increase(); // 값 다시 초기화 됨
		data.increase();
		data.increase();
		data.increase();
		data.increase();
		data.increase();

	}
}
