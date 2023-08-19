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

}
