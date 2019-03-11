package testCases;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

public class RestApi {
	@Test(groups="test",priority=38)
	public void getResponseFromyardi() throws ClientProtocolException, IOException {
		  HttpClient client = new DefaultHttpClient();
		  HttpPost post = new HttpPost("https://ps1w2.rt.informaticacloud.com/active-bpel/rt/YardiPortalCaptureInterest");
		  post.setHeader(HttpHeaders.AUTHORIZATION, "Basic");
		  post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf-8");
		  List nameValuePairs = new ArrayList(1);
		  nameValuePairs.add(new BasicNameValuePair("Property_Code", "All")); //you can as many name value pair as you want in the list.
		  post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		  HttpResponse response = client.execute(post);
		  BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		  String line = "";
		  while ((line = rd.readLine()) != null) {
		   System.out.println(line);
		  }
		 }
}
