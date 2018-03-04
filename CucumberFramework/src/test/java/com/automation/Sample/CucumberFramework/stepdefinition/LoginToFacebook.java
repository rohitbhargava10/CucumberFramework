package com.automation.Sample.CucumberFramework.stepdefinition;

import org.openqa.selenium.By;

import com.automation.Sample.CucumberFramework.configreader.ObjectRepo;
import com.automation.Sample.CucumberFramework.helper.TestBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginToFacebook {

	@Given("^User navigates to Facebook\\.com$")
	public void user_navigates_to_Facebook_com() throws Throwable {
	   TestBase.driver.get(ObjectRepo.reader.getWebsite());
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String arg1, String arg2) throws Throwable {
		TestBase.driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(arg1);
		TestBase.driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(arg2);
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
		TestBase.driver.findElement(By.xpath(".//*[@id='loginbutton']")).click();
	}

	@Then("^User is able to successfull login$")
	public void user_is_able_to_successfull_login() throws Throwable {
		System.out.println("It Worked");
	}

	@Then("^User is not able to successfull login$")
	public void user_is_not_able_to_successfull_login() throws Throwable {
		System.out.println("It didn't Worked");
	}

}
