package staticTest;

class Data {
	int data = 10; // �ν��Ͻ� ����
	// ��� ��ü���� �����ؾ� �� �� static �ʵ带 ������
	static int data_s = 10; // Ŭ���� ����
	
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
		
//		Ŭ���� ������ �ٲٸ�
//		Data Ŭ������ �ν��Ͻ����� ��� �� ���� ������
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
//		// static�� ��ü�� �����ϴ� ���� �ƴ϶� Ŭ������ ����
//		// �����ִ� Ŭ������ �˷��ֱ⸸ �ϸ� ��
//		System.out.println(Data.data_s); 
		
//		data.increase_s();
//		data.increase_s();
//		data.increase_s();
//		data.increase_s();
//		data.increase_s();
//		
//		data = new Data();
//				
//		data.increase_s(); // �� �ʱ�ȭ X
//		data.increase_s();
//		data.increase_s();
//		data.increase_s();
//		data.increase_s();
//		
		data.increase();
		data.increase();
		data.increase();
		data.increase();
		
		data = new Data(); // �ּ� �ٲ�
		
		data.increase(); // �� �ٽ� �ʱ�ȭ ��
		data.increase();
		data.increase();
		data.increase();
		data.increase();
		data.increase();

	}
}
