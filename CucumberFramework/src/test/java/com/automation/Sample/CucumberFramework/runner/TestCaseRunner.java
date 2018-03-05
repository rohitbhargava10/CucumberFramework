package com.automation.Sample.CucumberFramework.runner;

import org.testng.annotations.AfterClass;
import com.automation.Sample.CucumberFramework.configreader.ObjectRepo;
import com.automation.Sample.CucumberFramework.utility.ResourceHelper;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/FacebookFirstPage" }, 
					glue = {	"classpath:com.automation.Sample.CucumberFramework.stepdefinition",
							"classpath:com.automation.Sample.CucumberFramework.helper" }, 
					tags= {"@Regression,@Functional"},
					plugin = {"pretty",
								"html:target/cucumber-html-report",
								"json:target/cucumber-json-report/cucumber.json",
								"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, monochrome=true)
public class TestCaseRunner extends AbstractTestNGCucumberTests {
@AfterClass
public static void writeExtentReport() {
	Reporter.loadXMLConfig(ResourceHelper.getBaseResourcePath()+ObjectRepo.reader.getExtentPath());
	Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
    Reporter.setSystemInfo("Machine", 	"Windows 10 " + "64 Bit");
    Reporter.setSystemInfo("Selenium", "3.9.1");
    Reporter.setSystemInfo("Java Version", "1.8.0_161");
}

}
