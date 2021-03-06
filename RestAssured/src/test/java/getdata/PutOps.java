package getdata;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutOps 
{
	@Test
	public void postData()
	{
		RequestSpecification req = RestAssured.given();
		req.header("Content-Type","application/json");
		
		JSONObject json=new JSONObject();
		json.put("id", "100");
		json.put("title", "Zumba");
		json.put("author", "Moin_Foodie");
		
		req.body(json.toJSONString());
		
		Response resp = req.put("http://localhost:3000/posts/100");
		
		System.out.println(resp.getStatusCode());
	}
	
	@Test
	public void iterateData()
	{
		JSONObject json = new JSONObject();
		
		json.put("EmpId", "123");
		json.put("EmpName", "Moin");
		json.put("EmpSalary", "65000");
		json.put("EmpAge", "28");
		
		Set entry = json.entrySet();
		
		Iterator itr = entry.iterator();
		
		while (itr.hasNext()) {
			Map.Entry e1= (Map.Entry) itr.next();
			
			System.out.println(e1.getKey()+" ==> "+e1.getValue());
			
		}
		
		
		
	}
}
