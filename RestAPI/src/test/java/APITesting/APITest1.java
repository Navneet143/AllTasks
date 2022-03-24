package APITesting;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class APITest1 {

	@Test
	public void checkStatus() {
		int statusCode = given().queryParam("page", "2").when().get("https://reqres.in/api/users?page=2")
				.getStatusCode();
		System.out.println("The response status is " + statusCode);

		given().when().get("https://reqres.in/api/users?page=2").then().assertThat().statusCode(200);
	}
}
