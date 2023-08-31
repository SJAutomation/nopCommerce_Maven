package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver driver)
	{
		this.ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(id = "Password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//button[text()='Log in']")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(linkText = "Logout")
	@CacheLookup
	WebElement lnkLogout;
	
	@FindBy(xpath= "//p[contains(text(),'Dashboard')]")
	@CacheLookup
	WebElement Dashboard;
	
	
	
	@FindBy(linkText = "//p[contains(text(),'Login was unsuccessful')]")
	@CacheLookup
	WebElement LoginUnsucess;
	
	 
	
	
	public void setUserName(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}

	public void setPassword(String pwd) {

		txtPassword.clear();
		txtPassword.sendKeys(pwd);
		
	}

	public void clickLogin() {

		btnLogin.click();
	}

	public void clickLogout() {
		Actions act=new Actions(ldriver);
		act.moveToElement(lnkLogout).perform();
		act.click();
		//lnkLogout.click();
	} 
	
	public void CheckLoginStatus()
	{
		boolean Status=Dashboard.isDisplayed();
		boolean True = false;
		if(Status==True)
			Assert.assertTrue(true);
		else 
			Assert.assertTrue(false);
	}
	
	
}
