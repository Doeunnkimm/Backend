package classTest;

import java.util.Scanner;

class SuperCar {
	String brand;
	String color;
	int price;
	boolean engine;
	String password;
	int errorCount;
	
//	�ʱ�ȭ ���
//	��ü�� ������ �Ǹ� �Ź� ���� ����� ����ȴ�.
	{
		this.password = "0000";
	}
	
	// ó������ ���� ������ �𸣴� ��Ȳ�� ����
	// �⺻ �����ڱ��� �����ε� ���ش�.
	public SuperCar() {	}
	
	public SuperCar(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

//	�õ��ѱ�
//	���� ���¸� Ȯ���ϰ�
//	�õ��� �����ִٸ�, "�õ� ����" ���
//	�õ��� �����ִٸ�, "�õ��� �̹� �����ֽ��ϴ�." ���
//	boolean engineStart() {
//		if(!engine) {
//			engine = true;
//			return true; // �� ����Ǿ���.
//		}
//		return false; // �� �� ����Ǿ���.
//	}
	
//	������ �� �� �ִ� ���¿�����
//	�Ʒ� �޼ҵ带 �����ϸ� ��
	void engineStart() {
		engine = true;
	}
	
//	�õ�����
//	���� ���¸� Ȯ���ϰ�
//	�õ��� �����ִٸ�, "�õ� ����" ���
//	�õ��� �����ִٸ�, "�õ��� �̹� �����ֽ��ϴ�." ���
	boolean engineStop() {
		if(engine) {
			engine = false;
			return true;
		}
		return false;
	}
	
//	void engineStop() {
//		engine = false;
//	}
	
//	�õ��� �ѱ� ���ؼ� ��й�ȣ 4�ڸ��� �Է¹޾ƾ� �Ѵ�.
//	3�� ���� �߸� �̺����� �� "���� �⵿" ���
//	�� ���ڿ� �񱳴� equals()�� ���Ѵ�.
//	"ABC".equals("���ڿ�")
	boolean checkPassword(String password) {
		// ���� ��й�ȣ���� ���� ��й�ȣ�� ��ġ�ϴ���
		// ������ true�� ����. Ʋ���� false�� �����ϴ�
		// ������ ��!
		return this.password.equals(password);
	}
}

public class ClassTask1 {
	public static void main(String[] args) {
		SuperCar mom = new SuperCar("���", "������", 68_000);
//		mom.brand = "���";
		Scanner sc = new Scanner(System.in);
		String menu = "1. �õ��ѱ�\n2. �õ�����";
		int choice = 0;
		String password = null;
		
		while(true) {
			System.out.println(menu);
			choice = sc.nextInt();
			boolean check = false;
			
			switch(choice) {
			case 1: // �õ��ѱ�
				// ���� �õ��� ���� Ȯ���ϱ�
				if(!mom.engine) { // �õ��� �� �� �ִ� ����
					System.out.print("��й�ȣ: ");
					password = sc.next();
					if(mom.checkPassword(password)) {
						mom.engineStart();
						System.out.println("�õ� ����");
						mom.errorCount = 0; // ��й�ȣ ���߸� �ʱ�ȭ
						break;
					}
					mom.errorCount++;
					System.out.println(mom.errorCount + "ȸ ��й�ȣ ����");
					if(mom.errorCount == 3) {
						System.out.println("���� �⵿");
						// ���⿡���� break�� switch���� Ż���ϴ� 
						// ���� flag�� ����ְ� ������ while�� Ż��
						check = true;
						break;
					}
					break;
				}
				System.out.println("�̹� �õ��� �����ֽ��ϴ�.");
				break;
				
			case 2: // �õ�����
				if(mom.engineStop()) {
					System.out.println("�õ� ����");
					check= true;
					break;
				}
				System.out.println("�̹� �õ��� �����ֽ��ϴ�.");
				break;
			}
			
			if(check) {
				break;
			}
	}
		
//		while(true) {
//			System.out.println(menu);
//			choice = sc.nextInt();
//			switch(choice) {
//			case 1:
//				if(mom.engineStart()) {
//					System.out.println("�õ� ����");
//					break;
//				}
//				System.out.println("�õ��� �̹� �����ֽ��ϴ�.");
//				break;
//			case 2:
//				if(mom.engineStop()) {
//					System.out.println("�õ� ����");
//					break;
//				}
//				System.out.println("�õ��� �̹� �����ֽ��ϴ�.");
//				break;
//			}
//		}
		
	}
}
