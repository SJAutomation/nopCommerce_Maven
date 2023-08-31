package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import testBase.BaseClass;

public class TC_SearchCustomerByName extends BaseClass {
	
	
	String firstnamebeSearch="Tom";
	String lastnamebeSearch="Mathew";
	
	@Test
	public void SearchCustomer() throws InterruptedException, IOException
	{
		
	
	
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
	searchcust.setFirstName(firstnamebeSearch);
	searchcust.setLastName(lastnamebeSearch);
	searchcust.clickSearch();
	Thread.sleep(2000);
	
	boolean status=searchcust.searchCustomerByName(firstnamebeSearch+" "+lastnamebeSearch);
	
	if(status==true)
	{
		logger.info("********* Search customer by name is passed *************");
		Assert.assertTrue(true);
	}
	else
	{
		logger.error("********* Search customer by name is failed*************");
		captureScreen(driver,"searchCustomerbyName");
		Assert.assertTrue(false);
	}
	logger.info("********* End of TC_SearchCustomerByName *************");
}
	
	

}
