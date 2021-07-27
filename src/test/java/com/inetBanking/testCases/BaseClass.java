package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig() ;// Creating the Readconfig class object to access the method.
											 
			
	public String baseURL = readconfig.getApplicationURL() ;
	public String username = readconfig.getUsername() ;
	public String password = readconfig.getPassword() ;
	public static WebDriver driver ; 
	public static Logger logger;
	
	@Parameters ("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEpath());
			 driver = new InternetExplorerDriver();
		}
		
		// Below statement is to open the URL. we removed it from the test case and added here becasue this is common step to open the browser for all the test cases. So don't need to write again and again.
		driver.get(baseURL);
		
		
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// below 2 statements are to configure the logs statement. These 2 steps are standard.
		// After these 2 steps, we can add log massages in tests. (Example: URL opned and etc)
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		

		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureFailTestScreenShot(WebDriver driver, String tname) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//will give you current time stamp. which we using in target variable 
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/FailTestCasesScreenShots/" + timeStamp + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public void capturePassScreenShot(WebDriver driver, String tname) throws IOException
			{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//will give you current time stamp. which we using in target variable  
			
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
				File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File target = new File(System.getProperty("user.dir") + "/PassTestCasesScreenShots/" + timeStamp + tname + ".png");
				FileUtils.copyFile(source, target);
				System.out.println("Screenshot taken");
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
