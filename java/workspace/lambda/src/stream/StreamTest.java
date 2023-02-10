package stream;

import java.util.ArrayList;
import java.util.Arrays;

// 내부 API 중 stream
public  class StreamTest {
	public static Integer getTwoTimes(Integer number) {
		return number * 2;
	}
	
	public static void main(String[] args) {
		// 배열을 List로 변경 가능
		Integer[] arData = {10, 20, 30, 40, 50}; // 오토 박싱 <- 배열
		ArrayList<Integer> datas1 = new ArrayList<Integer>(Arrays.asList(arData)); // ArrayList가 됨
		System.out.println(datas1); 
		// 여러 개의 값을 List로 변경 가능
		// 이걸 Arrays라는 클래스의 static class인 asList로!
		// 인자는 가변인자
		// 들어온 인자는 List로 됨
		// list의 부모는 Collection
		// 그래서 list를 넣어서 업캐스팅해서 넣으면 됨
		
		// Arrays.asList()의 인자로 들어간 수들은 합쳐서 List가 됨
		ArrayList<Integer> datas2 = new ArrayList<Integer>(Arrays.asList(10, 20, 30, 40, 50));
		System.out.println(datas2);
		
		System.out.println(datas2.toArray()[0]); // <- ArrayList를 다시 배열로
		
		ArrayList<Integer> datas3 = new ArrayList<Integer>(Arrays.asList(10, 20, 30, 40, 50));
		
		// Stream으로 변환하면 이 필드에 있는 메소드를 사용할 수 있게 됨
		// 구현체로 인터페이스를 접근하기 때문에 바로 사용 가능
		// forEach()
		// 여러 값을 가지고 있는 컬렉션 객체에서 forEach 메소드를 사용할 수 있다.
		// forEach() 메소드에는 Consumer 인터페이스 타입의 값을 전달해야 한다.
		// 매개변수에는 컬렉션 객체 안에 있는 값들이 순서대로 담기고,
		// 화살표 뒤에서는 실행하고 싶은 문장을 작성한다.
		datas3.stream().forEach(data -> System.out.println(data));
		// stream을 생략하고 바로 forEach()도 사용 가능
		datas3.forEach(data -> System.out.println(data));
		datas3.forEach(System.out::println); // :: <- 참조형
		// 소속::메소드
		
		// 기존에 있는 값에 2배인 값을 출력하는 예제
		// map() : 기존 값 변경
		datas3.stream().map(data -> data * 2).forEach(System.out::println);
		datas3.stream().map(StreamTest::getTwoTimes).forEach(System.out::println);
	}
}
