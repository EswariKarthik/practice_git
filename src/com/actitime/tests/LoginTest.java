package com.actitime.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actitime.generic.ReadInput;
import com.actitime.generic.TestDriver;
import com.actitime.pages.ActiTimeEnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class LoginTest extends TestDriver
{
	private String eTitle, aTitle;
	
	@Test(dataProvider = "inputLoginTest")
	public void loginPageTest(String userName, String password)
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(userName);
		lp.enterPassword(password);
		lp.clickOnLoginButton();
		eTitle = "actiTIME - Enter Time-Track";
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleIs(eTitle));
		aTitle = driver.getTitle();
				
		Assert.assertEquals(aTitle, eTitle, "Title is not matching " + aTitle);
		if(aTitle.equalsIgnoreCase(eTitle))
		{
			Reporter.log("Titles are matching. "+aTitle, true);
			ActiTimeEnterTimeTrackPage ettp = new ActiTimeEnterTimeTrackPage(driver);
			ettp.clickOnLogoutLink();
		}
	}
	
	@Test(dataProvider = "inputLoginTest")
	public void loginPageErrorTest(String userName, String password)
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(userName);
		lp.enterPassword(password);
		lp.clickOnLoginButton();
		eTitle = "Username or Password is invalid. Please try again.";
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("errormsg"))));
		aTitle = driver.findElement(By.className("errormsg")).getText();
				
		Assert.assertEquals(aTitle, eTitle, "Error Message is not matching " + aTitle);
		if(aTitle.equalsIgnoreCase(eTitle))
		{
			Reporter.log("Error Messages are matching. "+aTitle, true);
		}
	}
	
	@DataProvider
	public Object[][] inputLoginTest(Method testMethod)
	{
		ReadInput ip = new ReadInput();
		Object data[][] = null;
		try
		{
		data = ip.readInputData(testMethod.getName());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return data;
	}

}
