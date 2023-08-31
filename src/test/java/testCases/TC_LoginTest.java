package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;




	
public class TC_LoginTest extends BaseClass{
		
		
		
		//public static Logger logger; //Added logger
		//public WebDriver driver;
		
		@Test(groups={"sanity","regression","master"})
		public void loginTest() throws IOException 
		{
			logger.info("****  Starting TC_LoginTest ****");
			driver.get(configPropObj.getProperty("baseURL"));

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // implicit wait
			
			LoginPage lp=new LoginPage(driver);
			
			logger.info("**** Providing login details****");
		
			lp.setUserName(configPropObj.getProperty("useremail"));
			lp.setPassword(configPropObj.getProperty("password"));
			lp.clickLogin();
			
			logger.info("**** comparing titles ****");
			String exp_title="Dashboard / nopCommerce administration";
			String act_title=driver.getTitle();
			
			
			Assert.assertTrue(true);
			if(exp_title.equals(act_title))
			{
				logger.info("**** Login Test is passed sucessfully.... ****");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("**** Login Test is failed ****");
				captureScreen(driver,"loginTest");
				Assert.assertTrue(false);
			}
				
			logger.info("****  Finished TC_LoginTest ****");
			
		}
		
		
	}


