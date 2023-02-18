package com.OrangeHRM.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

//Declaring variables
public WebDriver driver;
//Declaring properties variable to get the values from config.properties
public Properties prop;
//Declaring Logger variable to store the logs
public Logger logger = LogManager.getLogger(this.getClass());

	/****
	 * Method to launch application
	 * @throws IOException 
	 */
	@BeforeMethod
	@Parameters("browserName") //Retrieving browser name from testng.xml parameters
	public void setup(String bname) throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\15146\\Documents\\Tekinspire\\Installation files\\Eclipse\\Eclipse training\\OrangeHRM\\resources\\config.properties");
		prop.load(fis);
		//String browserName = prop.getProperty("browser"); //-->You can do it other way by adding a parameter in testng.xml
		if(bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			//System.out.println("Chrome browser is launched");
			logger.info("Chrome browser is launched"); //The message to be printed will go and store in logs
		}else if(bname.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			//System.out.println("Edge browser is launched");
			logger.info("Edge browser is launched");
		} else {
			//System.out.println("Chrome and Edge are the browsers supported");
			logger.info("Chrome and Edge are the browsers supported");
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		//System.out.println("Orange HRM application is launched");
		logger.info("Orange HRM application is launched");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		
	/****
	 * Method to close application
	 * 
	 */
	@AfterMethod
	public void closeApplication() {
		driver.close();
		//System.out.println("Orange HRM application is closed successfully");
		logger.info("Orange HRM application is closed successfully");
	}
}
