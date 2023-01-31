package bank;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		String[] bankNames = { "��������", "��������", "īī����ũ" };
		Bank[][] arrBank = new Bank[3][100];
		int[] arCount = new int[3];
		final int ACCOUNT_LENGTH = 6;

		String message = "1. ��������\n2. ��������\n3. īī����ũ\n4. ������";
		String menu = "1. ���°���\n2. �Ա��ϱ�\n3. ����ϱ�\n4. �ܾ���ȸ\n5. ���¹�ȣ ã��\n6. ���� ���� �޴��� ���ư���";
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		String account = "", password = null, phoneNumber = null;
		Bank user = null;
		int money = 0;

		int i = 0, choice = 0;

		while (true) { // ���� ������ ���� while��
			System.out.println(message);
			i = sc.nextInt();

			if (i == 4) {
				break;
			} // ������. Ż��

			i--; // 1���� �����ϸ� ��� �迭������ 0��° �࿡ �ش��ϹǷ� i�� -1 ���ش�

			while (true) { // �޴� ������ ���� while��
				Bank[] banks = { new Shinhan(), new Kookmin(), new KaKao() };

				System.out.println(menu);
				choice = sc.nextInt();

				if (choice == 6) {
					break;
				} // while�� Ż���ؼ� �ٽ� �޴� ���� while������ ��

				switch (choice) {
				case 1: // ���°���
					if (arCount[i] == 100) {
						System.out.println("�� �̻� ���¸� ������ �� ���� �����Դϴ�.");
						break;
					}

					user = banks[i]; // ������ ������ �����̸��� �ε����� ��ü ����

					// (1) ���¹�ȣ ����-----------------------------
					while (true) { // ���������� ���¹�ȣ�� �� ������ �ݺ��ؾ� �ؼ�

						account = "";

						// ���1. ���¹�ȣ�� 0���� ���� ����
						// for (int j = 0; j < ACCOUNT_LENGTH; j++) {
						// account += random.nextInt(10);
						// }

						// ���2. ���¹�ȣ�� 1���� ���� ����
						// 100000 ~ 999999 <-> 0 ~ 899999 + 100000
						account += random.nextInt(900000) + 100000;
						account = i + 1 + account; // ������ ������ �ε��� ��ȣ�� �տ� �ٵ���

						if (Bank.checkAccount(arrBank, arCount, account) == null) {
							// ��� ���� ���¹�ȣ�� ��ȸ�� ���� ��
							// ��ȸ�� ���� �ʾƾ� �� ���¹�ȣ�� ������ ����
							// �׷��� ��ȸ�� �ȴٸ� while�� Ż���ؼ� �ٷ� �Ʒ��� ���� ���°���

							// ��ȸ�� �ȴٸ� �ٽ� while���� ź��.
							break;
						}
					}
					user.setAccount(account);

					// (2) ������ �̸� ����----------------------------
					System.out.print("������: ");
					user.setName(sc.next());

					// (3) ��й�ȣ ����---------------------------
					while (true) { // ����ڰ� ��й�ȣ�� ����� �Է��� ������ �ݺ�
						System.out.print("��й�ȣ[4�ڸ�]: ");
						password = sc.next();

						if (password.length() == 4) { // 4�ڸ��� ����� �Է��ߴٸ�
							break; // while�� Ż���ϸ鼭 ��й�ȣ set
						}
					}
					user.setPassword(password);

					// (4) �ڵ��� ��ȣ ����-----------------------------------
					while (true) { // ����ڰ� 11�ڸ��� ����� �Է��� ������ �ݺ�
						System.out.print("�ڵ��� ��ȣ['-' ����]");
						phoneNumber = sc.next();
						phoneNumber = phoneNumber.replaceAll("-", ""); // ���� - ��ȣ�� �Է��ߴٸ� ������
						if (phoneNumber.length() == 11
								&& Bank.checkPhoneNumber(arrBank, arCount, phoneNumber) == null) {
							// �Է¹��� ��ȭ��ȣ�� ���̰� 11�ڸ��̰�
							// �ߺ��� ��ȭ��ȣ�� �ƴ϶��
							break;
						}
					}
					user.setPhoneNumber(phoneNumber);

					// ����!
					// arrBank[��������][���°��]
					arrBank[i][arCount[i]] = user;
					arCount[i]++; // i���� ������ ���� ���� +1

					System.out.println(bankNames[i] + ", ȯ���Ѵ�.");
					System.out.println("���� ���¹�ȣ: " + account);

					break;

				case 2: // �� ���忡 �� �Ա��ϱ�

					// (1) �α���---------------------------------------------
					System.out.print("���¹�ȣ: ");
					account = sc.next();

					System.out.print("��й�ȣ: ");
					password = sc.next();

					// ����ҿ� ����, �Է¹��� ���¹�ȣ�� ��й�ȣ�� �����ϸ�
					// �α��� �˻縦 ���� �α��� ���� �� ȸ�� ��ü�� �������ش�.
					user = Bank.login(arrBank, arCount, account, password);
					// --------------------------------------------------------

					if (user != null) { // �α��� �������� ��
						
						if (user.getAccount().charAt(0) - 48 == i + 1) {
							// ���¹�ȣ�� �� ���ڸ��� �� ������ ��ȣ�� �پ�����(1, 2, 3)
							// �׷��� �� ���ڸ��� ������(�̶��� ���ڿ��� ��������)
							// �׷��� -48�ؼ� ���ڷ� �ٲ㼭 ������ ������ ��ȣ�� ��
							// '0' - 48 == 0 (�ƽ�Ű�ڵ�)
							System.out.print("�Աݾ�: ");
							money = sc.nextInt();
							if (money <= 0) { // 0 �Ǵ� 0���� ���� ���� �Ա��Ϸ��� �� ��
								System.out.println("�ٽ� �Է����ּ���.");
								break;
							}
							user.deposit(money);
						} else {
							System.out.println("������ ���࿡���� �Ա��� �����մϴ�.");
						}

//                  boolean flag = false;
////                ���� ������ ���� ��������, ���� ������ ������ ���� ��������
//                  if(user instanceof Shinhan) {
//                     if(i == 0) {
//                        flag = true;
//                     }
//                  }else if(user instanceof Kookmin) {
//                     if(i == 1) {
//                        flag = true;
//                     }
//                  }else {
//                     if(i == 2) {
//                        flag = true;
//                     }
//                  }
//                  if(flag) {
//                     System.out.print("�Աݾ�: ");
//                     money = sc.nextInt();
//                     if(money <= 0) {
//                        System.out.println("�ٽ� �Է����ּ���.");
//                        break;
//                     }
//                     
//                     user.deposit(money);
//                  }else {
//                     System.out.println("������ ���࿡���� �Ա��� �����մϴ�.");
//                  }
					}

					break;
				case 3: // �� ���忡�� �� ����ϱ�
					System.out.print("���¹�ȣ: ");
					account = sc.next();

					System.out.print("��й�ȣ: ");
					password = sc.next();

					user = Bank.login(arrBank, arCount, account, password);

					if (user != null) {
						System.out.print("��ݾ�: ");
						money = sc.nextInt();

						// ���������� ��쿡
						// ����Ϸ��� ���� �� �� �ݾ��� 1.5�谡 ������ ��
						// ���� ������ ������ ���������̶��
						// ���� ���� 1.5�� ���� �� ���� �ݾ��� ���� ����Ϸ��� �ϸ�
						// �ܾ׺���
						if (user.getMoney() < (user instanceof Kookmin ? money * 1.5 : money)) {
							System.out.println("�ܾ� ����");
							break;
						}
						user.withdraw(money);
					}
					break;
				case 4: // �ܾ���ȸ
					System.out.print("���¹�ȣ: ");
					account = sc.next();

					System.out.print("��й�ȣ: ");
					password = sc.next();

					user = Bank.login(arrBank, arCount, account, password);

					if (user != null) {
						System.out.println("���� �ܾ�: " + user.showBalance() + "��");
					}
					break;
				case 5: // ���¹�ȣ ã��
					System.out.print("�ڵ��� ��ȣ: ");
					phoneNumber = sc.next();

					// �Է¹��� �ڵ��� ��ȣ�� ��ȸ
					// ��ȸ�� �ȴٸ� �� ��ȸ�� �� ��ü�� user�� ����
					user = Bank.checkPhoneNumber(arrBank, arCount, phoneNumber);

					// ��ȸ�� ȸ���� �ִٸ� ��й�ȣ�� �����
					if (user != null) {
						System.out.print("��й�ȣ: ");
						password = sc.next();

						// �Է¹��� ��й�ȣ�� �� ��ü������ ��й�ȣ�� ���ٸ�
						if (user.getPassword().equals(password)) {

							while (true) { // �ߺ����� ���¹�ȣ�� ������ ������ �ݺ�
								// ���¹�ȣ�� 0���� ���� ����
								// for (int j = 0; j < ACCOUNT_LENGTH; j++) {
								// account += random.nextInt(10);
								// }

								// ���¹�ȣ�� 1���� ���� ����
								// 100000 ~ 999999 -> 0 ~ 899999
								account += random.nextInt(900000) + 100000;

								if (Bank.checkAccount(arrBank, arCount, account) == null) {
									break;
								}
							}
							// �ߺ����� ���¹�ȣ�� �����Ǿ��ٸ�
							user.setAccount(account); // �� ��ü������ ���¹�ȣ�� ��� ������ ��ȣ�� ����
							System.out.println("�ٽô� �Ҿ������ ������.");
							System.out.println("���� ���¹�ȣ: " + account);
						}
					}
					// ��ȸ�Ǵ� ȸ���� ���ٸ� �ٷ� �׳� Ż��
					break;
				}
			}
		}
	}
}
