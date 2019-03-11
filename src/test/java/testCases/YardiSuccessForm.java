package testCases;

import org.json.simple.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import actions.GenericMethods;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class YardiSuccessForm {
	
	GenericMethods genericMethods;
	
	
@Test(groups="test",priority=34)
public void getResponseFromyardi() {
	
		//Initializing Rest API's URL
		RestAssured.baseURI = "https://ps1w2.rt.informaticacloud.com/active-bpel/rt";
		 JsonObject requestParams = new JsonObject();
	
		 requestParams.put("Property_Code","All"	);
				requestParams.put("Ext_Ref_Prospect_Id","rr214314131" );
				requestParams.put("FirstName" , "Rajbahadur");
				requestParams.put("LastName", "Rajput" );
				requestParams.put("Mobile" , "+971 (00) 0000000");
				requestParams.put("FirstContactType" , "call");
				requestParams.put("Source" , "Website");
				requestParams.put("Agent" , "N/A");
				requestParams.put("Email" , "raj@gmail.com");
				requestParams.put("Preferred_Bedrooms" , "0") ;
				requestParams.put("Preferred_MoveIn" , "2018-12-31");
				requestParams.put("Desired_Rent" , "0" );
				requestParams.put("Notes" , "Form_Comments");
				requestParams.put("Unit_type" , "Apartment" );
				requestParams.put("NUMBER_OF_EMPLOYEES" , "100") ;
				requestParams.put("COMPANY_NAME" , "Adapty") ;
				requestParams.put("DCM_SITE" , "" );
				requestParams.put("Availability_Start_Date" , "") ;
				requestParams.put("Availability_End_Date" , "" );
				requestParams.put("Alert_Expire_Date" , "");
		
				RequestSpecification httpRequest = RestAssured.given();	
				httpRequest.header("Content-Type", "application/json");
				httpRequest.body(requestParams.toString());
				 Response response = httpRequest.post("/YardiPortalCaptureInterest");
				 
				 int statusCode = response.getStatusCode();
				 Assert.assertEquals(statusCode, "200");
				 String successCode = response.jsonPath().get("SuccessCode");
				 Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
				}						
	}