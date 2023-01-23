package com.actitime.generic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class BasePage 
{
	public void selectValueFromList(WebElement el, String sType, String option)
	{
		Select list = new Select(el);
		int n;
		if(sType == "Text")
		{
			list.selectByVisibleText(option);
		}
		else if(sType == "Index")
		{
			n = Integer.parseInt(option);
			list.selectByIndex(n);
		}
		else if(sType == "Value")
		{
			list.selectByValue(option);
		}
		
		Reporter.log(option + " is selected.", true);
	}
	
	public void deSelectOptionFromList(WebElement list, String selectType, String option)
	{
		Select s = new Select(list);
		int n = Integer.parseInt(option);
		if(selectType == "Text")
		{
			s.deselectByVisibleText(option);
		}
		else if(selectType == "Index")
		{
			s.deselectByIndex(n);
		}
		else if(selectType == "Value")
		{
			s.deselectByValue(option);
		}
		Reporter.log(option + " is de-selected.", true);
	}

}
