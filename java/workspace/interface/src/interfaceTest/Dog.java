package interfaceTest;

public class Dog implements Animal {

	@Override
	public void sitDown() {
		System.out.println("앉는다.");

	}

	@Override
	public void showHands() {
		System.out.println("손을 준다.");

	}

	@Override
	public void touchNose() {
		System.out.println("코를 내민다.");

	}

	@Override
	public void waitNow() {
		System.out.println("기다린다.");

	}

}
