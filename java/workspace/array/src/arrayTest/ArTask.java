package arrayTest;

public class ArTask {
	public static void main(String[] args) {
//		1~10���� �迭�� ��� ���
//		int[] arr1 = new int[10];
//		for(int i=0; i<arr1.length; i++) {
//			arr1[i] = i+1;
//		}
//		for (int i = 0; i < arr1.length; i++) {
//			System.out.println(arr1[i]);
//		}
		
//		10~1���� �� ¦���� �迭�� ��� ���
//		int[] arr2 = new int[5];
//		for(int i=0; i<arr2.length; i++) {
//			arr2[i] = (5 - i) * 2;
//		}
//		for (int i = 0; i < arr2.length; i++) {
//			System.out.println(arr2[i]);
//		}
		
//		1~100���� �迭�� ���� �� Ȧ���� ���
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
//		1~100���� �迭�� ���� �� ¦���� �� ���
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
//		A~F���� �迭�� ��� ���
		int[] arr5 = new int[26];
		
		for (int i = 0; i < arr5.length; i++) {
			arr5[i] = (char)(65+i);
		}
		for (int i = 0; i < arr5.length; i++) {
			System.out.println(arr5[i]);
		}
		
//		A~F���� �� C�����ϰ� �迭�� ���� �� ���
		
//		5���� ������ �Է¹ް� �迭�� ���� �� �ִ밪�� �ּҰ� ���
		
//		����ڰ� �Է��� ������ ������ŭ �迭�� ���� �� ������ �Է¹ް� ��� ���ϱ�
	}
}
