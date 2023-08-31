package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import testBase.BaseClass;

public class TC_SearchCustomerByEmail extends BaseClass {
	
	@Test
	public void SearchCustomer() throws InterruptedException, IOException
	{
		
		String emailtobeSearch="rmtVh@gmail.com";
		
		
		logger.info("********* starting TC_SearchCustomerTest *************");
		
		driver.get(configPropObj.getProperty("baseURL"));
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		Thread.sleep(3000);
		
		logger.info("*********Clicking on customer Menu*************");
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		logger.info("*********Searching new customer *************");
		
		SearchCustomerPage searchcust=new SearchCustomerPage(driver);
		searchcust.setEmail(emailtobeSearch);	
		searchcust.clickSearch();
		Thread.sleep(2000);
		
		boolean status=searchcust.searchCustomerByEmail(emailtobeSearch);
		
		if(status==true)
		{
			logger.info("********* Search customer by email is passed *************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("********* Search customer by email is failed*************");
			captureScreen(driver,"searchCustomerbyEmail");
			Assert.assertTrue(false);
		}
		logger.info("********* End of TC_SearchCustomerByEmail_004 *************");
	}
		
		
		

}

