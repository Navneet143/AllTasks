package APITesting;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TestGet {

	@Test
	public void test1() {
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	@Test
	public void test2() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7));
	}
	@Test
	public void test3() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[1]", equalTo(8)).body("data.first_name", hasItems("Michael","Tobias"));
	}
}
