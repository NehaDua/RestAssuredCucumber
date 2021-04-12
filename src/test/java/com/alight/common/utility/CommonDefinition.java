package com.alight.common.utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;

public class CommonDefinition extends BaseDefinition {
	
	@Given("^Create SendRequest with access Token in header and json file in body \"([^\"]*)\"$")
	public void create_SendRequest_with_access_Token_in_header_and_json_file_in_body(
			String filename) throws Throwable {
		try {
			String Accesstoken = "Bearer " + AccessToken;
			File myJson = new File("src/test/resources/" + filename);
			String Token = "Bearer " + AccessToken;
			SessionToken = response.header("ASG-SessionToken");
			RestAssured.baseURI = "https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/api";
			httpRequest = RestAssured.given()
					.header("Authorization", Accesstoken)
					.header("ASG-SessionToken", SessionToken)
					.header("Content-Type", "application/json").body(myJson);
			} catch (Exception e) {
			System.out
					.print("Setting up AccessToken and JSON Body in Request got failed. Please see the error message for details"
							+ e.getStackTrace()[0].getLineNumber());
			scenario.write("Setting up AccessToken and JSON Body in Request got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "
					+ e.toString());
		}

	}
	
	// Scenario:
	// Get_Access_TOKEN********************************************************************
	@Given("^Create Access_Token_Request with header and parameters using BaseURl\\(\"([^\"]*)\"\\)$")
	public void create_Access_Token_Request_with_header_and_parameters_using_BaseURl(
			String URL) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			RestAssured.baseURI = URL;
			httpRequest = RestAssured
					.given()
					.header("Authorization",
							"Basic JkpfJUR1LTdENTpLREZHX1pvNSVp")
					// .header("Authorization","Basic TnBCfl9fQGlPTkZpQWI3OlEmQzFGYjR1LX4")
					.param("grant_type", "client_credentials")
					.param("Scope", "default");
	     } catch (Exception e) {
			scenario.write("Setting up header and paramters got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "
					+ e.toString());
		}
	}

	@Given("^Create Session_Token_Request with access Token in header and parameters \"([^\"]*)\"$")
	public void create_Session_Token_Request_with_access_Token_in_header_and_parameters(
			String URL) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			AccessToken = jsonPathEvaluator.get("access_token");
			String Token = "Bearer " + AccessToken;
			RestAssured.baseURI = URL;
			httpRequest = RestAssured.given().header("Authorization", Token)
					.header("Content-Type", "application/json")
					.queryParam("clientId", "19920")
					.queryParam("brokerUserId", "PTCT")
					.queryParam("subjectId", "304000029")
					.queryParam("subjectType", "PlatformInternalId");
			Headers allHeaders = response.headers();

			// Iterate over all the Headers
			for (Header header : allHeaders) {
				System.out.println("Key: " + header.getName() + " Value: "
						+ header.getValue());
			}
			
		} catch (Exception e) {
			System.out.println("exception in GET method --" + e.toString());
			scenario.write("GET method got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "
					+ e.toString());
		}
	}

	@Given("^Create Invalid_Session_Token_Request with access Token in header and parameters \"([^\"]*)\"$")
	public void create_Invalid_Session_Token_Request_with_access_Token_in_header_and_parameters(
			String URL) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			AccessToken = jsonPathEvaluator.get("access_token");
			String Token = "Bearer " + AccessToken;
			RestAssured.baseURI = URL;
			httpRequest = RestAssured.given().header("Authorization", Token)
					.header("Content-Type", "application/json")
					.queryParam("clientId", "")
					.queryParam("brokerUserId", "PTCT")
					.queryParam("subjectId", "304000029")
					.queryParam("subjectType", "PlatformInternalId");
			Headers allHeaders = response.headers();

			// Iterate over all the Headers
			for (Header header : allHeaders) {
				System.out.println("Key: " + header.getName() + " Value: "
						+ header.getValue());
			}
			
		} catch (Exception e) {
			System.out.println("exception in GET method --" + e.toString());
			scenario.write("GET method got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "
					+ e.toString());
		}
	}

	@Given("^Create Invalid_Session_Token_Request with no subjectId and subjectType \"([^\"]*)\"$")
	public void create_Invalid_Session_Token_Request_with_no_subjectId_and_subjectType(
			String URL) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			AccessToken = jsonPathEvaluator.get("access_token");
			String Token = "Bearer " + AccessToken;
			RestAssured.baseURI = URL;
			httpRequest = RestAssured.given().header("Authorization", Token)
					.header("Content-Type", "application/json")
					.queryParam("clientId", "19920")
					.queryParam("brokerUserId", "PTCT")
					.queryParam("subjectId", "").queryParam("subjectType", "");
			Headers allHeaders = response.headers();

			// Iterate over all the Headers
			for (Header header : allHeaders) {
				System.out.println("Key: " + header.getName() + " Value: "
						+ header.getValue());
			}
			
		} catch (Exception e) {
			System.out.println("exception in GET method --" + e.toString());
			scenario.write("GET method got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "
					+ e.toString());
		}
	}

	@Then("^\"([^\"]*)\" should be \"([^\"]*)\"$")
	public void should_be(String arg1, String arg2) throws Throwable {
		try {
			String Value = jsonPathEvaluator.get(arg1);

			Assert.assertEquals(Value, arg2,
					"Incorrect value received in the Response");
			scenario.write(arg1 + " received from Response-" + Value);
		} catch (Exception e) {
			scenario.write("Fetching and comparing value got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "
					+ e.toString());
		}

	}


	@Then("^\"([^\"]*)\" should be equal to Integer \"([^\"]*)\"$")
	public void should_be_equal_to_integer(String arg1, int arg2)
			throws Throwable {
		try {
			int Value = jsonPathEvaluator.get(arg1);
			scenario.write(arg1 + " received from Response-" + Value);
			Assert.assertEquals(Value, arg2,
					"Incorrect value received in the Response");
		} catch (Exception e) {
			scenario.write("Fetching and comparing value got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "
					+ e.toString());
		}

	}

	@Then("^\"([^\"]*)\" should be greater than or equal to Integer \"([^\"]*)\"$")
	public void should_be_greater_than_or_equal_to_integer(String arg1, int arg2)
			throws Throwable {
		try {
			int value = jsonPathEvaluator.get(arg1);
			scenario.write(arg1 + " received from Response-" + value);
			Assert.assertTrue(value >= arg2,
					"Incorrect value received in the Response");
		} catch (Exception e) {
			scenario.write("Fetching and comparing value got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "
					+ e.toString());
		}

	}

	@When("^GET method is sent with \"([^\"]*)\"$")
	public void get_method_is_sent_with(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			response = httpRequest.request(Method.GET, "/" + arg1);
			jsonPathEvaluator = response.jsonPath();
			scenario.write(response.prettyPrint());
			// scenario.write(response.prettyPrint());
		} catch (Exception e) {

		}
	}

	@When("^POST method is sent with \"([^\"]*)\"$")
	public void post_method_is_sent_with(String arg1) throws Throwable {
		try {
			response = httpRequest.request(Method.POST, "/" + arg1);
			jsonPathEvaluator = response.jsonPath();
			TimeUnit.SECONDS.sleep(5);
			System.out.println(response.prettyPrint());
			scenario.write(response.prettyPrint());

		} catch (Exception e) {
			System.out.println("exception in POST method --" + e.toString());
			scenario.write("POST method got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "
					+ e.toString());

		}
	}
	
	@Given("^Create SendRequest with json file in body \"([^\"]*)\"$")
	public void create_SendRequest_with_json_file_in_body(
			String filename) throws Throwable {
		try {
			
			String Accesstoken = "Bearer " + AccessToken;
			File myJson = new File("src/test/resources/" + filename);
			String Token = "Bearer " + AccessToken;
			SessionToken = response.header("ASG-SessionToken");
			RestAssured.baseURI = "https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/api";
			httpRequest = RestAssured.given()
					.header("Authorization", Accesstoken)
					.header("ASG-SessionToken", SessionToken)
					.header("Content-Type", "application/json").body(myJson);
				} catch (Exception e) {
			System.out.print(" JSON Body in Request got failed. Please see the error message for details"
							+ e.getStackTrace()[0].getLineNumber());
			scenario.write("JSON Body in Request got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  " + e.toString());
		}
	}
	
	@Given("^Create SendRequest with invalid json file with KitID null in body \"([^\"]*)\"$")
	public void create_SendRequest_with_invalid_json_file_with_KitID_null_in_body(
			String filename) throws Throwable {
		try {
			String Accesstoken = "Bearer " + AccessToken;
			File myJson = new File("src/test/resources/" + filename);
			String Token = "Bearer " + AccessToken;
			SessionToken = response.header("ASG-SessionToken");
			RestAssured.baseURI = "https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/api";
			httpRequest = RestAssured.given()
					.header("Authorization", Accesstoken)
					.header("ASG-SessionToken", SessionToken)
					.header("Content-Type", "application/json").body(myJson);
			
		} catch (Exception e) {
			System.out.print("Setting up JSON Body in Request got failed. Please see the error message for details"
							+ e.getStackTrace()[0].getLineNumber());
			scenario.write("Setting up  JSON Body in Request got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "	+ e.toString());
		}
	}
	
	@Given("^Create SendRequest with invalid json data in body \"([^\"]*)\"$")
	public void create_SendRequest_with_invalid_json_data_in_body(
			String filename) throws Throwable {
		try {
			String Accesstoken = "Bearer " + AccessToken;
			File myJson = new File("src/test/resources/" + filename);
			String Token = "Bearer " + AccessToken;
			SessionToken = response.header("ASG-SessionToken");
			RestAssured.baseURI = "https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/api";
			httpRequest = RestAssured.given()
					.header("Authorization", Accesstoken)
					.header("ASG-SessionToken", SessionToken)
					.header("Content-Type", "application/json").body(myJson);
			
		} catch (Exception e) {
			System.out.print("Setting up JSON Body in Request got failed. Please see the error message for details"
							+ e.getStackTrace()[0].getLineNumber());
			scenario.write("Setting up  JSON Body in Request got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "	+ e.toString());
		}
	 }
	
	@Given("^Create SendRequest with batchMode json data in body \"([^\"]*)\"$")
	public void create_SendRequest_batchMode_json_data_in_body(
			String filename) throws Throwable {
		try {
			String Accesstoken = "Bearer " + AccessToken;
			File myJson = new File("src/test/resources/" + filename);
			String Token = "Bearer " + AccessToken;
			SessionToken = response.header("ASG-SessionToken");
			RestAssured.baseURI = "https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/api";
			httpRequest = RestAssured.given()
					.header("Authorization", Accesstoken)
					.header("ASG-SessionToken", SessionToken)
					.header("Content-Type", "application/json").body(myJson);
			
		} catch (Exception e) {
			System.out.print("Setting up JSON Body in Request got failed. Please see the error message for details"
							+ e.getStackTrace()[0].getLineNumber());
			scenario.write("Setting up  JSON Body in Request got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "	+ e.toString());
		}
	 }
	
	@Given("^Create SendRequest with batchMode without JobId in body \"([^\"]*)\"$")
	public void create_SendRequest_batchMode_without_JobId_in_body(
			String filename) throws Throwable {
		try {
			String Accesstoken = "Bearer " + AccessToken;
			File myJson = new File("src/test/resources/" + filename);
			String Token = "Bearer " + AccessToken;
			SessionToken = response.header("ASG-SessionToken");
			RestAssured.baseURI = "https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/api";
			httpRequest = RestAssured.given()
					.header("Authorization", Accesstoken)
					.header("ASG-SessionToken", SessionToken)
					.header("Content-Type", "application/json").body(myJson);
			
		} catch (Exception e) {
			System.out.print("Setting up JSON Body in Request got failed. Please see the error message for details"
							+ e.getStackTrace()[0].getLineNumber());
			scenario.write("Setting up  JSON Body in Request got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "	+ e.toString());
		}
	 }
	
	@Given("^Create SendRequest with batchMode with wrong BatchId in body \"([^\"]*)\"$")
	public void create_SendRequest_batchMode_with_wrong_BatchId_in_body(
			String filename) throws Throwable {
		try {
			String Accesstoken = "Bearer " + AccessToken;
			File myJson = new File("src/test/resources/" + filename);
			String Token = "Bearer " + AccessToken;
			SessionToken = response.header("ASG-SessionToken");
			RestAssured.baseURI = "https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/api";
			httpRequest = RestAssured.given()
					.header("Authorization", Accesstoken)
					.header("ASG-SessionToken", SessionToken)
					.header("Content-Type", "application/json").body(myJson);
			
		} catch (Exception e) {
			System.out.print("Setting up JSON Body in Request got failed. Please see the error message for details"
							+ e.getStackTrace()[0].getLineNumber());
			scenario.write("Setting up  JSON Body in Request got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "	+ e.toString());
		}
	 }
	
	
	@Then("^it should provide status code \"([^\"]*)\"$")
	public void it_should_provide_status_code(int statusCode) throws Throwable {
		try {

			int Value = response.getStatusCode();
			scenario.write("Status Code received from Response-" + Value);
			System.out.println(response.getStatusCode() + " response and actual status  "+  statusCode);
			Assert.assertEquals(Value, statusCode,
					"Incorrect Status Code Returned");
			
		} catch (Exception e) {
			scenario.write("Fetching and comparing status code got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "	+ e.toString());
		}
	}

	@Then("^it should provide statusCode \"([^\"]*)\"$")
	public void it_should_provide_statusCode(int statusCode) throws Throwable {
		try {

			int Value = response.getStatusCode();
			scenario.write("Status Code received from Response-" + Value);
			System.out.println(response.getStatusCode() + "  response and actual status  "+  statusCode);
			Assert.assertEquals(Value, statusCode,
					"Incorrect Status Code Returned");
			
		} catch (Exception e) {
			scenario.write("Fetching and comparing status code got failed. Please see the error message for details");
			throw new Exception("Please check & fix the exception  "	+ e.toString());
		}
	}

}