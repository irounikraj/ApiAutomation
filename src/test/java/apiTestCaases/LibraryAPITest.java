package apiTestCaases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resource.Payload;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test(priority = 3)
public class LibraryAPITest {
	String bookid;

	public void createbookapi() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		// https://rahulshettyacademy.com/Library/Addbook.php
		Response res = given().log().all().header("Content-Type", "application/json").body(Payload.updatebookdata())
				.when().post("Library/Addbook.php").then().assertThat().log().all().statusCode(200).extract()
				.response();
		String response = res.asString();
		JsonPath js = new JsonPath(response);
		bookid = js.getString("ID");
		String actualmsg = js.getString("Msg");
		Assert.assertEquals(actualmsg, "Book Already Exists");

	}

	@Test(priority = 2)
	public void getbookdatabybookidbyapi() {
		// https://rahulshettyacademy.com/Library/GetBook.php?ID=bcd2926
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().header("Content-Type", "application/json").queryParam("id", bookid).when()
				.get("Library/GetBook.php").then().assertThat().statusCode(200);

	}

	@Test(priority = 1)
	public void getbookbyauthornameapi() {

		// https://rahulshettyacademy.com/Library/GetBook.php?AuthorName=John foer
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response res = given().log().all().header("Content-Type", "application/json").queryParam("author", "John foer")
				.when().get("Library/GetBook.php").then().log().all().statusCode(200).extract().response();
		String response = res.asString();
		JsonPath js = new JsonPath(response);
		String actualbookname = js.getString("name");
		Assert.assertEquals(actualbookname, "Learn Java");

	}

}
