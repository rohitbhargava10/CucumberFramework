
package com.automation.Sample.CucumberFramework.utility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ResourceHelper {

	public static String getResourcePath(String resource) {
		String path = getBaseResourcePath() + resource;
		return path;
	}
	
	public static String getBaseResourcePath() {
		String path = System.getProperty("user.dir");
		System.out.println(path);
		return path;
	}
	
	//Method to get input stream for a particular thing
	public static InputStream getResourcePathInputStream(String path) throws FileNotFoundException{
		return new FileInputStream(ResourceHelper.getResourcePath(path));
	}
	
	public static void main(String[] args) throws FileNotFoundException {	
		//System.out.println(ResourceHelper.getResourcePath("\\src\\main\\resources\\configfile\\"+ "config.properties"));
		getBaseResourcePath() ;
	}
	
}
