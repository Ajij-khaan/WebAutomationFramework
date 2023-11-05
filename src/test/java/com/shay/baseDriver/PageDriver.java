package com.shay.baseDriver;

import org.openqa.selenium.WebDriver;

public class PageDriver {
	
	/*
	 * protita page er jonno amra alada alada driver use korbo. tai webDriver type
	 * er ekta local thread create kore nilam etake singleton pattern o bole.
	 * https://qavalidation.com/2021/12/java-singleton-pattern-in-selenium-framework
	 * .html/ ei link e giye ei page er code er explantion & video check korbo
	 */
	
	public static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	private static PageDriver instance = null;
	
	// Private constructor to prevent external instantiation
	private PageDriver() {
		
	}
	
	//ekhane getInstance()page driver class er ekti instance create korlam ja golbally  access kora jabe.	
	
	// Public static method to access the single instance.
	public static  PageDriver getInstance() {
		if(instance == null) {
			instance = new PageDriver();
		}
		return instance;
	}
	
	//This method is used to retrieve the WebDriver instance associated with the current thread
	public WebDriver getDriver() {
		return webDriver.get();
	}
	
	//This method is used to set the WebDriver instance for the current thread
	public void setDriver(WebDriver driver) {
		webDriver.set(driver);
	}
	
	//This static method is used to obtain the WebDriver instance for the current thread
	public static WebDriver getCurrentDrieDriver() {
		return getInstance().getDriver();
	}
}
