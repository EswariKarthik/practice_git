package com.actitime.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestDriver implements IAutoConstants
{
	public static WebDriver driver;

	
	@BeforeSuite
	public void startSuite(ITestContext context)
	{
		Reporter.log("Test Suite Execution Started " + context.getCurrentXmlTest().getSuite().getName(),true);
	}
	
	@BeforeTest
	@Parameters("browser")
	public void startTest(String browser, ITestContext context)
	{
		Reporter.log("Test Execution Started " + context.getCurrentXmlTest().getName(),true);
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver = new ChromeDriver();
			Reporter.log("Opened Chrome Browser",true);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
			driver = new FirefoxDriver();
			Reporter.log("Opened Firefox Browser",true);
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get(AppUrl);
	}
	
	@AfterTest
	public void endTest(ITestContext context)
	{
		driver.close();
		Reporter.log("Test Execution Completed " + context.getCurrentXmlTest().getName(),true);
	}
	
	
	

}
