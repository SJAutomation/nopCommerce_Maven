package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProducts {
	
	
   public WebDriver driver;
	
	public AddProducts(WebDriver dr)
	{
		this.driver=dr;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[2]/a/i")
	WebElement CatalogTab;
	
	
	@FindBy(xpath = "//p[text()=' Categories']")
	WebElement CategoriesTab;
	
	
	@FindBy(xpath = "//p[text()=' Products']")
	WebElement ProductsTab;
	
	
	@FindBy(xpath = "//i[@class='fas fa-plus-square']")
	WebElement AddNewProduct;
	
	@FindBy(xpath = "//input[@id='Name']")
	WebElement ProdName;
	
	@FindBy(xpath = "//div[@class='upload-image-button float-left px-md-1']")
	WebElement UploadBtn;
	
	@FindBy(xpath = "//button[@name='save']")
	WebElement SaveProd;
	
	
	
	public void OpenCatalogTab() 
	{
		CatalogTab.click();
	}

	
	
	public void OpenCategories() throws Exception
	{
		CategoriesTab.click();
	}

	
	public void AddNewProduct()
	{
		AddNewProduct.click();
	}
	
	public void GiveProductName(String Product)
	{
		ProdName.sendKeys(Product);
	}
	
	public void UploadProdImage()
	{
		UploadBtn.click();
	}
	
	public void SaveProduct() 
	{
		SaveProd.click();
	}
	
	
	public void OpenProducts() throws Exception
	{
		ProductsTab.click();
	}

	
}
