package com.automation.Sample.CucumberFramework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/FacebookFirstPage" }, glue = {
		"classpath:com.automation.Sample.CucumberFramework.stepdefinition",
		"classpath:com.automation.Sample.CucumberFramework.helper" }, plugin = {"html:target/cucumber-html-report"})
public class TestCaseRunner extends AbstractTestNGCucumberTests {

}
