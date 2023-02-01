package interfaceTest;

public class Cat implements Animal{

	@Override
	public void sitDown() {
		System.out.println("앉지 않는다.");
	}

	@Override
	public void showHands() {
		System.out.println("손은 준다. 가끔");
	}

	@Override
	public void touchNose() {
		System.out.println("못 알아듣는다.");
	}

	@Override
	public void waitNow() {
		System.out.println("안된다");
	}
	
}
