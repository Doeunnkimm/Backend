package interfaceTest;

public abstract class AnimalAdapter implements Animal {

	// Adapter에는 결국에 무조건 구현해야 할 메소드는 빼고 구현해둠
	@Override
	public void sitDown() {;}

	@Override
	public void showHands() {;}

	@Override
	public void touchNose() {;}

}
