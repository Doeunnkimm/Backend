package exceptionTest;

import java.util.Scanner;

public class ExceptionTask {
	public static void main(String[] args) {
//		5개의 정수만 입력 받기
//		- 무한 입력 상태로 구현
//		- q를 입력 시 나가기
//		- 각 정수는 배열에 담기
//		- if문은 딱 한번만 사용하기
		
		Scanner sc = new Scanner(System.in);
		int[] arData = new int[5];
		String temp = null;
		
		// 중간에 조건식이 없는 for문을 작성하면 무한 반복
		for(int i=0; ; ) {
			System.out.println(i+1 + "번째 정수[q: 나가기]: ");
			temp = sc.next();
			if(temp.toLowerCase().equals("q")) { break; }
			
			// 정수를 입력할 경우
			// 정수를 입력하면 에러, 인덱스 넘어가면 오류,..
			try {
				arData[i] = Integer.parseInt(temp); // 여기서 문제가 생기면 아래 문장은 실행 X
				i++; // 위에서 잘 실행되었다면 그때만 인덱스 ++
			} catch (NumberFormatException e) {
				// 숫자가 아닌 타입을 입력한 경우
				System.out.println("정수만 입력해주세요.");
//				i--; // 잘못 입력된 인덱스는 추가 되지 않도록 돌아가기
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("5개의 정수만 입력이 가능합니다.");
				
				for (int j = 0; j < arData.length; j++) {
					System.out.println(arData[j] + " ");
				}
				
				break;
				
			} catch (Exception e) {
				System.out.println("다시 시도해주세요.");
			}
			
		} 
		
	}
}
