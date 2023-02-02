package ambiguity;

public interface InterA {
	// 자동으로 abstract가 붙지 않도록
	// 일반 메소드라고 명시 default
	default void printName() {
		System.out.println("InterA");
	}
}
