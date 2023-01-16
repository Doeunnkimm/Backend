package castingTest;

public class Encryption {
	public static void main(String[] args) {
		String password = "a1b2c3";
		String encrypedPassword = "", decryptedPassword = "";
		final int KEY = 3;
		
		for (int i=0; i < password.length(); i++) {
			encrypedPassword += (char)(password.charAt(i) * 3);
		}
		
		System.out.println(encrypedPassword);
		
		for (int i=0; i < encrypedPassword.length(); i++) {
			decryptedPassword += (char)(encrypedPassword.charAt(i) / 3);
		}
		
		System.out.println(decryptedPassword);
	}
}
