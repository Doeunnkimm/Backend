package methodTest;

public class MethodTask {
//	1~10까지 println()으로 출력하는 메소드
	void printTen() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i+1);
		}
	}
	
//	"홍길동"을 n번 println()으로 출력하는 메소드
	void printHong(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("홍길동");
		}
	}
	
//	이름을 n번 println()으로 출력하는 메소드
	void printName(String name, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(name);
		}
	}
	
//	세 정수를 뺄셈해주는 메소드
	int subtractNum(int num1, int num2, int num3) {
		return num1-num2-num3;
	}
	
//	두 정수의 나눗셈 후 몫과 나머지 두 개를 구하는 메소드
	int[] divide(int num1, int num2) {
		int[] arDivide = new int[2];
		
		if(num2 != 0) { // 0으로 나눠지는 경우가 아닐 때
			arDivide[0] = num1 / num2;
			arDivide[1] = num1%num2;
		}
		
		return arDivide;
	}
	
//	1~n까지의 합을 구해주는 메소드
	int add(int n) {
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += n + 1;
		}
		return total;
	}
	
//	홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
	int reverse(int n){
		return n+1;
	}
	
//	문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
	String reverseString(String str) {
		String newStr = "";
		for (int i = 0; i < str.length(); i++) {
			char thisChar = str.charAt(i);
			newStr += thisChar >= 97 && thisChar <= 90 ? (char)(thisChar-32) : (char)(thisChar+32);
		}
		return newStr;
	}
	
//	문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
	int numberOfChar(String str, char ch) {
		int total = 0;
		for (int i = 0; i < str.length(); i++) {
			char thisChar = str.charAt(i);
			total += thisChar == ch ? 1 : 0;
		}
		return total;
	}
	
//	5개의 정수를 입력받은 후 원하는 인덱스의 값을 구해주는 메소드
	int choiceIndex(int[] arNum, int idx) {
		return arNum[idx];
	}
	
//	한글을 정수로 바꿔주는 메소드(일공이사 -> 1024)
	int changeToInteger(String str) {
		String strOriginal = "공일이삼사오육칠팔구";
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			result += strOriginal.indexOf(str.charAt(i));
		}
		
		return Integer.parseInt(result);
	}
	
//	5개의 정수를 입력받고 최대갑솩 최소값을 구해주는 메소드
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
	
//	5개의 정수를 입력받고 최대값가 최소값을 구해주는 메소드(void)
	void getMaxAndMin2(int[] arData, int[] results) {
	      results[0] = arData[0];
	      results[1] = arData[0];
	      
	      for (int i = 1; i < arData.length; i++) {
	         if(results[0] < arData[i]) { results[0] = arData[i]; }
	         if(results[1] > arData[i]) { results[1] = arData[i]; }
	      }
	   }

	
//	indexOf() 만들기
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