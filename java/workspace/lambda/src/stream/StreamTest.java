package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// ���� API �� stream
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
		// �迭�� List�� ���� ����
		Integer[] arData = {10, 20, 30, 40, 50}; // ���� �ڽ� <- �迭
		ArrayList<Integer> datas1 = new ArrayList<Integer>(Arrays.asList(arData)); // ArrayList�� ��
		System.out.println(datas1); 
		// ���� ���� ���� List�� ���� ����
		// �̰� Arrays��� Ŭ������ static class�� asList��!
		// ���ڴ� ��������
		// ���� ���ڴ� List�� ��
		// list�� �θ�� Collection
		// �׷��� list�� �־ ��ĳ�����ؼ� ������ ��
		
		// Arrays.asList()�� ���ڷ� �� ������ ���ļ� List�� ��
		ArrayList<Integer> datas2 = new ArrayList<Integer>(Arrays.asList(10, 20, 30, 40, 50));
		System.out.println(datas2);
		
		System.out.println(datas2.toArray()[0]); // <- ArrayList�� �ٽ� �迭��
		
		ArrayList<Integer> datas3 = new ArrayList<Integer>(Arrays.asList(10, 20, 30, 40, 50));
		
		// Stream���� ��ȯ�ϸ� �� �ʵ忡 �ִ� �޼ҵ带 ����� �� �ְ� ��
		// ����ü�� �������̽��� �����ϱ� ������ �ٷ� ��� ����
		
		// forEach()
		// ���� ���� ������ �ִ� �÷��� ��ü���� forEach �޼ҵ带 ����� �� �ִ�.
		// forEach() �޼ҵ忡�� Consumer �������̽� Ÿ���� ���� �����ؾ� �Ѵ�.
		// �Ű��������� �÷��� ��ü �ȿ� �ִ� ������ ������� ����,
		// ȭ��ǥ �ڿ����� �����ϰ� ���� ������ �ۼ��Ѵ�.
		datas3.stream().forEach(data -> System.out.println(data));
		// stream�� �����ϰ� �ٷ� forEach()�� ��� ����
		datas3.forEach(data -> System.out.println(data));
		datas3.forEach(System.out::println); // :: <- ������
		// �Ҽ�::�޼ҵ�
		
		// map() : ���� �� ����
		// ������ �ִ� ���� 2���� ���� ����ϴ� ����
		datas3.stream().map(data -> data * 2).forEach(System.out::println);
		// �ٷ� Ŭ����::�޼ҵ� ���� ������ �޼ҵ忡 static
		datas3.stream().map(StreamTest::getTwoTimes).forEach(System.out::println);
		
		ArrayList<User> users = new ArrayList<User>(Arrays.asList(new User(20, "�ѵ���"), new User(22, "ȫ�浿")));
		users.stream().map(User::getAge).forEach(System.out::println);
		
		// range(inclusive, exclusive)
		// rangeClosed(inclusive, inclusive)
		// IntStream�� �츮�� ������ ������ �� ����
		// �θ� BaseStream�̾ �ٷ� steam���� �޼ҵ带 ����� �� ����
		ArrayList<Integer> datas = new ArrayList<Integer>();
//		 IntStream.range(1, 10).forEach(System.out::println);
		 IntStream.range(1, 10).forEach(datas::add); // ���ڸ��� �ٷ� �� �͵��� �������� ���� �����غ���...
		 System.out.println(datas);
		 
		 // chars() : ���ڿ��� IntStream���� ����(�ƽ�Ű�ڵ尪���� ��)
		 String data = "ABC";
		 data.chars().forEach(System.out::println);
		 // forEach����� ��(map, ..) IntStream���� ��޵�(���� Ÿ���� �������־)
//		 data.chars().map(c -> (char)c).forEach(System.out::println);
		 // �׷��� ����ȯ�� �� forEach���� ����
		 data.chars().forEach(c -> System.out.println((char)c));
		 
		 // filter() : ���ǽ��� true�� ��츸 ����
//		 IntStream.range(0, 10).filter(d -> d%2==0).forEach(System.out::println);
		 // Ŭ������ �޼ҵ�� ������ ���
		 StreamTest streamTest = new StreamTest();
		 IntStream.range(0, 10).filter(streamTest::checkEven).forEach(System.out::println);
		 
		 // sorted() : ����
		 ArrayList<Integer> datas4 = new ArrayList<Integer>();
//		 IntStream.rangeClosed(0, 9).map(streamTest::change).forEach(datas4::add);
//		 System.out.println(datas);
//		 datas4.stream().sorted().forEach(System.out::println);
		 IntStream.rangeClosed(1, 10).forEach(datas4::add);
		 datas4.stream().sorted(Collections.reverseOrder()).forEach(System.out::println); // �������� ����
		 
		 // collect() : ����� �پ��� Ÿ������ ��������
		 ArrayList<Integer> datas6 = new ArrayList<Integer>(Arrays.asList(10, 30, 15));
		 System.out.println(datas6.stream().map(String::valueOf).collect(Collectors.joining(":"))); // 10:30:15
		 System.out.println(String.valueOf(20)); // ���� ���ڸ� ���ڿ��� �ٲ���
		 
		 ArrayList<Integer> datas5 = new ArrayList<Integer>(Arrays.asList(30, 20, 90, 40, 80));
		 // �÷��ǿ����� stream�� �ִ� sorted�� ������� �ʰ� sort�� ����Ͽ� ���� ������ �ּҸ� ���Ľ�Ų��.
		 // -> sort�� ������ �ǵ帲, sorted�� ������ �ǵ帮�� ����
		 datas5.sort(null); // ��������
		 datas5.sort(Collections.reverseOrder()); // ��������
//		 sorted�� �Ϸ��� �Ʒ��� ���� �ؾ� ��
//		 List<Integer> results = datas5.stream().sorted().collect(Collectors.toList());
//		 System.out.println(results);
		 System.out.println(datas5); 
		 // joining() : �迭�� ����ִ� char�� ���ϴ� ���������� ���ڿ��� �ٲ���
		 System.out.println(datas5.stream().map(String::valueOf).collect(Collectors.joining(",")));
		 
		 
	}
}
