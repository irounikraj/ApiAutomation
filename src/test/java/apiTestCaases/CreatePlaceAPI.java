package apiTestCaases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resource.Payload;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePlaceAPI {
	@Test
	public void CreateNewPlaceonGoogle() {

		RestAssured.baseURI = "https://reqres.in";
		Response res = given().log().all().header("Content-Type", "application/json").body(Payload.createplacePayload()
				)
				.when().post("/api/users").then().log().all().assertThat().statusCode(201).extract().response();
		String response = res.asString();
		JsonPath js = new JsonPath(response);
		String actualname = js.getString("name");
		Assert.assertEquals(actualname, "morpheus");
		String actualid = js.getString("id");
		System.out.println(actualid);

	}

	// https://reqres.in/api/users?page=2
	@Test
	public void GetAllUsersApi()

	{
		RestAssured.baseURI = "https://reqres.in";
		given().queryParam("page", 2).log().all().header("Content-Type", "application/json").when().get("api/users")
				.then().assertThat().statusCode(200);

	}
}
