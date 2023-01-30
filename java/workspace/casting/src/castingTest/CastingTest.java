package castingTest;

class Car {
	void engineStart() {
		System.out.println("����� �õ� ��");
	}
}

class SuperCar extends Car {
	@Override
	void engineStart() {
		System.out.println("�������� �õ� ��");
	}
	
	void openRoof() {
		System.out.println("���� ����");
	}
}

public class CastingTest {
	public static void main(String[] args) {
//		up casting : �ڽ��� �θ� Ÿ������
//		�ڽ� Ÿ�Կ��� �� ������ �ʵ� �κ��� ����� �� ����
//		�������� ���� ����� �� ����
		Car matiz = new Car();
		SuperCar ferrari = new SuperCar();
		
		
		Car noOptionFerrari = new SuperCar();
		noOptionFerrari.engineStart(); // "�������� �õ� Ŵ"
		
//		down casting
//		Ÿ���� ��ġ��Ű�� �ٿ� ĳ����
		SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari;
		fullOptionFerrari.openRoof(); // "���� ����"
		
//		����
//		�θ� Ÿ���� �ڽ�Ÿ������ ��ȯ X
//		SuperCar brokenFerrari = new Car();
		
//		instanceof : ���ǽ�
//		��ü instanceof Ÿ�� : �� �Ǵ� ����
		
//		false�� ������ ���� �θ� �ڽ� Ÿ���̳İ� ���� ����
//		�ڽ��� �θ� Ÿ���̱� ������ ������ Ÿ���� 2����
		System.out.println(matiz instanceof Car); // true
		System.out.println(matiz instanceof SuperCar); // false
		System.out.println(ferrari instanceof Car); // true
		System.out.println(ferrari instanceof SuperCar); // true
		System.out.println(noOptionFerrari instanceof Car); // true
		System.out.println(noOptionFerrari instanceof SuperCar); // true
		System.out.println(fullOptionFerrari instanceof SuperCar); // true
	}
	
}
