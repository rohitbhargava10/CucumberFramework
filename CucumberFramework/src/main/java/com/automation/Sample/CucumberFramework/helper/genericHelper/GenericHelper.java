package com.automation.Sample.CucumberFramework.helper.genericHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.automation.Sample.CucumberFramework.helper.Logger.LoggerHelper;

public class GenericHelper{
	
	private static final Logger log = LoggerHelper.getLogger(GenericHelper.class);
	
	public String readValueFromElement(WebElement element) {
		if (null == element){
			log.info("webElement is null");
			return null;
		}
		boolean displayed = false;
		try {
			displayed = isDisplayed(element);
		} catch (Exception e) {
			log.error(e);
			return null;
		}
		if (!displayed)
			return null;
		String text = element.getText();
		log.info("weblement valus is.."+text);
		return text;
	}
	
	public String readValueFromInput(WebElement element) {
		if (null == element)
			return null;
		if (!isDisplayed(element))
			return null;
		String value = element.getAttribute("value");
		log.info("weblelement valus is.."+value);
		return value;
	}
	
	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is displayed.."+element);
			return true;
		} catch (Exception e) {
			log.info(e);
			return false;
		}
	}
	
	protected boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is displayed.."+element);
			return false;
		} catch (Exception e) {
			log.error(e);
			return true;
		}
	}
	
	protected String getDisplayText(WebElement element) {
		if (null == element)
			return null;
		if (!isDisplayed(element))
			return null;
		return element.getText();
	}
}
