package com.qa.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;



public class TestBase implements IAutoConstant
{
		public Properties prop;

	
		
		@BeforeTest
		public void setup()
		{
			try 
			{
				prop=new Properties();
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config/config.properties");
				prop.load(ip);
			} catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}
		
}
