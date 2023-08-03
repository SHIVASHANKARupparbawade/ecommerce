package Ecommerce.Test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginTest extends ExcelUtilsTest {
	
	WebDriver driver;
	
	
	public loginTest(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(xpath="//a [@class='ico-login']")
		public WebElement loginlink;
		@FindBy(id="Email")
		public WebElement emailtext;
		@FindBy(id="Password")
		public WebElement passwordtext;
		
		@FindBy(xpath="(//button[@type='submit'])[2]")
		public
		WebElement btnlogin;
		@FindBy(xpath="//a[@class='ico-logout']") 
		WebElement logoutlink;
		@FindBy(xpath="//div[@class='message-error validation-summary-errors']")
		public WebElement errorusernamemessage;
		
		@FindBy(xpath="//div[@class='message-error validation-summary-errors']")
		public WebElement errorpasswordmessage;
		
		@FindBy(xpath="//span[@class='field-validation-error']")
		public WebElement errorblankusername;
		
		@FindBy(xpath="//div[@class='message-error validation-summary-errors']")
		WebElement errorblankpassword;
		
		@FindBy(xpath="//span[@class='forgot-password']")
		public WebElement forgotpasswordlink;
		public boolean isloginblinkdisplayed()
		{
			return loginlink.isDisplayed();
		}
		
		public boolean isloginbuttondisplayed()
		{
			return btnlogin.isDisplayed();
		}
		public boolean loginpage(String email,  String password) throws InterruptedException
		{
			emailtext.clear();
			passwordtext.clear();
			emailtext.sendKeys(email);
			Thread.sleep(3000);
		passwordtext.sendKeys(password);
			Thread.sleep(3000);
			return true;
			
			
			
		}
		public String dologinwithinvalidemail(String email,  String password) throws InterruptedException
		{
			emailtext.clear();
			Thread.sleep(3000);
			passwordtext.clear();
			emailtext.sendKeys(email);
			Thread.sleep(3000);
		passwordtext.sendKeys(password);
			Thread.sleep(3000);
			btnlogin.click();
			return errorusernamemessage.getText();
			
			
		}
		public String dologinwithinvalidpassword(String email,  String password) throws InterruptedException
		{
			emailtext.clear();
			Thread.sleep(3000);
			passwordtext.clear();
			emailtext.sendKeys(email);
			Thread.sleep(3000);
		passwordtext.sendKeys(password);
			Thread.sleep(3000);
			btnlogin.click();
			return errorpasswordmessage.getText();
		}
		public String dologinwithblankusername(String email,  String password) throws InterruptedException
		{
			emailtext.clear();
			Thread.sleep(3000);
			passwordtext.clear();
			emailtext.sendKeys(email);
			Thread.sleep(3000);
		passwordtext.sendKeys(password);
			Thread.sleep(3000);
			btnlogin.click();
			return errorblankusername.getText();
		}
		public String dologinwithblankpassword(String email,  String password) throws InterruptedException
		{
			emailtext.clear();
			Thread.sleep(3000);
			passwordtext.clear();
			emailtext.sendKeys(email);
			Thread.sleep(3000);
		passwordtext.sendKeys(password);
			Thread.sleep(3000);
			btnlogin.click();
			return errorblankpassword.getText();
		}
		public boolean forgotpasswordlinktextispresentornot()
		{
			return forgotpasswordlink.isDisplayed();
		}

		
		
		
		
		
	}


	


