package com.shay.tests;



import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.shay.baseDriver.BaseDriver;
import com.shay.baseDriver.PageDriver;
import com.shay.pages.LoginPage;
import com.shay.utilities.ExtentFactory;


public class LoginTest extends BaseDriver{
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	
	
	@BeforeClass
	public void start() throws InterruptedException {
		PageDriver.getCurrentDrieDriver().get(url);
		Thread.sleep(2000);
		
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>ORANGE HRM LOGIN</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}
	
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>LOGIN</b></p>");
	
		LoginPage loginPage = new LoginPage(childTest); //login page er object korlam
		loginPage.login(); // sei object diye login page er login method take call koralm
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
	
	
}
