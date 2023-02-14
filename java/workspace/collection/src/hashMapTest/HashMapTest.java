package hashMapTest;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

public class HashMapTest {
	public static void main(String[] args) {
//		아이디, 비밀번호, 이름, 나이 <- String, number 다 value로 사용하기 위해 업캐스팅 되기 위한 Object 타입 사용
		HashMap<String, Object> userMap = new HashMap<String, Object>();
		JSONObject userJSON = null;
		String json = null;
		
		userMap.put("id", "doeunnkimm");
		userMap.put("password", "1234");
		userMap.put("name", "김도은");
		userMap.put("age", "20");
		
		System.out.println(userMap.get("id")); // 키값으로 value 가져오기
		
		userJSON = new JSONObject(userMap); // JSON Object로 변환
		System.out.println(userJSON);
		
		// 더 추가하고 싶을 때
		// 그런데 key와 value의 형식이 잘못되었을 수도 있기 때문에
		// 무조건 try-catch 해야 함
		try {
			userJSON.put("gender", "F");
			System.out.println(userJSON);
			
			json = userJSON.toString(); // 문자열 값으로 바꿈
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		// 키값이 없을 수도 있는 경우를 위해
		// try-catch 필요함
		try {
			System.out.println(userJSON.get("id"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		try {
			userJSON = new JSONObject(json); // 문자열을 JSON으로 변환
			System.out.println(userJSON.get("id"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
