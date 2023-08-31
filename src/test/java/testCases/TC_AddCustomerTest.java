package testCases;



import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_AddCustomerTest extends BaseClass
{
	@Test(groups= {"master"})
	public void addNewCustomer() throws InterruptedException, IOException
	{
		logger.info("********* starting TC_AddCustomerTest_003 *************");
		
		driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		Thread.sleep(3000);
		
		logger.info("*********Adding new customer *************");
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		try
		{
			addcust.clickOnCustomersMenu();
			addcust.clickOnCustomersMenuItem();
			addcust.clickOnAddnew();
				
		}
		catch(Exception e)
		{
			
		}
		

		logger.info("***************  Providing customer details  *********** ");

		String email=randomestring()+"@gmail.com";
		
		try
		{
		addcust.setEmail(email);
		addcust.setPassword("test12");
		addcust.setFirstName("Tom");
		addcust.setLastName("Stephen");
		addcust.setGender("Male");
		addcust.setDob("7/05/1985"); // Format: MM/DD/YYY
		addcust.setCompanyName("busyQA");
		
		//***** Customer Roles - 
		
		/*					Vendors	||	Administrators	||	Forum Moderators
		--------------------------------------------------------------
			Registered		Yes		|	Yes				|	Yes
		--------------------------------------------------------------
			Guests			Yes		|	Yes				|	Yes
		Note: Registered Customers cannot be Guests */
		
		Thread.sleep(2000);
		addcust.setCustomerRoles("Registered"); //or addcust.setCustomerRoles("Guests");
		Thread.sleep(2000);
		//addcust.setCustomerRoles("Vendors");//addcust.setCustomerRoles("Administrators");//addcust.setCustomerRoles("Forum Moderators");
		//Thread.sleep(2000);
		
		addcust.setManagerOfVendor("Not a vendor");
		addcust.setAdminContent("This is for testing.........");
		addcust.clickOnSave();
		Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}

		try
		{
		// validation
				if (addcust.verifyConfirmationMsg()) {
					logger.info("***************  Customer added succesfully *********** ");
					Assert.assertTrue(true);

				} else {
					logger.error("*************** Customer Not added succesfully *********** ");
					captureScreen(driver,"addNewCustomer");
					Assert.assertTrue(false);
				}
				logger.info("***************   TC_AddCustomerTest_003 Finished  *********** ");
	}
	
	catch(Exception e)
	{
		
	}
	}
}


