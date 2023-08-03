package Ecommerce.com;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ecommerce.Test.ExcelUtilsTest;
import Ecommerce.Test.loginTest;
import Ecommerce.Test.setup;

public class loginrunner extends setup {
	loginTest login;

	
	@Test(priority = 1,description  = "user click on login link")
	public void isloginbuttondisplayed()
	{
		 login=new loginTest(driver);
		boolean loginlink= login.isloginblinkdisplayed();
		//assertion
		Assert.assertTrue(loginlink);
		if(loginlink==true)
		{
		login.loginlink.click();
	}
	}
	@Test(priority = 2,description = "user test login wih invalidemail")
	public void lisinvalidusernameTest() throws InterruptedException
	{
		login=new loginTest(driver);
		String validationmessage= login.dologinwithinvalidemail("uppppparbawades94@gmail.com","SHI1996v@123");
		
		Assert.assertTrue(validationmessage.contains("Login was unsuccessful. Please correct the errors"));
		login.emailtext.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		
		
		
	}
	
	@Test(priority = 3,description = "user do login with invalidpassword")
	public void invalidpasswordtest() throws InterruptedException
	{
		login=new loginTest(driver);
		String validationmessage= login.dologinwithinvalidpassword("upparbawades94@gmail.com","SHI123451996v@123");
		
		
		Assert.assertTrue(validationmessage.contains("Login was unsuccessful. Please correct the errors and try again"));
		
		login.emailtext.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		
	}
	@Test(priority=4,description = "user login without username text")
	public void loginwithoutusernametext() throws InterruptedException
	{
		login=new loginTest(driver);
		String validationmessage= login.dologinwithblankusername("", "SHI1996v@123");
		Assert.assertTrue(validationmessage.contains("Please enter your email"));
		login.emailtext.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
	}
	
	@Test(priority = 5,description = "user login with blank password")
	public void blankpassword() throws InterruptedException
	{
		login=new loginTest(driver);
		String validationmessage= login.dologinwithblankpassword("upparbawades94@gmail.com", "");
		Assert.assertTrue(validationmessage.contains("Login was unsuccessful. Please correct the errors and try again."));
		login.emailtext.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
	}
	
	@Test
	public void forgetpasswordlinkispresntornot()
	{
		login=new loginTest(driver);
		boolean forgotpassword= login.forgotpasswordlinktextispresentornot();
		Assert.assertTrue(forgotpassword);
		Assert.assertTrue(login.forgotpasswordlink.isDisplayed());
	}
	@Test(priority = 6,description = "user do successfull login")
	public void Sucessfulllogin() throws InterruptedException
	{
		login=new loginTest(driver);
		boolean isLogoutFound= login.loginpage("upparbawades94@gmail.com","SHI1996v@123");
		Assert.assertEquals(isLogoutFound,true);
		boolean loginbutton=login.isloginbuttondisplayed();
		Assert.assertTrue(loginbutton);
		if(loginbutton==true)
		{
		login.btnlogin.click();
	}
		
	}
	
	
	
	
}
	
	
	
	
	


