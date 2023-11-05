package com.shay.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.shay.baseDriver.BaseDriver;

import com.shay.pages.DashboardPage;
import com.shay.utilities.ExtentFactory;

public class DashboardTest extends BaseDriver{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	 public void start() throws InterruptedException {
//		 PageDriver.getCurrentDrieDriver().get(url);
//			Thread.sleep(2000); 
			
	report = ExtentFactory.getInstance();
	parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>ORANGE HRM Dashboard</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");

	 }
	@Test
	public void navAdminLinkTest() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>LOGIN</b></p>");
		DashboardPage dashboard = new DashboardPage(childTest);
		dashboard.navAdminLink();
		Thread.sleep(5000);
	}
	@AfterClass
	public void report() {
		report.flush();
	}
}
