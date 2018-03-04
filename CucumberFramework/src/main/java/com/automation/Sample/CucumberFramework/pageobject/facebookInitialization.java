package com.automation.Sample.CucumberFramework.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.Sample.CucumberFramework.configreader.ObjectRepo;
import com.automation.Sample.CucumberFramework.helper.Logger.LoggerHelper;
import com.automation.Sample.CucumberFramework.helper.Wait.WaitHelper;
import com.automation.Sample.CucumberFramework.helper.assertionHelper.VerificationHelper;



public class facebookInitialization {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(facebookInitialization.class);
	WaitHelper waitHelper;

	public facebookInitialization(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, createAccount,ObjectRepo.reader.getExplicitWait());
	}

	@FindBy(xpath="//input[@name=\"firstname\"]")
	WebElement fname;

	@FindBy(xpath="//input[@name=\"lastname\"]")
	WebElement lname;

	@FindBy(xpath="//input[@name=\"reg_email__\"]")
	WebElement number;

	@FindBy(xpath="//input[@name=\"reg_passwd__\"]")
	WebElement password;

	@FindBy(xpath="//button[@name=\"websubmit\"]")
	WebElement createAccount;

	@FindBy(xpath="//div[starts-with(@id,'js') and contains(text(),'six')]")
	WebElement validationMessage;

	public void enterfname(String fname){
		log.info("entering firstname..."+fname);
		this.fname.sendKeys(fname);
	}
	
	public void enterlname(String lname){
		log.info("entering lastname..."+lname);
		this.lname.sendKeys(lname);
	}
	
	public void enternumber(int number){
		String num= Integer.toString(number);
		log.info("entering number..."+number);
		this.number.sendKeys(num);
	}
	
	public void clickOnCreateAcc(){
		log.info("clicked on create account link...");
		createAccount.click();
	}
	
	public boolean verifyErrorMessage(){
		password.click();
		String expectedText="Enter a combination of at least six numbers, letters and punctuation marks (like ! and &).";
		new VerificationHelper();
		return VerificationHelper.verifyTextEquals(validationMessage, expectedText);
	}
	
	
}
