package resource;

public class Payload {

	public static String createplacePayload() {
		return "{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}";

	}

	public static String createemployeepayload() {
		return "	{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
	}

	public static String updateemployeepayload() {
		return "	{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
	}

	public static String updatebookdata() {
		return "{\r\n" + "\"name\":\"Learn Java\",\r\n" + "\"isbn\":\"bcd\",\r\n" + "\"aisle\":\"2926\",\r\n"
				+ "\"author\":\"John foer\"\r\n" + "}";
	}

	public static String CreatePlaceonGooglepayload() {
		return "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n" + "    \"lng\": 33.427362\r\n"
				+ "  },\r\n" + "  \"accuracy\": 50,\r\n" + "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n" + "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n" + "  ],\r\n" + "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n" + "}\r\n" + "";
	}

}
