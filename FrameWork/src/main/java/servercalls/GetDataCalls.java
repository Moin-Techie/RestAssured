package servercalls;

import base.BaseTest;
import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;

public class GetDataCalls
{
	public static Response   getData(String resource)
	{
		Response response = given()
		.when().get(resource)
		.then().statusCode(200).extract().response();
		
		String json = response.asString();
		
		return response;
		
		//System.out.println(resource);
	}
}
