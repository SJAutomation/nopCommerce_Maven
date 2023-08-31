package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.XLUtility;

public class SearchCustomerPage {
	
	public WebDriver driver;

	public SearchCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "SearchEmail")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(how = How.ID, using = "SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;

	@FindBy(how = How.ID, using = "SearchLastName")
	@CacheLookup
	WebElement txtLastName;

	@FindBy(how = How.ID, using = "search-customers")
	@CacheLookup
	WebElement btnSearch;

	@FindBy(how = How.XPATH, using = "//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;

	@FindBy(how = How.XPATH, using = "//*[@id='customers-grid']")
	WebElement table;

	@FindBy(how = How.XPATH, using = "//*[@id='customers-grid']/tbody/tr")
	List<WebElement> tableRows;

	@FindBy(how = How.XPATH, using = "//*[@id='customers-grid_wrapper']/tbody/tr/td")
	List<WebElement> tableColumns;

	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setFirstName(String fname) {

		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {

		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}

	public void clickSearch() {
		btnSearch.click();

	}
	
	

	public int getNoOfRows() {
		return (tableRows.size());
	}

	public int getNoOfColumns() {
		return (tableColumns.size());
	}

	public boolean searchCustomerByEmail(String email) {
		boolean flag = false;

		for (int i = 1; i <= getNoOfRows(); i++) {
			String emailid = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]")).getText();
				
			

			

			if (emailid.equalsIgnoreCase(email)) {
				flag = true;
				System.out.println(email +" found in record....");
				break;
			}
		}

		return flag;

	}

	public boolean searchCustomerByName(String Name) {
		boolean flag = false;

		for (int i = 1; i <= getNoOfRows(); i++) {
			String name = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]")).getText();
					
			
			
			System.out.println("Name got from table is:"+name);
			
			if(name.contains(Name) )
			{
				flag = true;
				System.out.println(Name +" Input name provided found in record....");
				break;
			}
			
		/*	
			if (Name.equals(name)) {
				flag = true;
				System.out.println(name +" found in record....");
				break;
			}
			*/
		}
		

		return flag;

	}
	
	
	public void fetchallCustomers() throws IOException 
	{
		try
		{
		for (int i = 1; i <= getNoOfRows(); i++)
		{
			for (int j=2, k=0; j<=getNoOfColumns(); j++, k++)
			{
				

				String path=".//testData//Fetch_Employees_List.xlsx";
				XLUtility xlutil=new XLUtility(path);
				
				 String rowStr="//table[@id='customers-grid']/tbody/tr[" + i + "]" +  "/td" + "[" +j +"] ";
				 WebElement Ele=driver.findElement(By.xpath(rowStr));
				 String rowText=Ele.getText();
				 
				 if(rowText!=null)
					 xlutil.setCellData("Sheet1", i, k, rowText);
				 else 
					 xlutil.setCellData("Sheet1",i, k, "Blank data");
				 
			}
		}
		}catch(Exception e)
		{
			
		}
					
		
	}

}