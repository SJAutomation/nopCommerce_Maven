package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class ProductsList {

public WebDriver driver;
	
	public ProductsList(WebDriver dr)
	{
		this.driver=dr;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"products-grid\"]//tbody")
	WebElement table;

	@FindBy(how = How.XPATH, using = "//*[@id=\"products-grid\"]//tbody//tr")
	List<WebElement> tableRows;

	@FindBy(how = How.XPATH, using = "//*[@id=\"products-grid\"]//tbody//tr//td")
	List<WebElement> tableColumns;
	
	public int getNoOfRows() {
		return (tableRows.size());
	}

	public int getNoOfColumns() {
		return (tableColumns.size());
	}

}
