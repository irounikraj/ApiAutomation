package apiTestCaases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resource.Payload;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

@Test
public class LibraryAPITest {
	public void createbookapi() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		// https://rahulshettyacademy.com/Library/Addbook.php
		Response res = given().log().all().header("Content-Type", "application/json").body(Payload.updatebookdata())
				.when().post("Library/Addbook.php").then().assertThat().log().all().statusCode(200).extract()
				.response();
		String response = res.asString();
		// JsonPath js = new JsonPath(response);

	}

}
