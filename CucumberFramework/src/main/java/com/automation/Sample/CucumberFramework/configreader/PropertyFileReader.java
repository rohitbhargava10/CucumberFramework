
package com.automation.Sample.CucumberFramework.configreader;

import java.util.Properties;
import org.apache.log4j.Level;

import com.automation.Sample.CucumberFramework.configuration.browser.BrowserType;
import com.automation.Sample.CucumberFramework.utility.ResourceHelper;


public class PropertyFileReader implements ConfigReader{

	private Properties prop = null;

	public PropertyFileReader() {
		prop = new Properties();
		try {
			//prop.load requires fileinputstream
			prop.load(ResourceHelper.getResourcePathInputStream("/src/main/resources/configfile/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUserName() {
		return prop.getProperty("Username");
	}

	public String getPassword() {
		return prop.getProperty("Password");
	}

	public String getWebsite() {
		return prop.getProperty("Website");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	public String getDbType() {
		return prop.getProperty("DataBase.Type");
	}

	public String getDbConnStr() {
		return prop.getProperty("DtaBase.ConnectionStr");
	}

	public BrowserType getBrowser() {
		return BrowserType.valueOf(prop.getProperty("Browser"));
	}

	
}
