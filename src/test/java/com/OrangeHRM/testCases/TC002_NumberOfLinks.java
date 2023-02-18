package com.OrangeHRM.testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.testBase.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_NumberOfLinks extends BaseClass {

	@Test
	public void countOfLinks() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int linksCount = links.size();
		logger.info("The count of links on Orange HRM application Login page are -"+linksCount);
	}
	
	
}
