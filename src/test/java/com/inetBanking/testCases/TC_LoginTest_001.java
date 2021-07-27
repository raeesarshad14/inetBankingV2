package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

import jdk.jfr.internal.Logger;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	
	{
		
		LoginPage lp = new LoginPage(driver);
		
		
		lp.setUserName(username);
		logger.info("User name entered");
		capturePassScreenShot(driver,"loginTest");

		
		lp.setPassword(password);
		logger.info("Password entered");
		capturePassScreenShot(driver,"loginTest");

		
		lp.clickSubmit();
		capturePassScreenShot(driver,"loginTest");

		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			
			Assert.assertTrue(true);
			logger.info("Title verified");
			capturePassScreenShot(driver,"loginTest");
		}
		else 
		{
			captureFailTestScreenShot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Title not verified. Test case failed");
		
		}
		
		
	}

}
