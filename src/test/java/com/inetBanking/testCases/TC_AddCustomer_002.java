package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddNewCustomer;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomer_002 extends BaseClass {

	@Test
	public void AddCustomer() throws IOException, InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("User name is provided");
		capturePassScreenShot(driver,"AddCustomer");
		
		lp.setPassword(password);
		logger.info("Passsword is provided");
		capturePassScreenShot(driver,"AddCustomer");
		
		lp.clickSubmit();
		capturePassScreenShot(driver,"AddCustomer");
		
		Thread.sleep(3000);
		
		 AddNewCustomer addcust=new  AddNewCustomer(driver);
		
		addcust.clickAddNewCustomer();
	
		
		logger.info("providing customer details....");
		capturePassScreenShot(driver,"AddCustomer");
		
		addcust.custName("Raees");
		capturePassScreenShot(driver,"AddCustomer");
		
		addcust.custgender("male");
		capturePassScreenShot(driver,"AddCustomer");
		
		addcust.custdob("10","15","1985");
		capturePassScreenShot(driver,"AddCustomer");
		
		Thread.sleep(5000);
		
		addcust.custaddress("Pakistan");
		capturePassScreenShot(driver,"AddCustomer");
		
		addcust.custcity("GUJ");
		capturePassScreenShot(driver,"AddCustomer");
		
		capturePassScreenShot(driver,"loginTest");
		capturePassScreenShot(driver,"AddCustomer");
		
		addcust.custstate("AP");
		capturePassScreenShot(driver,"AddCustomer");
		
		addcust.custpinno("5000074");
		capturePassScreenShot(driver,"AddCustomer");
		
		addcust.custtelephoneno("987890091");
		capturePassScreenShot(driver,"AddCustomer");
		
		// see method below for random email
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		capturePassScreenShot(driver,"AddCustomer");
		
		addcust.custpassword("abcdef");
		capturePassScreenShot(driver,"AddCustomer");
		
		addcust.custsubmit();
		capturePassScreenShot(driver,"AddCustomer");
		
		Thread.sleep(3000);
		
boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");

		}
		
}
	
	//creating a random characters using "RandomStringUtils" class which we have to use in the page
	public String randomstring()
	{
	String generatedstring =RandomStringUtils.randomAlphabetic(8);
	return (generatedstring);
	}
	
	public String randomeNum()
	{
	String generatedstring2 =RandomStringUtils.randomNumeric(4);
	return (generatedstring2);
	}
	

}
