package bank;

public class Bank {
//  예금주
//  계좌번호
//  핸드폰번호
//  비밀번호
//  통장
	  private String name;
	  private String account;
	  private String phoneNumber;
	  private String password;
	  protected int money;
	  
	  public Bank() {;}
	
	  public String getName() {
	     return name;
	  }
	
	  public void setName(String name) {
	     this.name = name;
	  }
	
	  public String getAccount() {
	     return account;
	  }
	
	  public void setAccount(String account) {
	     this.account = account;
	  }
	
	  public String getPhoneNumber() {
	     return phoneNumber;
	  }
	
	  public void setPhoneNumber(String phoneNumber) {
	     this.phoneNumber = phoneNumber;
	  }
	
	  public String getPassword() {
	     return password;
	  }
	
	  public void setPassword(String password) {
	     this.password = password;
	  }
	
	  public int getMoney() {
	     return money;
	  }
	
	  public void setMoney(int money) {
	     this.money = money;
	  }



//	* static
	
//	final을 붙인 메소드는 자식 클래스에서 재정의 X
	
//	계좌번호 조회 메소드 <- 리턴타입: Bank
	public final static Bank checkAccount(Bank[][] arrBank, int[] arCount, String account) {
		// arrBank[은행종류][그 은행의 고객수]
		
		Bank bank = null;
		// 입력받은 계좌번호가 조회되지 않는다면
		// 결국에는 null이 반환됨
		// 있다면 그 고객 객체라 리턴
		
		for (int i = 0; i < arrBank.length; i++) {
			int j=0;
			for (j = 0; j < arCount[i]; j++) { // 각 은행의 고객수만큼 반복
				if(arrBank[i][j].getAccount().equals(account)) { // 입력받은 계좌번호가 arrBank 배열안에 있다면
					bank = arrBank[i][j]; // 방금 찾은 인덱스의 전체 정보를 bank에 담는다
					break; // 찾았으면 더이상 찾을 필요가 없으므로 안쪽 for문 탈출
				}
			}
			// 바깥쪽 for문도 탈출하기 위해서
			if(j != arCount[i]) { // j가 끝까지 못 갔다면 (=중간에 찾아서 탈출했다면)
				break; // 바깥쪽 for문 탈출
			}
		}
		return bank; // 찾은 사람의 모든 정보를 담은 bank 리턴
	}
	
//	핸드폰 번호 중복검사
	public final static Bank checkPhoneNumber(Bank[][] arrBank, int[] arCount, String phoneNumber) {
		Bank bank = null;
		
		for (int i = 0; i < arrBank.length; i++) {
			int j=0;
			for (j = 0; j < arCount[i]; j++) { // 각 은행의 고객수만큼 반복
				if(arrBank[i][j].getPhoneNumber().equals(phoneNumber)) {
					bank = arrBank[i][j];
					break;
				}
			}
			if(j != arCount[i]) { // 바로 위에서 break를 만났다면
				break;
			}
		}
		return bank; // 이 사람의 계좌번호
	}
	
//	로그인
	public final static Bank login(Bank[][] arrBank, int[] arCount, String account, String password) {
		Bank user = checkAccount(arrBank, arCount, account); // 위에서 정의한 메소드를 통해 찾은 고객의 계좌번호가 있는지 없는지를 찾음
		
		// 입력 받은 계좌번호로 계좌 조회가 된다면
		// user에 객체가 들어가 있고
		// 조회가 되지 않았다는 건 user = null
		
		if (user != null) { // 아이디가 있다면
			if(user.password.equals(password)) {
				// 조회된 고객 객체의 비밀번호와
				// 입력한 비밀번호가 일치한다면
				return user; // 그 user 객체를 리턴
			}
		}
		return null; // 로그인 실패
	}
	
//	* 일반
//	입금
	public void deposit(int money) {
		this.money += money;
	}
	
//	출금
	public void withdraw(int money) {
		this.money -= money;
	}
	
//	잔액조회
	public int showBalance() {
		return money;
	}
}
