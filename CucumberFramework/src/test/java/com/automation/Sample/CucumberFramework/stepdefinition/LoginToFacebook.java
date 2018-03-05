package com.automation.Sample.CucumberFramework.stepdefinition;

import org.testng.Assert;

import com.automation.Sample.CucumberFramework.configreader.ObjectRepo;
import com.automation.Sample.CucumberFramework.helper.TestBase.TestBase;
import com.automation.Sample.CucumberFramework.pageobject.FacebookHomePage;
import com.automation.Sample.CucumberFramework.pageobject.facebookInitialization;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginToFacebook {

	facebookInitialization initial;
	FacebookHomePage homePage;
	
	@Given("^User navigates to Facebook\\.com$")
	public void user_navigates_to_Facebook_com() throws Throwable {
		TestBase.driver.get(ObjectRepo.reader.getWebsite());
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String arg1, String arg2) throws Throwable {
		//Here we are initializing the driver as this is the first step to be called after PageLoad
		initial= new facebookInitialization(TestBase.driver);
		initial.enterUserAndPass(arg1, arg2);
	}
	
	//Directing to other Page
	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
		homePage= initial.clickOnLoginButton();
	}

	@Then("^User is able to successfull login$")
	public void user_is_able_to_successfull_login() {
		homePage.verifyProfile();
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


	@When("^User enters mobile as \"([^\"]*)\"$")
	public void user_enters_mobile(String arg1) {
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
			Assert.assertTrue(false, this.getClass().getSimpleName() + "is getting failed");
		}
	}
}
