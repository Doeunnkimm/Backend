package arrayTest;

public class ArTask {
	public static void main(String[] args) {
//		1~10까지 배열에 담고 출력
//		int[] arr1 = new int[10];
//		for(int i=0; i<arr1.length; i++) {
//			arr1[i] = i+1;
//		}
//		for (int i = 0; i < arr1.length; i++) {
//			System.out.println(arr1[i]);
//		}
		
//		10~1까지 중 짝수만 배열에 담고 출력
//		int[] arr2 = new int[5];
//		for(int i=0; i<arr2.length; i++) {
//			arr2[i] = (5 - i) * 2;
//		}
//		for (int i = 0; i < arr2.length; i++) {
//			System.out.println(arr2[i]);
//		}
		
//		1~100까지 배열에 담은 후 홀수만 출력
//		int[] arr3 = new int[100];
//		for (int i = 0; i < arr3.length; i++) {
//			arr3[i] = i;
//		}
//		for (int i = 0; i < arr3.length; i++) {
//			if (i%2 == 1) {
//				System.out.println(arr3[i]);
//			}
//		}
//		
//		1~100까지 배열에 담은 후 짝수의 합 출력
//		int[] arr4 = new int[100];
//		int total = 0;
//		
//		for (int i = 0; i < arr4.length; i++) {
//			arr4[i] = i;
//		}
//		
//		for (int i = 0; i < arr4.length; i++) {
//			if (i%2 == 0) {
//				total += arr4[i];
//			}
//		}
//		
//		System.out.println("total: " + total);
//		
//		A~F까지 배열에 담고 출력
		int[] arr5 = new int[26];
		
		for (int i = 0; i < arr5.length; i++) {
			arr5[i] = (char)(65+i);
		}
		for (int i = 0; i < arr5.length; i++) {
			System.out.println(arr5[i]);
		}
		
//		A~F까지 중 C제외하고 배열에 담은 후 출력
		
//		5개의 정수를 입력받고 배열에 담은 후 최대값과 최소값 출력
		
//		사용자가 입력할 정수의 개수만큼 배열을 만든 후 정수를 입력받고 평균 구하기
	}
}
