package com.OrangeHRM.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.DashboardPage;
import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.testBase.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_VerifyDashboardText extends BaseClass{

	@Test
	public void checkDashboardText() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(prop.getProperty("userName"));
		lp.enterPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		
		DashboardPage dp = new DashboardPage(driver);
		String actVal = dp.checkDashboardTopText();
		Assert.assertEquals(actVal, "Dashboard", "The text is not displayed as 'Dashboard'");
		logger.info("Dashboard text is present on the top");
	}
}
