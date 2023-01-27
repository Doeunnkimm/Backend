package access2;

import access1.Variable;

public class VariableTest {
	public static void main(String[] args) {
		Variable variable = new Variable(10);
//		variable. // public data2만 뜨게 됨
		
//		private 변수에 접근하는 방법은 있음..
		System.out.println(variable.getData4());
	}
}
