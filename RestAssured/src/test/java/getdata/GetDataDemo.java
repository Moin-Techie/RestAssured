package getdata;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetDataDemo 
{
	@Test
	public void getReqFromJSON()
	{
		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		
		int code=resp.getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200,"Code does not match");
		
		String data=resp.asString();
		
		System.out.println(data);
		
	}
	
	
	@Test
	public void getReqFromXML()
	{
		Response resp = RestAssured.get("http://parabank.parasoft.com/parabank/services/bank/customers/12212/");
		
		int code=resp.getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200,"Code does not match");
		
		String data=resp.asString();
		
		System.out.println(data);
		//Assert.assertEquals(code, 200,"Code does not match");
	}
}
