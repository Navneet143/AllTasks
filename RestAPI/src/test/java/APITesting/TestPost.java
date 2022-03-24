package APITesting;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestPost {

	@Test
	public void test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fname", "Ameer");
		map.put("lanme", "Khan");

		JSONObject obj = new JSONObject(map);
		//System.out.println(obj);

		given().body(obj.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201);
		System.out.println("The headers in the response "+get("https://reqres.in/api/users").then().extract().headers());
		get("https://reqres.in/api/users").then().log().body();
	} 
}
