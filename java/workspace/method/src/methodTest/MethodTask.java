package methodTest;

public class MethodTask {
//	1~10���� println()���� ����ϴ� �޼ҵ�
	void printTen() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i+1);
		}
	}
	
//	"ȫ�浿"�� n�� println()���� ����ϴ� �޼ҵ�
	void printHong(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("ȫ�浿");
		}
	}
	
//	�̸��� n�� println()���� ����ϴ� �޼ҵ�
	void printName(String name, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(name);
		}
	}
	
//	�� ������ �������ִ� �޼ҵ�
	int subtractNum(int num1, int num2, int num3) {
		return num1-num2-num3;
	}
	
//	�� ������ ������ �� ��� ������ �� ���� ���ϴ� �޼ҵ�
	int[] divide(int num1, int num2) {
		int[] arDivide = new int[2];
		
		if(num2 != 0) { // 0���� �������� ��찡 �ƴ� ��
			arDivide[0] = num1 / num2;
			arDivide[1] = num1%num2;
		}
		
		return arDivide;
	}
	
//	1~n������ ���� �����ִ� �޼ҵ�
	int add(int n) {
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += n + 1;
		}
		return total;
	}
	
//	Ȧ���� ¦����, ¦���� Ȧ���� �ٲ��ִ� �޼ҵ�
	int reverse(int n){
		return n+1;
	}
	
//	���ڿ��� �Է¹ް� �ҹ��ڴ� �빮�ڷ�, �빮�ڴ� �ҹ��ڷ� �ٲ��ִ� �޼ҵ�
	String reverseString(String str) {
		String newStr = "";
		for (int i = 0; i < str.length(); i++) {
			char thisChar = str.charAt(i);
			newStr += thisChar >= 97 && thisChar <= 90 ? (char)(thisChar-32) : (char)(thisChar+32);
		}
		return newStr;
	}
	
//	���ڿ��� �Է¹ް� ���ϴ� ������ ������ �����ִ� �޼ҵ�
	int numberOfChar(String str, char ch) {
		int total = 0;
		for (int i = 0; i < str.length(); i++) {
			char thisChar = str.charAt(i);
			total += thisChar == ch ? 1 : 0;
		}
		return total;
	}
	
//	5���� ������ �Է¹��� �� ���ϴ� �ε����� ���� �����ִ� �޼ҵ�
	int choiceIndex(int[] arNum, int idx) {
		return arNum[idx];
	}
	
//	�ѱ��� ������ �ٲ��ִ� �޼ҵ�(�ϰ��̻� -> 1024)
	int changeToInteger(String str) {
		String strOriginal = "�����̻�����ĥ�ȱ�";
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			result += strOriginal.indexOf(str.charAt(i));
		}
		
		return Integer.parseInt(result);
	}
	
//	5���� ������ �Է¹ް� �ִ방�� �ּҰ��� �����ִ� �޼ҵ�
	int[] getMaxAndMin(int[] arNum) {
		int[] results = new int[2];
		results[0] = arNum[0];
		results[1] = arNum[0];
		
		for (int i = 0; i < arNum.length; i++) {
			if(results[0] < arNum[i]) { results[0] = arNum[i]; }
			if(results[0] > arNum[i]) { results[1] = arNum[i]; }
		}
		return results;
	}
	
//	5���� ������ �Է¹ް� �ִ밪�� �ּҰ��� �����ִ� �޼ҵ�(void)
	void getMaxAndMin2(int[] arData, int[] results) {
	      results[0] = arData[0];
	      results[1] = arData[0];
	      
	      for (int i = 1; i < arData.length; i++) {
	         if(results[0] < arData[i]) { results[0] = arData[i]; }
	         if(results[1] > arData[i]) { results[1] = arData[i]; }
	      }
	   }

	
//	indexOf() �����
int indexOf(String str, char target) {
		for (int i = 0; i < str.length(); i++) {
			char thisChar = str.charAt(i);
			if (thisChar == target) {
				return i;
			}
		}
		return -1;
	}
}