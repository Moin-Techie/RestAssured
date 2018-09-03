package com.qa.testcase;

import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import org.testng.annotations.Test;

import com.qa.base.RestClient;
import com.qa.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetAndValidateData extends TestBase
{
	@Test
	public void getData()
	{
		String url = prop.getProperty("URL")+(prop.getProperty("URI"));
		RestClient.getData(url);
		
		
	}
	
	@Test
	public void testDemo()
	{
		
		RestAssured.baseURI = "http://";
		
		Response response = given().queryParam("", "")
		.when().get("")
		.then().statusCode(200).extract().response();
		
		String str = response.asString();
		
		JsonPath js = new JsonPath(str);
		js.get("total");
		
		int arrayLength = js.get("data.size()");
		
		for(int i = 0; i < arrayLength; i++  )
		{
			
		}
		
		
	}
}
