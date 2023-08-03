package E2ETEST;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageTest {
	WebDriver driver;
		
		 public LoginPageTest(WebDriver driver){
			 this.driver=driver;
		        PageFactory.initElements(driver,this);
		    }
	    @FindBy(name="username")
	    WebElement UserNametext;
	    @FindBy(name="password")
	    WebElement Passwordtext;
	    @FindBy(css="[type=submit]")
	    WebElement Loginbutton;
	    @FindBy(tagName = "p")
	    WebElement InvalidCreds;

	   
	    public void TestLogin(String username, String password) throws InterruptedException {
	        UserNametext.sendKeys(username);
	        Passwordtext.sendKeys(password);
	        Loginbutton.click();
	    }

	    public String TestLoginWithInvalidCreds(String username, String password){
	        UserNametext.sendKeys(username);
	        Passwordtext.sendKeys(password);
	        Loginbutton.click();
	        return InvalidCreds.getText();
	    }
	}

