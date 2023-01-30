package randomClass;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		Random random = new Random();
		
		for (int i = 0; i < 100; i++) {
			// 0~2전까지의 수를 랜덤하게 리턴
			System.out.println(random.nextInt(2));
		}
		
	}
}
