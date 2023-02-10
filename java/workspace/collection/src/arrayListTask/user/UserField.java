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

//	- 아이디 중복검사
	public User checkId(String id) {
		User user = null;

		for (User temp : users) { // users를 돌면서 user에 하나씩 가져옴
			if (temp.getId().equals(id)) {
				// 중복 있음
				user = temp;
				break;
			}
		}
		// 중복 없음
		return user;
	}

//	- 회원가입
	public void join(User user) {
		user.setPassword(encrypt(user.getPassword())); // 암호화해서 DB에 user정보 넣을 거임
		users.add(user);
	}
	
//	- 로그인 <- 로그인은 boolean으로 리턴하자
//	이때 회원의 정보는 다른 곳에 저장해 놓고 사용하자
	public boolean login(String id, String password) {
		User user = checkId(id);
		if(user != null) {
			if(user.getPassword().equals(encrypt(password))) {
				// 로그인 성공
				userId = user.getId(); // 이걸로 로그인이 되어있는지를 확인함
				return true;
			}
		}
		return false;
	}
//	- 로그아웃
	public void logout() {
		userId = null;
	}
	
//	- 암호화: Base64
	public String encrypt(String password) {
		// String으로 감싸서 다시 문자열로 바꿔줌
		return new String(Base64.getEncoder().encode(password.getBytes())); // 암호화된 byte로 리턴함
	}
//	- 복호화
	public String decrypt(String encryptedPassword) {
		return new String(Base64.getDecoder().decode(encryptedPassword.getBytes()));
	}
	
//	- 비밀번호 변경(마이페이지)
	public void update(User user) { // user는 수정된 정보
		User userInDB = checkId(userId);
		user.setPassword(encrypt(user.getPassword()));
		users.set(users.indexOf(userInDB), user);
	}
//	- 회원정보 조회
	public User select() {
		for (User user : users) {
			if(user.getId().equals(userId)) {
				return user;
			}
		}
		return null;
	}
	
//	- 인증번호 전송(API)
	public String sendMessage(String phoneNumber) {
		Random random = new Random();
		String certificatedNumber = "";
		for (int i = 0; i < CERTIFICATED_NUMBER_LENGTH; i++) {
			certificatedNumber += random.nextInt(10);
		}
		// 인증번호는 문자 API에서 보낼 텍스트를 작성하면 된다.
		return certificatedNumber;
	}
}
