package arrayListTest;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {

	public static void main(String[] args) {
		// <?>: 제네릭(이름이 없는)
		// 객체화 시 타입을 지정하는 기법
		// 설계할 때 타입을 지정할 수 없기 때문에 임시로 타입을 선언할 대 사용한다.

		// Object 클래스가 아니라 제네릭을 사용하는 이유
		// 1. 따로 다운캐스팅을 할 필요 없음
		// 2. 지정한 타입에 제한을 둘 수 있음

		// capacity(용량): 미리 확보해 놓을 공간
		// 제네릭에 Integer <- 배열 안에 정수만 넣겠다
		ArrayList<Integer> datas = new ArrayList<Integer>();

		// 값을 추가. 배열의 가장 마지막에 추가
		// 칸이 add할 때마다 늘어남
		datas.add(40);
		datas.add(50);
		datas.add(90);
		datas.add(70);
		datas.add(10);
		datas.add(80);
		datas.add(20);
		datas.add(30);
		datas.add(100);

		System.out.println(datas.size());
		System.out.println(datas);

		// 정렬
		// 매개변수 타입이 list인데
		// ArrayList는 list 타입의 부모이기 때문에
		// 업캐스팅으로 ArrayList도 매개변수로 가능
		Collections.sort(datas);

		// ArrayList에서는 toString()을 재정의 해 놓아서
		// 바로 객체를 출력해보면 바로 값이 출력됨

		// 내림차순 정렬
		// 오름차순을 반드시 먼저하고 reverse 해야 함
		Collections.reverse(datas);

		// 랜덤으로 섞는거
		Collections.shuffle(datas);

		// 추가(삽입) - 60은 항상 30뒤에 삽입된다.
		if(datas.contains(30)) {
			datas.add(datas.indexOf(30)+1, 60);
		}
		System.out.println(datas);
		
		// 수정 - 10을 1로 수정한다.
		if(datas.contains(10)) {
			// oldValue를 리턴함
			System.out.println(datas.set(datas.indexOf(10), 1) + "이 1로 수정");
			System.out.println(datas);
		}
		
		// 삭제(값으로 삭제) - 20을 삭제한다.
		if(datas.contains(20)) {
			datas.remove(Integer.valueOf(20));
			System.out.println(datas);
		}
		
		// 삭제(인덱스로 삭제) - 50을 삭제한다.
		if(datas.contains(50)) {
			System.out.println(datas.indexOf(50)); // 4
			System.out.println(datas.remove(datas.indexOf(50)) + "을 삭제"); // 50 <- 삭제된 아이템을 리턴
			System.out.println(datas);
		}

	}
}
