package hashMapTest;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

public class HashMapTest {
	public static void main(String[] args) {
//		���̵�, ��й�ȣ, �̸�, ���� <- String, number �� value�� ����ϱ� ���� ��ĳ���� �Ǳ� ���� Object Ÿ�� ���
		HashMap<String, Object> userMap = new HashMap<String, Object>();
		JSONObject userJSON = null;
		String json = null;
		
		userMap.put("id", "doeunnkimm");
		userMap.put("password", "1234");
		userMap.put("name", "�赵��");
		userMap.put("age", "20");
		
		System.out.println(userMap.get("id")); // Ű������ value ��������
		
		userJSON = new JSONObject(userMap); // JSON Object�� ��ȯ
		System.out.println(userJSON);
		
		// �� �߰��ϰ� ���� ��
		// �׷��� key�� value�� ������ �߸��Ǿ��� ���� �ֱ� ������
		// ������ try-catch �ؾ� ��
		try {
			userJSON.put("gender", "F");
			System.out.println(userJSON);
			
			json = userJSON.toString(); // ���ڿ� ������ �ٲ�
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		// Ű���� ���� ���� �ִ� ��츦 ����
		// try-catch �ʿ���
		try {
			System.out.println(userJSON.get("id"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		try {
			userJSON = new JSONObject(json); // ���ڿ��� JSON���� ��ȯ
			System.out.println(userJSON.get("id"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
