package testCases;


	import java.io.IOException;

	import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.testng.Assert;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.XLUtility;

	public class TC_LoginDDT extends BaseClass{


		@Test(dataProvider="LoginData",groups= {"master"})
		public void loginTest(String user,String pwd,String exp) throws InterruptedException
		{
			logger.info(" *** Starting TC_LoginDDT *** ");
			
			logger.info(" *** Opening Application URL *** ");
			
			driver.get(configPropObj.getProperty("baseURL"));
			
			logger.info(" *** Loging into Application *** ");
			LoginPage lp=new LoginPage(driver);
			lp.setUserName(user);
			lp.setPassword(pwd);
			lp.clickLogin();
			Thread.sleep(3000);
			
			String exp_title="Dashboard / nopCommerce administration";
			String act_title=driver.getTitle();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				
				
				if(exp_title.equals(act_title))
				{
					driver.findElement(By.linkText("Logout")).click();
					Assert.assertTrue(true);
					
					
				}
				else 
				{
					logger.info("Login failed....");
					
					Assert.assertTrue(false);
					
					
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
//				if(exp_title.equals(act_title))
//				{
//					driver.findElement(By.linkText("Logout")).click();
//					
//					logger.info("Login failed....");
					Assert.assertTrue(false);
					
				}
				else
				{				
					
					Assert.assertTrue(true);
					
				}
			
		
			logger.info(" *** Finished TC_LoginDDT *** ");
		}
		
	
		
	
		
		@DataProvider(name="LoginData")
		public String [][] getData() throws IOException
		{
			String path=".\\testData\\loginData.xlsx";
			
			XLUtility xlutil=new XLUtility(path);
			
			int totalrows=xlutil.getRowCount("Sheet1");	//4
			int totalcols=xlutil.getCellCount("Sheet1",1); //3
					
			String logindata[][]=new String[totalrows][totalcols];
			
			for(int i=1;i<=totalrows;i++)  //1<=4
			{		
				for(int j=0;j<totalcols;j++)  //0<3
				{
					logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
				}
			}
		return logindata;
					
		}
	}
		
	
	

