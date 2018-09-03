package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;
import servercalls.GetDataCalls;

public class GetSeverData extends BaseTest
{
	@Test
	public void getServerData()
	{
		String rcrs = prop.getProperty("RESOURCE");
		
		Response resp = GetDataCalls.getData(rcrs);
		System.out.println(resp.getStatusCode());
		System.out.println(resp.asString());
	}
}
