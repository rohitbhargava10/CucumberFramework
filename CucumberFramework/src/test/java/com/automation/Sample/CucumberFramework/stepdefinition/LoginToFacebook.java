package com.automation.Sample.CucumberFramework.stepdefinition;

import org.openqa.selenium.By;

import com.automation.Sample.CucumberFramework.configreader.ObjectRepo;
import com.automation.Sample.CucumberFramework.helper.TestBase.TestBase;
import com.automation.Sample.CucumberFramework.pageobject.facebookInitialization;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginToFacebook {

	facebookInitialization initial;
	
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
	public void user_is_able_to_successfull_login() {
		System.out.println("It Worked");
	}

	@Then("^User is not able to successfull login$")
	public void user_is_not_able_to_successfull_login() {
		System.out.println("It didn't Worked");
	}

	@When("^User enters firstname as \"([^\"]*)\"$")
	public void user_enters_firstname_as(String fname) {
		initial= new facebookInitialization(TestBase.driver);
		initial.enterfname(fname);
	}

	@When("^User enters lastname as \"([^\"]*)\"$")
	public void user_enters_lastname_as(String lname){
		initial.enterlname(lname);
	}


	@When("^User enters mobile as (\\d+)$")
	public void user_enters_mobile(int arg1) {
		initial.enternumber(arg1);
	}

	@When("^User clicks on create account$")
	public void user_clicks_on_create_account() {
		initial.clickOnCreateAcc();
	}

	@Then("^User should get error message$")
	public void user_should_get_error_message() {
		boolean result= initial.verifyErrorMessage();
		if(result) {
			System.out.println("Actual Message is equal to Expected messsage");
		}
		else {
			System.out.println("Validation Failed");
		}
	}
}
