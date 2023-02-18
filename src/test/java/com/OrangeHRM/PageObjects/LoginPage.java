package com.OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver; //driver 1
	
	//Constructor
	public LoginPage(WebDriver driver) { //driver 2
		this.driver = driver; //merging both the drivers
		PageFactory.initElements(driver, this); //init is initializing
	}
	
	//Locators declared globally
	@FindBy(name="username")
	WebElement txtUsername;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnLogin;
	
	//Methods
	public void enterUserName(String uName) {
		txtUsername.sendKeys(uName);
		String uVal = txtUsername.getAttribute("value");
		System.out.println("The value entered in username field is "+uVal);
	}
	public void enterPassword(String pwd) {
		txtPassword.sendKeys(pwd);
		String pVal = txtPassword.getAttribute("value");
		System.out.println("The value entered in password field is "+pVal);
	}
	public void clickLoginButton() {
		btnLogin.click();
		System.out.println("Login button is clicked");
	}
}
