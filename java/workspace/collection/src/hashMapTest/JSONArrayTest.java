package hashMapTest;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONArrayTest {
	public static void main(String[] args) {
//      Product product1 = new Product("족발", 39000, 10);
//      Product product2 = new Product("보쌈", 45000, 10);

//      JSONObject productJSON1 = new JSONObject(product1);
//      JSONObject productJSON2 = new JSONObject(product2);

		ArrayList<Product> productList = new ArrayList<Product>(
				Arrays.asList(new Product("족발", 39000, 10), new Product("보쌈", 45000, 10)));

		ArrayList<JSONObject> productJSONs = new ArrayList<JSONObject>();

//      productList에 들어갈 때에도 위에서 먼저 넣어둔 객체들을
//      모두 JSONObject로 넣어주어야 함
//		그래서 map을 통해 JSONObject로 변환해서 넣어줌
		productList.stream().map(product -> new JSONObject(product)).forEach(productJSONs::add);

//		JSONObject들을 담고 있는 ArrayList인 productJSONs를 JSONArray로
		JSONArray products = new JSONArray(productJSONs);
//      products.put(productJSON1);
//      products.put(productJSON2);

		System.out.println(products.toString());

//		ObjectArray는 순서가 없다고 판단되어서
//		반복문을 인덱스를 통해서 돌려야 함
		for (int i = 0; i < products.length(); i++) {
			try {
//            System.out.println(products.get(i));
//            System.out.println(((JSONObject)products.get(i)).get("productName"));
				System.out.println(products.getJSONObject(i).get("productName"));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

	}
}
