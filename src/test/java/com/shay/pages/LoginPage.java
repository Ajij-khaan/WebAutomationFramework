package com.shay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.shay.baseDriver.PageDriver;

public class LoginPage {
	
	//Protiti page e erokom constructor diye page factory define korte hobe.
	
	public  LoginPage() {
		PageFactory.initElements(PageDriver.getCurrentDrieDriver(), this);
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
	
	public void login() throws InterruptedException {
		userName.sendKeys("Admin");
		password.sendKeys("admin123");
		loginButton.click();
		Thread.sleep(5000);
	}
	
}
