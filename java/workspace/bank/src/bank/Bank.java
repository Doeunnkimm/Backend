package bank;

public class Bank {
//  ������
//  ���¹�ȣ
//  �ڵ�����ȣ
//  ��й�ȣ
//  ����
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
	
//	final�� ���� �޼ҵ�� �ڽ� Ŭ�������� ������ X
	
//	���¹�ȣ ��ȸ �޼ҵ� <- ����Ÿ��: Bank
	public final static Bank checkAccount(Bank[][] arrBank, int[] arCount, String account) {
		// arrBank[��������][�� ������ ����]
		
		Bank bank = null;
		// �Է¹��� ���¹�ȣ�� ��ȸ���� �ʴ´ٸ�
		// �ᱹ���� null�� ��ȯ��
		// �ִٸ� �� �� ��ü�� ����
		
		for (int i = 0; i < arrBank.length; i++) {
			int j=0;
			for (j = 0; j < arCount[i]; j++) { // �� ������ ������ŭ �ݺ�
				if(arrBank[i][j].getAccount().equals(account)) { // �Է¹��� ���¹�ȣ�� arrBank �迭�ȿ� �ִٸ�
					bank = arrBank[i][j]; // ��� ã�� �ε����� ��ü ������ bank�� ��´�
					break; // ã������ ���̻� ã�� �ʿ䰡 �����Ƿ� ���� for�� Ż��
				}
			}
			// �ٱ��� for���� Ż���ϱ� ���ؼ�
			if(j != arCount[i]) { // j�� ������ �� ���ٸ� (=�߰��� ã�Ƽ� Ż���ߴٸ�)
				break; // �ٱ��� for�� Ż��
			}
		}
		return bank; // ã�� ����� ��� ������ ���� bank ����
	}
	
//	�ڵ��� ��ȣ �ߺ��˻�
	public final static Bank checkPhoneNumber(Bank[][] arrBank, int[] arCount, String phoneNumber) {
		Bank bank = null;
		
		for (int i = 0; i < arrBank.length; i++) {
			int j=0;
			for (j = 0; j < arCount[i]; j++) { // �� ������ ������ŭ �ݺ�
				if(arrBank[i][j].getPhoneNumber().equals(phoneNumber)) {
					bank = arrBank[i][j];
					break;
				}
			}
			if(j != arCount[i]) { // �ٷ� ������ break�� �����ٸ�
				break;
			}
		}
		return bank; // �� ����� ���¹�ȣ
	}
	
//	�α���
	public final static Bank login(Bank[][] arrBank, int[] arCount, String account, String password) {
		Bank user = checkAccount(arrBank, arCount, account); // ������ ������ �޼ҵ带 ���� ã�� ���� ���¹�ȣ�� �ִ��� �������� ã��
		
		// �Է� ���� ���¹�ȣ�� ���� ��ȸ�� �ȴٸ�
		// user�� ��ü�� �� �ְ�
		// ��ȸ�� ���� �ʾҴٴ� �� user = null
		
		if (user != null) { // ���̵� �ִٸ�
			if(user.password.equals(password)) {
				// ��ȸ�� �� ��ü�� ��й�ȣ��
				// �Է��� ��й�ȣ�� ��ġ�Ѵٸ�
				return user; // �� user ��ü�� ����
			}
		}
		return null; // �α��� ����
	}
	
//	* �Ϲ�
//	�Ա�
	public void deposit(int money) {
		this.money += money;
	}
	
//	���
	public void withdraw(int money) {
		this.money -= money;
	}
	
//	�ܾ���ȸ
	public int showBalance() {
		return money;
	}
}
