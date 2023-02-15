package synchronizedTest;

public class CU {
	public static void main(String[] args) {
		ATM atm = new ATM(); // 자원
		
		Thread mom = new Thread(atm, "엄마");
		Thread son = new Thread(atm, "아들");
		
		mom.start();
		son.start();
	}
}
