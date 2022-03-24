package APITesting;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Test01 {

	@Test
	public void test1() {

		given().when().get("https://reqres.in/api/users?page=2").then().log().body();
		System.out.println("Querry Search");
		given().queryParam("page", "1").when().get("https://reqres.in/api/users?page=2").then().log().body();
		System.out.println(given().when().get("https://reqres.in/api/users?page=2").then().extract().headers());
		System.out.println("Time Taken: "+ given().when().get("https://reqres.in/api/users?page=2").timeIn(TimeUnit.MILLISECONDS));
		Response response= get("https://reqres.in/api/users?page=2");
		System.out.println(response);
		
	}

}