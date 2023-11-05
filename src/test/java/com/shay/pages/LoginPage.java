package com.shay.pages;

import java.awt.Stroke;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.shay.baseDriver.PageDriver;
import com.shay.utilities.GetScreenShot;

public class LoginPage {
	
	//Protiti page e erokom constructor diye page factory define korte hobe.
	//	PageFactory.initElements method used to initialize the web elements on the page 
		
	ExtentTest test; // report er jonno test variable nilam
	public  LoginPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDrieDriver(), this);
		this.test = test;
	}
	
	/*multiple locator eksathe usekorar way*/
	
	@FindBys({
		@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]"),
		@FindBy(xpath = "//input[@name=\"username\"]")
	})
	WebElement userName;
	
	//Signle locatior userkote hole
	
	@FindBy(xpath = "//*[@name=\"password\"]")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	
	
	public void failedCase(String message, String scName) throws IOException {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>+"+message+"+</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDrieDriver(), "+scName+" );
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDrieDriver().quit();
	}
	
	
	public void passedCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>+"+message+"+</b></p>");
	}
	
	public void passedCaseWithSc(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>+"+message+"+</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDrieDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}
	
	public void login() throws InterruptedException, IOException {
		
		try {
			test.info("Enter username");
			if(userName.isDisplayed()) {
				userName.sendKeys("Admin");
				passedCase("Username Entered");
				
				try {
					if(password.isDisplayed()) {
						password.sendKeys("admin123");
						passedCase("Password Entered");

						try {
							test.info("Click the login button");
							if(loginButton.isDisplayed()) {
								loginButton.click();
								Thread.sleep(5000);
								
								passedCaseWithSc("Login Successfull", "Login Success");
							}
						} catch (Exception e) {
							failedCase("Login Button is not located. Please check error message", "Login Faield");
						}
					}
				} catch (Exception e) {
					failedCase("Password is not located. Please check error message", "Password Faield");
				}
			}
		} catch (Exception e) {
			failedCase("Username is not located. Please check error message", "Username Faield12");
		}
	}
	
}
