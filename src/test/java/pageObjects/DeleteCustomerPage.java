package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {

	public WebDriver driver;
	
	@FindBy(xpath = "//span[@id='customer-delete']")
	@CacheLookup
	WebElement DeleteBtn;
	
	@FindBy(xpath = "//*[@id=\"customermodel-Delete-delete-confirmation\"]/div/div")
	@CacheLookup
	WebElement ModalDialogWithDelete;
	
	
	
	@FindBy(xpath ="//*[@id=\"customermodel-Delete-delete-confirmation\"]/div/div//button[@class='btn btn-danger float-right']")
	@CacheLookup
	WebElement DeleteRecord;
	
	
	@FindBy(xpath ="//td[text()='No data available in table']")
	@CacheLookup
	WebElement ConfirmDeletion;
	
	
	
	public DeleteCustomerPage(WebDriver driver)
	{
		
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}
	
	
	
	

	public void OpenModalDialog()
	{
		ModalDialogWithDelete.click();
	}
	
	public void DeleteRecord()
	{
		DeleteRecord.click();
	}
	
	public void CancelDeletion()
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void ClickOnDeleteButton(){
		{
			DeleteBtn.click();
		}
	}
	
	public void ConfirmDeletion()
	{
		
		 boolean RecordDeleted=ConfirmDeletion.isDisplayed();
		 
		 if(RecordDeleted==true)
			 System.out.println("Record Deleted Sucessfully..");
		 else
			 System.out.println("Record not Deleted Sucessfully..");
	}

	
	
}
