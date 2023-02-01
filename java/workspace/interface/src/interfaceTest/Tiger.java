package interfaceTest;

public class Tiger extends AnimalAdapter {

	// 막상 구현을 하다보니
	// 특정 클래스에서는 일부만 구현하고 싶을 수 있다.
	
	// 골라서 재정의 할 것이면
	// 바로 Animal 인터페이스로 지정 받으면 안된다.
	
	// 중간에 이미 구현된 클래스를 거쳐서 재정의를 해야 한다.
	// 그런데 이때 중간에 있는 클래스는 일반 클래스가 아닌 추상 클래스로
	// 여기서는 결국 무조건 구현해야 할 것과 선택해서 구현할 것들을 구분해서 구현
	// adapter가 붙어 있으면 강제성을 없애주는 클래스다 이말..
	
	@Override
	public void showHands() {
		System.out.println("손을 준다.");
	}
	
	// Adapter에서 없던 메소드는 무조건 재정의 해 줘야 함
	@Override
	public void waitNow() {
		System.out.println("훈련을 한다면.. 가능할 거 같다.");
	}

}
