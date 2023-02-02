package ambiguity;

public class ClassC implements InterA, InterB {
	// 모호성 때문에 빨간줄 뜸
	// default void printName() {System.out.println("InterA");}
	
	// 그냥 아예 재정의 해버리는 것
	// 사실은 형식적으로 재정의 하는 것이고
	// 내가 사용할 것으로 부모를 지칭해서 사용하면 됨
	@Override
	public void printName() {
		// InterA를 받으면 그게 실행되는 것
		// InterB를 받으면 그게 실행되는 것
		InterA.super.printName();
	}
}
