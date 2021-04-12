package com.alight.emails;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import com.alight.common.utility.BaseDefinition;

import cucumber.api.java.en.Given;

public class Email_GET_Calls extends BaseDefinition {
	
	@Given("^Create GetEmail_Request with access Token and session token in header and parameters\"([^\"]*)\"$")
	public void create_GetEmail_Request_with_access_Token_and_session_token_in_header_and_parameters(String URL) throws Throwable {
		String Accesstoken="Bearer " +AccessToken;

		Headers allHeaders = response.headers();
		 
		// Iterate over all the Headers
		for(Header header : allHeaders)
		{
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}
		SessionToken= response.header("ASG-SessionToken");
		System.out.println("Acc Toekn while sneing--" + Accesstoken);
		System.out.println("Session Toekn while sneing--" +SessionToken);
		
	     RestAssured.baseURI =URL;
		 httpRequest = RestAssured.given()
				 .header("Authorization",Accesstoken)
					.header("ASG-SessionToken",SessionToken)
					.param("srcSystemName","AdvocacyCampMgr")
					.param("status","abc")
					.param("startDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString())
					.param("endDate",  new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString())
			        .param("eventName", "Advocacy Campaign6")
			       .param("emailHd", "");
		 
		// scenario.write("GetEmail request has been created successfully");
	}

	@Given("^Create GetEmail_Request with access Token and session token in header and parameters and no srcSystemName\"([^\"]*)\"$")
	public void create_GetEmail_Request_with_access_Token_and_session_token_in_header_and_parameters_and_no_srcSysName(String URL) throws Throwable {
		String Accesstoken="Bearer " +AccessToken;

		Headers allHeaders = response.headers();
		 
		// Iterate over all the Headers
		for(Header header : allHeaders)
		{
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}
		SessionToken= response.header("ASG-SessionToken");
		System.out.println("Acc Toekn while sneing--" + Accesstoken);
		System.out.println("Session Toekn while sneing--" +SessionToken);
		
	     RestAssured.baseURI =URL;
		 httpRequest = RestAssured.given()
				 .header("Authorization",Accesstoken)
					.header("ASG-SessionToken",SessionToken)
					.param("srcSystemName","")
					.param("status","abc")
					.param("startDate", "")
					.param("endDate", "")
			        .param("eventName", "Advocacy Campaign5")
			       .param("emailHd", "");
	}
}