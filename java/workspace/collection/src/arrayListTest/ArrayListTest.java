package arrayListTest;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {

	public static void main(String[] args) {
		// <?>: ���׸�(�̸��� ����)
		// ��üȭ �� Ÿ���� �����ϴ� ���
		// ������ �� Ÿ���� ������ �� ���� ������ �ӽ÷� Ÿ���� ������ �� ����Ѵ�.

		// Object Ŭ������ �ƴ϶� ���׸��� ����ϴ� ����
		// 1. ���� �ٿ�ĳ������ �� �ʿ� ����
		// 2. ������ Ÿ�Կ� ������ �� �� ����

		// capacity(�뷮): �̸� Ȯ���� ���� ����
		// ���׸��� Integer <- �迭 �ȿ� ������ �ְڴ�
		ArrayList<Integer> datas = new ArrayList<Integer>();

		// ���� �߰�. �迭�� ���� �������� �߰�
		// ĭ�� add�� ������ �þ
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

		// ����
		// �Ű����� Ÿ���� list�ε�
		// ArrayList�� list Ÿ���� �θ��̱� ������
		// ��ĳ�������� ArrayList�� �Ű������� ����
		Collections.sort(datas);

		// ArrayList������ toString()�� ������ �� ���Ƽ�
		// �ٷ� ��ü�� ����غ��� �ٷ� ���� ��µ�

		// �������� ����
		// ���������� �ݵ�� �����ϰ� reverse �ؾ� ��
		Collections.reverse(datas);

		// �������� ���°�
		Collections.shuffle(datas);

		// �߰�(����) - 60�� �׻� 30�ڿ� ���Եȴ�.
		if(datas.contains(30)) {
			datas.add(datas.indexOf(30)+1, 60);
		}
		System.out.println(datas);
		
		// ���� - 10�� 1�� �����Ѵ�.
		if(datas.contains(10)) {
			// oldValue�� ������
			System.out.println(datas.set(datas.indexOf(10), 1) + "�� 1�� ����");
			System.out.println(datas);
		}
		
		// ����(������ ����) - 20�� �����Ѵ�.
		if(datas.contains(20)) {
			datas.remove(Integer.valueOf(20));
			System.out.println(datas);
		}
		
		// ����(�ε����� ����) - 50�� �����Ѵ�.
		if(datas.contains(50)) {
			System.out.println(datas.indexOf(50)); // 4
			System.out.println(datas.remove(datas.indexOf(50)) + "�� ����"); // 50 <- ������ �������� ����
			System.out.println(datas);
		}

	}
}
