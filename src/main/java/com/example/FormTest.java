package com.example;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.databene.benerator.anno.Source;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormTest {
	
	@BeforeTest
	public void setUp(){
		System.out.println("from setUp");
	}
	
	@Test
	@Source("./data/add.csv")
	public void doGet(String a, String b, String expected) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet("http://192.168.119.151:8080/demo/FormServlet?a=" + a + "&b= + " + b);
		CloseableHttpResponse response = client.execute(request);
		String actual = EntityUtils.toString(response.getEntity());
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	
	@AfterTest
	public void tearDown(){
		System.out.println("from tearDown");
	}

}
