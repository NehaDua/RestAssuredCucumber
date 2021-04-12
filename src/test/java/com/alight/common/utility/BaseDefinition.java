package com.alight.common.utility;

import gherkin.formatter.model.Feature;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import cucumber.api.Scenario;

public class BaseDefinition {
	public static Scenario scenario;
	public static Feature feature;
	public static Response AccessTokenResponse = null;
	public static Response ServiceCallResponse = null;
	public static Response response = null;
	public static JsonPath jsonPathEvaluator;
	public static String AccessToken;
	public static String SessionToken;
	public static RequestSpecification httpRequest;
}
