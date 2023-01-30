package castingTest;

class Car {
	void engineStart() {
		System.out.println("열쇠로 시동 켬");
	}
}

class SuperCar extends Car {
	@Override
	void engineStart() {
		System.out.println("음성으로 시동 켬");
	}
	
	void openRoof() {
		System.out.println("지붕 열기");
	}
}

public class CastingTest {
	public static void main(String[] args) {
//		up casting : 자식을 부모 타입으로
//		자식 타입에서 더 선언한 필드 부분은 사용할 수 없음
//		재정의한 값은 사용할 수 있음
		Car matiz = new Car();
		SuperCar ferrari = new SuperCar();
		
		
		Car noOptionFerrari = new SuperCar();
		noOptionFerrari.engineStart(); // "음성으로 시동 킴"
		
//		down casting
//		타입을 일치시키고 다운 캐스팅
		SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari;
		fullOptionFerrari.openRoof(); // "지붕 열기"
		
//		오류
//		부모 타입을 자식타입으로 변환 X
//		SuperCar brokenFerrari = new Car();
		
//		instanceof : 조건식
//		객체 instanceof 타입 : 참 또는 거짓
		
//		false가 나오는 경우는 부모가 자식 타입이냐고 물을 때만
//		자식은 부모 타입이기 때문에 무조건 타입이 2개임
		System.out.println(matiz instanceof Car); // true
		System.out.println(matiz instanceof SuperCar); // false
		System.out.println(ferrari instanceof Car); // true
		System.out.println(ferrari instanceof SuperCar); // true
		System.out.println(noOptionFerrari instanceof Car); // true
		System.out.println(noOptionFerrari instanceof SuperCar); // true
		System.out.println(fullOptionFerrari instanceof SuperCar); // true
	}
	
}
