package arrayListTask.user;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.Random;

import arrayListTask.DBConnecter;

public class UserField {
	public ArrayList<User> users = DBConnecter.users;
	public static String userId;
	private final int CERTIFICATED_NUMBER_LENGTH = 6;

//	- ���̵� �ߺ��˻�
	public User checkId(String id) {
		User user = null;

		for (User temp : users) { // users�� ���鼭 user�� �ϳ��� ������
			if (temp.getId().equals(id)) {
				// �ߺ� ����
				user = temp;
				break;
			}
		}
		// �ߺ� ����
		return user;
	}

//	- ȸ������
	public void join(User user) {
		user.setPassword(encrypt(user.getPassword())); // ��ȣȭ�ؼ� DB�� user���� ���� ����
		users.add(user);
	}
	
//	- �α��� <- �α����� boolean���� ��������
//	�̶� ȸ���� ������ �ٸ� ���� ������ ���� �������
	public boolean login(String id, String password) {
		User user = checkId(id);
		if(user != null) {
			if(user.getPassword().equals(encrypt(password))) {
				// �α��� ����
				userId = user.getId(); // �̰ɷ� �α����� �Ǿ��ִ����� Ȯ����
				return true;
			}
		}
		return false;
	}
//	- �α׾ƿ�
	public void logout() {
		userId = null;
	}
	
//	- ��ȣȭ: Base64
	public String encrypt(String password) {
		// String���� ���μ� �ٽ� ���ڿ��� �ٲ���
		return new String(Base64.getEncoder().encode(password.getBytes())); // ��ȣȭ�� byte�� ������
	}
//	- ��ȣȭ
	public String decrypt(String encryptedPassword) {
		return new String(Base64.getDecoder().decode(encryptedPassword.getBytes()));
	}
	
//	- ��й�ȣ ����(����������)
	public void update(User user) { // user�� ������ ����
		User userInDB = checkId(userId);
		user.setPassword(encrypt(user.getPassword()));
		users.set(users.indexOf(userInDB), user);
	}
//	- ȸ������ ��ȸ
	public User select() {
		for (User user : users) {
			if(user.getId().equals(userId)) {
				return user;
			}
		}
		return null;
	}
	
//	- ������ȣ ����(API)
	public String sendMessage(String phoneNumber) {
		Random random = new Random();
		String certificatedNumber = "";
		for (int i = 0; i < CERTIFICATED_NUMBER_LENGTH; i++) {
			certificatedNumber += random.nextInt(10);
		}
		// ������ȣ�� ���� API���� ���� �ؽ�Ʈ�� �ۼ��ϸ� �ȴ�.
		return certificatedNumber;
	}
}