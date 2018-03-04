
package com.automation.Sample.CucumberFramework.configuration.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.automation.Sample.CucumberFramework.utility.ResourceHelper;

public class IExploreBrowser {

	public Capabilities getIExplorerCapabilities() {
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR,
				ElementScrollBehavior.BOTTOM);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(
				InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap.setJavascriptEnabled(true);
		return cap;
	}

	public WebDriver getIExplorerDriver(Capabilities cap) {

		if (System.getProperty("os.name").contains("Mac")){
			System.setProperty("webdriver.ie.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/MicrosoftWebDriver"));
			return new InternetExplorerDriver(cap);
		}
		else if(System.getProperty("os.name").contains("Window")){
			System.setProperty("webdriver.ie.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/MicrosoftWebDriver.exe"));
			return new InternetExplorerDriver(cap);
		}
		return null;
	}
}


