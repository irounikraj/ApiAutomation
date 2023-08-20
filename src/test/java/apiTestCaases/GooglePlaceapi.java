package apiTestCaases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resource.Payload;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GooglePlaceapi {
	
	String placeid ;
	@Test(description="using pojo class, concept of serialization, hamcrest static import")
	public void creategoogleplaceapi() {
		//https://rahulshettyacademy.com/maps/api/place/add/json?key =qaclick123
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		Response res =given().log().all().header("Content-Type", "application/json").body(Payload.CreatePlaceonGooglepayload()).queryParam("key","qaclick123").when().post("maps/api/place/add/json").then().assertThat().statusCode(200).
				body("status",equalTo("OK")).log().all().extract().response();
		String response = res.asString();
		
		JsonPath js = new JsonPath(response);
		placeid = js.getString("place_id");
		System.out.println(placeid);
		
		
		
	
		
		
	}
	

}
