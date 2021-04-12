package com.alight.text;

import io.restassured.RestAssured;

import com.alight.common.utility.BaseDefinition;

import cucumber.api.java.en.Given;

public class TextMessage_GET_Calls extends BaseDefinition {

	@Given("^Create GetText_Request with access Token and session token in header and parameters\"([^\"]*)\"$")
	public void create_GetText_Request_with_access_Token_and_session_token_in_header_and_parameters(
			String URL) throws Throwable {
		String Accesstoken = "Bearer " + AccessToken;
		SessionToken = response.header("ASG-SessionToken");
		System.out.println("Acc Toekn while sneing--" + Accesstoken);
		System.out.println("Session Toekn while sneing--" + SessionToken);

		RestAssured.baseURI = URL;
		httpRequest = RestAssured.given().header("Authorization", Accesstoken)
				.header("ASG-SessionToken", SessionToken)
				.param("platformType", "CBA");

		// scenario.write("GetEmail request has been created successfully");
	}

/*	@Given("^Create CommonSession_Token_Request with access Token in header and parameters \"([^\"]*)\"$")
	public void create_CommonSession_Token_Request_with_access_Token_in_header_and_parameters(
			String URL) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		try {
			AccessToken = jsonPathEvaluator.get("access_token");
			String Token = "Bearer " + AccessToken;
			RestAssured.baseURI = URL;
			httpRequest = RestAssured.given().header("Authorization", Token)
					.header("Content-Type", "application/json")
					.param("brokerUserId", "CBA").param("clientId", "MMM01")
					.param("subjectId", "999999999")
					.param("subjectType", "PlatformInternalId");

			// scenario.write("SessionToken request has been created successfully");

		} catch (Exception e) {
			System.out.println("exception in GET method --" + e.toString());
			scenario.write("GET method got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "
					+ e.toString());
		}
	}*/
}
