package getdata;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostOps 
{
	@Test
	public void postData()
	{
		RequestSpecification req = RestAssured.given();
		
		req.header("Content-Type","application/json");//prepare header
		
		JSONObject json = new JSONObject();//prepare Object
		
		json.put("id", "101");
		json.put("title", "Zumba");
		json.put("author", "Moin_Fitness");
		
		req.body(json.toJSONString());//prepareBody
		
		Response resp = req.post("http://localhost:3000/posts");
		
		
		System.out.println(resp.getStatusCode());
		
		Assert.assertEquals(resp.getStatusCode(), 201,"No Match");
	}
}