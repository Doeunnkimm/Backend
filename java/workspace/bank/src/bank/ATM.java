package bank;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		String[] bankNames = { "신한은행", "국민은행", "카카오뱅크" };
		Bank[][] arrBank = new Bank[3][100];
		int[] arCount = new int[3];
		final int ACCOUNT_LENGTH = 6;

		String message = "1. 신한은행\n2. 국민은행\n3. 카카오뱅크\n4. 나가기";
		String menu = "1. 계좌개설\n2. 입금하기\n3. 출금하기\n4. 잔액조회\n5. 계좌번호 찾기\n6. 은행 선택 메뉴로 돌아가기";
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		String account = "", password = null, phoneNumber = null;
		Bank user = null;
		int money = 0;

		int i = 0, choice = 0;

		while (true) { // 은행 선택을 위한 while문
			System.out.println(message);
			i = sc.nextInt();

			if (i == 4) {
				break;
			} // 나가기. 탈출

			i--; // 1번을 선택하면 사실 배열에서는 0번째 행에 해당하므로 i를 -1 해준다

			while (true) { // 메뉴 선택을 위한 while문
				Bank[] banks = { new Shinhan(), new Kookmin(), new KaKao() };

				System.out.println(menu);
				choice = sc.nextInt();

				if (choice == 6) {
					break;
				} // while문 탈출해서 다시 메뉴 선택 while문으로 들어감

				switch (choice) {
				case 1: // 계좌개설
					if (arCount[i] == 100) {
						System.out.println("더 이상 계좌를 개설할 수 없는 은행입니다.");
						break;
					}

					user = banks[i]; // 위에서 선택한 은행이름의 인덱스로 객체 생성

					// (1) 계좌번호 생성-----------------------------
					while (true) { // 개설가능한 계좌번호가 뜰 때까지 반복해야 해서

						account = "";

						// 방법1. 계좌번호가 0부터 시작 가능
						// for (int j = 0; j < ACCOUNT_LENGTH; j++) {
						// account += random.nextInt(10);
						// }

						// 방법2. 계좌번호가 1부터 시작 가능
						// 100000 ~ 999999 <-> 0 ~ 899999 + 100000
						account += random.nextInt(900000) + 100000;
						account = i + 1 + account; // 선택한 은행의 인덱스 번호가 앞에 붙도록

						if (Bank.checkAccount(arrBank, arCount, account) == null) {
							// 방금 만든 계좌번호로 조회를 했을 때
							// 조회가 되지 않아야 그 계좌번호로 개설이 가능
							// 그래서 조회가 된다면 while문 탈출해서 바로 아래로 가서 계좌개설

							// 조회가 된다면 다시 while문을 탄다.
							break;
						}
					}
					user.setAccount(account);

					// (2) 예금주 이름 설정----------------------------
					System.out.print("예금주: ");
					user.setName(sc.next());

					// (3) 비밀번호 설정---------------------------
					while (true) { // 사용자가 비밀번호를 제대로 입력할 때까지 반복
						System.out.print("비밀번호[4자리]: ");
						password = sc.next();

						if (password.length() == 4) { // 4자리로 제대로 입력했다면
							break; // while문 탈출하면서 비밀번호 set
						}
					}
					user.setPassword(password);

					// (4) 핸드폰 번호 설정-----------------------------------
					while (true) { // 사용자가 11자리로 제대로 입력할 때까지 반복
						System.out.print("핸드폰 번호['-' 제외]");
						phoneNumber = sc.next();
						phoneNumber = phoneNumber.replaceAll("-", ""); // 만약 - 기호를 입력했다면 없애줌
						if (phoneNumber.length() == 11
								&& Bank.checkPhoneNumber(arrBank, arCount, phoneNumber) == null) {
							// 입력받은 전화번호의 길이가 11자리이고
							// 중복된 전화번호가 아니라면
							break;
						}
					}
					user.setPhoneNumber(phoneNumber);

					// 최종!
					// arrBank[무슨은행][몇번째고객]
					arrBank[i][arCount[i]] = user;
					arCount[i]++; // i번재 은행의 고객의 수를 +1

					System.out.println(bankNames[i] + ", 환영한다.");
					System.out.println("너의 계좌번호: " + account);

					break;

				case 2: // 내 통장에 돈 입금하기

					// (1) 로그인---------------------------------------------
					System.out.print("계좌번호: ");
					account = sc.next();

					System.out.print("비밀번호: ");
					password = sc.next();

					// 저장소와 고객수, 입력받은 계좌번호와 비밀번호를 전달하면
					// 로그인 검사를 통해 로그인 성공 시 회원 객체를 전달해준다.
					user = Bank.login(arrBank, arCount, account, password);
					// --------------------------------------------------------

					if (user != null) { // 로그인 성공했을 때
						
						if (user.getAccount().charAt(0) - 48 == i + 1) {
							// 계좌번호의 맨 앞자리는 각 은행의 번호가 붙어있음(1, 2, 3)
							// 그래서 맨 앞자리를 가져옴(이때는 문자열로 가져와짐)
							// 그래서 -48해서 숫자로 바꿔서 선택한 은행의 번호와 비교
							// '0' - 48 == 0 (아스키코드)
							System.out.print("입금액: ");
							money = sc.nextInt();
							if (money <= 0) { // 0 또는 0보다 작은 돈을 입금하려고 할 때
								System.out.println("다시 입력해주세요.");
								break;
							}
							user.deposit(money);
						} else {
							System.out.println("개설한 은행에서만 입금이 가능합니다.");
						}

//                  boolean flag = false;
////                고객의 은행이 무슨 은행인지, 지금 선택한 은행이 무슨 은행인지
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
//                     System.out.print("입금액: ");
//                     money = sc.nextInt();
//                     if(money <= 0) {
//                        System.out.println("다시 입력해주세요.");
//                        break;
//                     }
//                     
//                     user.deposit(money);
//                  }else {
//                     System.out.println("개설한 은행에서만 입금이 가능합니다.");
//                  }
					}

					break;
				case 3: // 내 통장에서 돈 출금하기
					System.out.print("계좌번호: ");
					account = sc.next();

					System.out.print("비밀번호: ");
					password = sc.next();

					user = Bank.login(arrBank, arCount, account, password);

					if (user != null) {
						System.out.print("출금액: ");
						money = sc.nextInt();

						// 국민은행의 경우에
						// 출금하려고 했을 때 그 금액의 1.5배가 빠져야 함
						// 따라서 선택한 은행이 국민은행이라면
						// 지금 돈의 1.5배 보다 더 많은 금액의 돈을 출금하려고 하면
						// 잔액부족
						if (user.getMoney() < (user instanceof Kookmin ? money * 1.5 : money)) {
							System.out.println("잔액 부족");
							break;
						}
						user.withdraw(money);
					}
					break;
				case 4: // 잔액조회
					System.out.print("계좌번호: ");
					account = sc.next();

					System.out.print("비밀번호: ");
					password = sc.next();

					user = Bank.login(arrBank, arCount, account, password);

					if (user != null) {
						System.out.println("현재 잔액: " + user.showBalance() + "원");
					}
					break;
				case 5: // 계좌번호 찾기
					System.out.print("핸드폰 번호: ");
					phoneNumber = sc.next();

					// 입력받은 핸드폰 번호로 조회
					// 조회가 된다면 그 조회된 고객 객체가 user에 담긴다
					user = Bank.checkPhoneNumber(arrBank, arCount, phoneNumber);

					// 조회된 회원이 있다면 비밀번호를 물어본다
					if (user != null) {
						System.out.print("비밀번호: ");
						password = sc.next();

						// 입력받은 비밀번호와 고객 객체에서의 비밀번호가 같다면
						if (user.getPassword().equals(password)) {

							while (true) { // 중복없는 계좌번호를 개설될 때까지 반복
								// 계좌번호가 0부터 시작 가능
								// for (int j = 0; j < ACCOUNT_LENGTH; j++) {
								// account += random.nextInt(10);
								// }

								// 계좌번호가 1부터 시작 가능
								// 100000 ~ 999999 -> 0 ~ 899999
								account += random.nextInt(900000) + 100000;

								if (Bank.checkAccount(arrBank, arCount, account) == null) {
									break;
								}
							}
							// 중복없는 계좌번호가 생성되었다면
							user.setAccount(account); // 고객 객체에서의 계좌번호를 방금 생성한 번호로 갱신
							System.out.println("다시는 잃어버리지 마세요.");
							System.out.println("너의 계좌번호: " + account);
						}
					}
					// 조회되는 회원이 없다면 바로 그냥 탈출
					break;
				}
			}
		}
	}
}
