package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.actitime.generic.BasePage;

public class ActiTimeEnterTimeTrackPage extends BasePage
{	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	public ActiTimeEnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogoutLink()
	{
		logoutLink.click();
		Reporter.log("Clicked on Logout link..",true);
	}
}
