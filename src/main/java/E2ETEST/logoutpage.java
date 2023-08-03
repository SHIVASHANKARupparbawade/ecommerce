package E2ETEST;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logoutpage {
	
	    @FindBy(className = "oxd-userdropdown-tab")
	    public WebElement ProfileTabbutton;
	    @FindBy(partialLinkText = "Logout")
	    public WebElement logOutLink;
	    @FindBy(className = "oxd-main-menu-item--name")
	    public List<WebElement> menus;

	    public logoutpage(WebDriver driver) {

	        PageFactory.initElements(driver, this);
	    }

	    public void doLogout() {
	        ProfileTabbutton.click();
	        logOutLink.click();
	    }
	}

