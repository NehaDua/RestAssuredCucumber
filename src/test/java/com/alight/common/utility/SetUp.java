package com.alight.common.utility;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class SetUp extends BaseDefinition {

	@Before
	public void keepScenario(Scenario scenario) {
		BaseDefinition.scenario = scenario;
	}
}

	
	


