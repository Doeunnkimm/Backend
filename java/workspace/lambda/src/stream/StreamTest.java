package stream;

import java.util.ArrayList;
import java.util.Arrays;

// ���� API �� stream
public  class StreamTest {
	public static Integer getTwoTimes(Integer number) {
		return number * 2;
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
		
		// ������ �ִ� ���� 2���� ���� ����ϴ� ����
		// map() : ���� �� ����
		datas3.stream().map(data -> data * 2).forEach(System.out::println);
		datas3.stream().map(StreamTest::getTwoTimes).forEach(System.out::println);
	}
}
