package com.shay.tests;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shay.baseDriver.BaseDriver;
import com.shay.baseDriver.PageDriver;
import com.shay.pages.LoginPage;


public class LoginTest extends BaseDriver{
	
	@BeforeClass
	public void start() throws InterruptedException {
		PageDriver.getCurrentDrieDriver().get(url);;
		Thread.sleep(2000);
	}
	
	
	@Test
	public void loginTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage.login();
	}
	
	
}
