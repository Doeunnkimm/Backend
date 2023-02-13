package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 내부 API 중 stream
public  class StreamTest {
	public static Integer getTwoTimes(Integer number) {
		return number * 2;
	}
	
	public boolean checkEven(int number) {
		return number % 2 == 0;
	}
	
	public int change(int number) {
		return 10 - number;
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
		
		// map() : 기존 값 변경
		// 기존에 있는 값에 2배인 값을 출력하는 예제
		datas3.stream().map(data -> data * 2).forEach(System.out::println);
		// 바로 클래스::메소드 쓰고 싶으면 메소드에 static
		datas3.stream().map(StreamTest::getTwoTimes).forEach(System.out::println);
		
		ArrayList<User> users = new ArrayList<User>(Arrays.asList(new User(20, "한동석"), new User(22, "홍길동")));
		users.stream().map(User::getAge).forEach(System.out::println);
		
		// range(inclusive, exclusive)
		// rangeClosed(inclusive, inclusive)
		// IntStream은 우리가 범위를 정해줄 수 있음
		// 부모가 BaseStream이어서 바로 steam관련 메소드를 사용할 수 있음
		ArrayList<Integer> datas = new ArrayList<Integer>();
//		 IntStream.range(1, 10).forEach(System.out::println);
		 IntStream.range(1, 10).forEach(datas::add); // 받자마자 바로 쓸 것들은 참조형을 먼저 생각해보자...
		 System.out.println(datas);
		 
		 // chars() : 문자열을 IntStream으로 변경(아스키코드값으로 들어감)
		 String data = "ABC";
		 data.chars().forEach(System.out::println);
		 // forEach말고는 다(map, ..) IntStream으로 취급됨(리턴 타입이 정해져있어서)
//		 data.chars().map(c -> (char)c).forEach(System.out::println);
		 // 그래서 형변환은 꼭 forEach에서 하자
		 data.chars().forEach(c -> System.out.println((char)c));
		 
		 // filter() : 조건식이 true일 경우만 추출
//		 IntStream.range(0, 10).filter(d -> d%2==0).forEach(System.out::println);
		 // 클래스의 메소드로 접근할 경우
		 StreamTest streamTest = new StreamTest();
		 IntStream.range(0, 10).filter(streamTest::checkEven).forEach(System.out::println);
		 
		 // sorted() : 정렬
		 ArrayList<Integer> datas4 = new ArrayList<Integer>();
//		 IntStream.rangeClosed(0, 9).map(streamTest::change).forEach(datas4::add);
//		 System.out.println(datas);
//		 datas4.stream().sorted().forEach(System.out::println);
		 IntStream.rangeClosed(1, 10).forEach(datas4::add);
		 datas4.stream().sorted(Collections.reverseOrder()).forEach(System.out::println); // 내림차순 정렬
		 
		 // collect() : 결과를 다양한 타입으로 리턴해줌
		 ArrayList<Integer> datas6 = new ArrayList<Integer>(Arrays.asList(10, 30, 15));
		 System.out.println(datas6.stream().map(String::valueOf).collect(Collectors.joining(":"))); // 10:30:15
		 System.out.println(String.valueOf(20)); // 들어온 인자를 문자열로 바꿔줌
		 
		 ArrayList<Integer> datas5 = new ArrayList<Integer>(Arrays.asList(30, 20, 90, 40, 80));
		 // 컬렉션에서는 stream에 있는 sorted를 사용하지 않고 sort를 사용하여 직접 접근한 주소를 정렬시킨다.
		 // -> sort는 원본을 건드림, sorted는 원본을 건드리지 않음
		 datas5.sort(null); // 오름차순
		 datas5.sort(Collections.reverseOrder()); // 내림차순
//		 sorted로 하려면 아래와 같이 해야 함
//		 List<Integer> results = datas5.stream().sorted().collect(Collectors.toList());
//		 System.out.println(results);
		 System.out.println(datas5); 
		 // joining() : 배열에 들어있는 char을 원하는 구분점으로 문자열로 바꿔줌
		 System.out.println(datas5.stream().map(String::valueOf).collect(Collectors.joining(",")));
		 
		 
	}
}
