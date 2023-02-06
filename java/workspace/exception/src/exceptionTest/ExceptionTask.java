package exceptionTest;

import java.util.Scanner;

public class ExceptionTask {
	public static void main(String[] args) {
//		5���� ������ �Է� �ޱ�
//		- ���� �Է� ���·� ����
//		- q�� �Է� �� ������
//		- �� ������ �迭�� ���
//		- if���� �� �ѹ��� ����ϱ�
		
		Scanner sc = new Scanner(System.in);
		int[] arData = new int[5];
		String temp = null;
		
		// �߰��� ���ǽ��� ���� for���� �ۼ��ϸ� ���� �ݺ�
		for(int i=0; ; ) {
			System.out.println(i+1 + "��° ����[q: ������]: ");
			temp = sc.next();
			if(temp.toLowerCase().equals("q")) { break; }
			
			// ������ �Է��� ���
			// ������ �Է��ϸ� ����, �ε��� �Ѿ�� ����,..
			try {
				arData[i] = Integer.parseInt(temp); // ���⼭ ������ ����� �Ʒ� ������ ���� X
				i++; // ������ �� ����Ǿ��ٸ� �׶��� �ε��� ++
			} catch (NumberFormatException e) {
				// ���ڰ� �ƴ� Ÿ���� �Է��� ���
				System.out.println("������ �Է����ּ���.");
//				i--; // �߸� �Էµ� �ε����� �߰� ���� �ʵ��� ���ư���
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("5���� ������ �Է��� �����մϴ�.");
				
				for (int j = 0; j < arData.length; j++) {
					System.out.println(arData[j] + " ");
				}
				
				break;
				
			} catch (Exception e) {
				System.out.println("�ٽ� �õ����ּ���.");
			}
			
		} 
		
	}
}
