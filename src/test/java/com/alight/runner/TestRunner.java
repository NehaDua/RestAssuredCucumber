package com.alight.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/resources/emailConfiguration","src/test/resources/textMessageConfiguration","src/test/resources/createAndDeliverTestConfig"},
		glue={"com/alight/common/utility","com/alight/emails"},
		plugin = {"pretty","html:target/cucumber","json:target/cucumber.json","junit:target/cucumber.xml"},
		tags = "@test"
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
