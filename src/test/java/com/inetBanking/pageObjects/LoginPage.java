package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	// Creating a driver constructor and this is common in all classes and standard step. 
	
	public LoginPage (WebDriver rdriver)
	{
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy( name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	
public void setUserName(String uname)
{
		
		txtUserName.sendKeys(uname);
}
	
public void setPassword(String pwd)
{
		
		txtPassword.sendKeys(pwd);
}

public void clickSubmit()
{
	
	btnLogin.click();
}


}
