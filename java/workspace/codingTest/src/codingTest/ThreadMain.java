package codingTest;

import java.util.Scanner;

public class ThreadMain {
	public static void main(String[] args) {
		final int SIZE = 3;
		Runnable mineral = new ThreadTask();
		Scanner sc = new Scanner(System.in);
		Thread[] threads = new Thread[SIZE];
		
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(mineral);
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].setName(sc.next());
			threads[i].start();
			try {threads[i].join();} catch (InterruptedException e) {;}
		}
	}
}






















