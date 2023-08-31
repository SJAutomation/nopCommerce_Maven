package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerpage {

	public WebDriver driver;
	
	@FindBy(id = "customer-delete")
	@CacheLookup
	WebElement DeleteBtn;
	
	@FindBy(xpath = "//*[@id=\"customermodel-Delete-delete-confirmation\"]/div/div")
	@CacheLookup
	WebElement ModalDialog;
	
	
	
	
	@FindBy(xpath ="//*[@id=\"customers-grid\"]/tbody/tr/td/a")
	@CacheLookup
	WebElement EditBtn;
	public EditCustomerpage(WebDriver driver)
	{
		
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}
	

	public void ModalDialog()
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void ClickOnEdit(){
		{
			EditBtn.click();
		}
	}

	
	
}
