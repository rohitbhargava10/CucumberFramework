package com.automation.Sample.CucumberFramework.helper.assertionHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.automation.Sample.CucumberFramework.helper.Logger.LoggerHelper;


public class VerificationHelper{
	
	//isDisplayed method is used

	private static final  Logger log = LoggerHelper.getLogger(VerificationHelper.class);

	public static synchronized boolean verifyElementPresent( WebElement element) {
		boolean isDisplayed = false;
		try {
			 isDisplayed= element.isDisplayed();
			 log.info(element.getText()+" is displayed");
		}
		catch(Exception ex) {
			log.error("Element not found " + ex);
		}
		return isDisplayed;
	}
	
	public static synchronized boolean verifyElementNotPresent( WebElement element) {
		boolean isDisplayed = false;
		try {
			 element.isDisplayed();
			 log.info(element.getText()+" is displayed");
		}
		catch(Exception ex) {
			log.error("Element Found " + ex);
			isDisplayed = true;
		}
		
		return isDisplayed;
	}
	
	public static synchronized boolean verifyTextEquals( WebElement element,String expectedText) {
		boolean flag = false;
		try {
			String actualText=element.getText();
			if(actualText.equals(expectedText)) {
				log.info("actualText is :"+actualText+" expected text is: "+expectedText);
				return flag=true;
			}
			else {
				log.error("actualText is :"+actualText+" expected text is: "+expectedText);
				return flag;
			}
		}
		catch(Exception ex) {
			log.error("actualText is :"+element.getText()+" expected text is: "+expectedText);
			log.info("text not matching" + ex);
			return flag;
		}
	}
}