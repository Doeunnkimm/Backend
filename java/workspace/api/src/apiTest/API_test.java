package apiTest;

public class API_test {
	public static void main(String[] args) {
		// import 해왔기 때문에 내꺼처럼 사용이 가능
		Calc calc = new Calc();
		try {
			System.out.println(calc.divide(10, 3));
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
	}
}
