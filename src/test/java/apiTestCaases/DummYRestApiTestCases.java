package apiTestCaases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resource.Payload;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

@Test(priority = 2)
public class DummYRestApiTestCases {
	String id;

	public void dummyrestapi() {
		RestAssured.baseURI = "https://dummy.restapiexample.com/";
		// https://dummy.restapiexample.com/
		Response res = given().log().all().header("Content-Type", "application/json")
				.body(Payload.createemployeepayload()).when().post("api/v1/create").then().log().all().assertThat()
				.statusCode(200).extract().response();
		String response = res.asString();
		JsonPath js = new JsonPath(response);
		String actualid = js.getString("id");
		System.out.println(actualid);
	}

	public void getdummyapi() {
		RestAssured.baseURI = "https://dummy.restapiexample.com/";
		given().log().all().header("Content-Type", "application/json").queryParam("id", "id from response").when()
				.get("api/v1/employee/[[[id]]]").then().assertThat().statusCode(200);
	}

	@Test(enabled = false)
	public void updateRetapi() {
		RestAssured.baseURI = "https://dummy.restapiexample.com/";
		// https://dummy.restapiexample.com/api/v1/update/21
		given().log().all().header("Content-Type", "application /json").body(Payload.updateemployeepayload()).when()
				.put("/api/v1/update/21").then().assertThat().statusCode(200);

	}

}
