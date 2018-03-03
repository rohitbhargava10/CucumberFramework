package com.automation.Sample.CucumberFramework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features= {"classpath:featurefile/FacebookLogin.feature"})
public class FacebookLoginRunner extends AbstractTestNGCucumberTests {

}
