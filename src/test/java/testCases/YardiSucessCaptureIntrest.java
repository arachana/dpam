package testCases;






import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.ValidatableResponse;


public class YardiSucessCaptureIntrest {
	
	String url="https://ps1w2.rt.informaticacloud.com/active-bpel/rt/YardiPortalCaptureInterest";
	ValidatableResponse res;
	@Test(groups="test",priority=37)
	public void getResponseFromyardi() {
		
		
		given()
	
		.header("Authorization","Basic ZHBhbXVzZXJAZHAuYWU6ZmRESGFzZGZENWRCdFBxKA==")
		.contentType("application/json;charset=utf-8")
	
		.formParam("Property_Code","All")
		.formParam("Ext_Ref_Prospect_Id" , "rr914314112se5")
		.formParam("FirstName" , "Rajbahadur")
		.formParam("LastName" , "Rajbahadur")
		.formParam("Mobile" , "+971 (00) 0000000")
		.formParam("Email" , "archanaprajapati880@gmail.com")
		.formParam("Preferred_MoveIn" , "2019-12-28")
		.formParam("Unit_type" , "Apartment")
		.formParam("Residence" ,  "" )
		.formParam("Nationality" ,  "" )
		.formParam("Prospect_type" ,  "" )
		.formParam("Prefered_Langauge" ,  "" ) 
		.formParam("Event_ID" ,  "" )
		.formParam("Campaign_Name" ,  "" )
		.formParam("Website_Date" ,  "" )
		.formParam("COUNTRY_ISO_CODE" ,  "") 
		.formParam("DEFAULT_CHANNEL_GROUPING" ,  "" )
		.formParam("DEVICE_CATEGORY" ,  "" )
		.formParam("PROPERTY_ENQUIRED_NAME" ,  "" )
		.formParam("SOURCE_MEDIUM" ,  "" )
		.formParam("DCM_PLACEMENT" ,  "" )
		.formParam("PLAN_TYPE" ,  "" )
		.formParam("Unit_type" , "Apartment")
		.formParam("NUMBER_OF_EMPLOYEES" , "100")
		.formParam("COMPANY_NAME" , "Adapty")
		.formParam("DCM_SITE" ,  "" )
		.formParam("Availability_Start_Date" ,  "" )
		.formParam("Availability_End_Date" ,  "" )
		.formParam("Alert_Expire_Date" , "2019-12-28")
		.when()
		.post(url)
		.then()
		.log()
		.all();
	
		
		
		
			
	}

}
	


