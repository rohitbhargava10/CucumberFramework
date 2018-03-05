package com.automation.Sample.CucumberFramework.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.Sample.CucumberFramework.configreader.ObjectRepo;
import com.automation.Sample.CucumberFramework.helper.Logger.LoggerHelper;
import com.automation.Sample.CucumberFramework.helper.Wait.WaitHelper;
import com.automation.Sample.CucumberFramework.helper.assertionHelper.VerificationHelper;

public class FacebookHomePage {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(facebookInitialization.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement Home;
			
	public FacebookHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, Home,ObjectRepo.reader.getExplicitWait());
	}
	
	public void verifyProfile(){
		log.info("Verifying element present"+Home);
		if(VerificationHelper.verifyElementPresent(Home)) {
		System.out.println("Able to see the Home icon in profile");
		//Assert.assertTrue(false, "Failing to check few things");
		}
		else {
			System.out.println("Not abe to see home icon");
		}
	}
}
