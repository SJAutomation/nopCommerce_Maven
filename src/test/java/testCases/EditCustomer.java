package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddcustomerPage;
import pageObjects.EditCustomerpage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class EditCustomer extends BaseClass{

	@Test
	public void EditCustomer() throws InterruptedException, IOException
	{
		logger.info("********* starting EditCustomerTest*************");
		
		driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		logger.info("*********Editing Existing customer *************");
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
	/*	SearchCustomerPage searchCust=new SearchCustomerPage(driver);
		
		
		
		for (int i = 1; i <= searchCust.getNoOfRows(); i++)
		{
			for (int j=2, k=0; j<=searchCust.getNoOfColumns(); j++, k++)
			{
				

				
				//String rowText = null ;
				
				/*
				 String rowStr="//*[@id=\"customers-grid\"]/tbody/tr["+ i  +"]/td["+ j +"]";
				 List<WebElement> Eles=driver. findElements(By.xpath(rowStr));
				 for(WebElement allEle:Eles)
				 {
					rowText= allEle.getText();
					 
					 
					 String recordToBeDeleted="Tom Mathew";
					 
					 if(rowText.equalsIgnoreCase(recordToBeDeleted))
					 {
						 //EditCustomerpage editCust=new EditCustomerpage(driver);
						// editCust.ClickOnEdit();
							
						 driver.findElement(By.xpath("//*[@id=\\\"customers-grid\\\"]/tbody/tr[" + i + "]" +  "/td[7]"  + "/a")).click(); 
					 }
					 
				 }
				 
				 */
				 
			  String recordToBeEdited="Tom Stephen";
				 
				String EmpList="//*[@id='customers-grid']/tbody/tr//td[3]";
				List<WebElement> nameOfEmp=driver.findElements(By.xpath(EmpList));
				
				
				boolean Empstatus=false;
				
				
				 for(WebElement allEmp:nameOfEmp)
				 {
					 String Empname=allEmp.getText(); 
					 if(Empname.contains(recordToBeEdited))
				       {
						 Empstatus=true;
						 break;
				       }
					
				 }
				 
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//td[text()='"+recordToBeEdited+"']//following-sibling::td[4]")).click();
				 driver.findElement(By.xpath("//input[@id='Gender_Female']")).click();
				 driver.findElement(By.xpath("//button[@name='save']")).click();
				boolean EditStatus= driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).isDisplayed();
					if(EditStatus==true)
					{
						Assert.assertTrue(true);
						System.out.println("Record Edited Sucessfully.......");
					}
					else
					{
						Assert.assertTrue(false);
						System.out.println("Record not found.......");
					}
				
					
			/*	String rowText="//*[@id=\"customers-grid\"]/tbody/tr["+ i  +"]/td["+ j +"]";
				List<WebElement> rt=driver.findElements(By.xpath(rowText));
				
				 for(WebElement allEle:rt)
				       if(rowText==recordToBeDeleted)
				       {
							String EditLink="//*[@id=\"customers-grid\"]/tbody/tr["+ i  +"]/td["+ j +"]/a";
							List<WebElement> w1=driver.findElements(By.xpath(EditLink));
							 for(WebElement EditBtn:w1)
							 {
								 EditBtn.click();
								 System.out.println("Record Deleted Successfully.......");
							 }
				// System.out.println(rowText);
				 
				
				 
				*/
				 
			
		}
		
		
		
	
		
		
}

	
