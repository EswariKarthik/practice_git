package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.actitime.generic.BasePage;

public class LoginPage extends BasePage
{
	@FindBy(id = "username")
	private WebElement usrnm;
	
	@FindBy(name = "pwd")
	private WebElement passwd;
	
	@FindBy(id = "loginButton")
	private WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String userName)
	{
		usrnm.sendKeys(userName);
		Reporter.log("Entered is User Name.", true);
	}
	
	public void enterPassword(String password)
	{
		passwd.sendKeys(password);
		Reporter.log("Entered is Password.", true);
	}
	
	public void clickOnLoginButton()
	{
		loginBtn.click();
		Reporter.log("Clicked on Login Button.", true);
	}

}
