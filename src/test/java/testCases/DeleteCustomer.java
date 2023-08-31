package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddcustomerPage;
import pageObjects.DeleteCustomerPage;
import pageObjects.EditCustomerpage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class DeleteCustomer extends BaseClass{

	@Test
	public void DeleteExistingCustomer() throws InterruptedException, IOException
	{
		logger.info("********* starting DeleteCustomerTest*************");
		
		driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		logger.info("*********Deleting Existing customer *************");
		
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
				 
			  String recordToBeDeleted="Tom Stephen";
				 
				String EmpList="//*[@id='customers-grid']/tbody/tr//td[3]";
				List<WebElement> nameOfEmp=driver.findElements(By.xpath(EmpList));
				
				
				boolean Empstatus=false;
				
				
				 for(WebElement allEmp:nameOfEmp)
				 {
					 String Empname=allEmp.getText(); 
					 if(Empname.contains(recordToBeDeleted))
				       {
						 Empstatus=true;
						 break;
				       }
					
				 }
				 
				 Thread.sleep(2000);
				 try
				 {
				 driver.findElement(By.xpath("//td[text()='"+recordToBeDeleted+"']//following-sibling::td[4]")).click();
				// driver.findElement(By.xpath("//input[@id='Gender_Male']")).click();
				 }
				 catch(Exception e)
				 {
					 
				 }
				 DeleteCustomerPage dp=new DeleteCustomerPage(driver);
				 dp.ClickOnDeleteButton();
				 dp.OpenModalDialog();
				// dp.CancelDeletion();
				 dp.DeleteRecord();
				 driver.navigate().back();
				 SearchCustomerPage sp=new SearchCustomerPage(driver);
				 sp.setFirstName("Tom");
				 sp.setLastName("Stephen");
				 sp.clickSearch();
				dp.ConfirmDeletion();
				 
				 
				 
				 
					
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

	
