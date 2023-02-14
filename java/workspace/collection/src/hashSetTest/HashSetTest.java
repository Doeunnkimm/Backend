package hashSetTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
////		ArrayList에 있는 값에서 중복된 값을 제거하는 방법
//		ArrayList<Integer> datas = new ArrayList<Integer>(Arrays.asList(10, 30, 30, 30, 20, 10, 90));
//		HashSet<Integer> dataSet = new HashSet<Integer>(datas);
//		datas = new ArrayList<Integer>(dataSet);
//		System.out.println(datas);
//		
		HashSet<String> bloodTypeSet = new HashSet<String>();
		bloodTypeSet.add("A");
		bloodTypeSet.add("B");
		bloodTypeSet.add("O");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		
//		HashSet에서 contains 속도가 굉장히 빠름
		if(bloodTypeSet.contains("A")) {
			System.out.println("있음");
		}
//		
////		iterator 메소드를 쓰는 순간
////		iterator 타입이 되어 버림
////		iterator만의 순서로 인해서 값을 가져올 수 있다는 것
////		-> 출력된 것도 Iterator 타입인 것!
//		System.out.println(bloodTypeSet);
////		Iterator는 인터페이스여서 구현체를 넣어줘야 함
//		Iterator<String> iter = bloodTypeSet.iterator();
//		
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
	}
}
