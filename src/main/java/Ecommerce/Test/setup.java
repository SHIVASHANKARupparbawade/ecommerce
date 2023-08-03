package Ecommerce.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class setup {
	protected WebDriver driver;
	
	@BeforeTest
	public void BaseTest()
	{
		String browser= "chrome";
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println("successfully launch chrome browser");
		}
		else if(browser.equalsIgnoreCase("fierfox"))
		{
		 driver=new FirefoxDriver();
		}
		else
		{
			throw new IllegalArgumentException("Invalid browser name provided");
		}
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.navigate().refresh();
	}
	
//	@AfterTest
//	public void teardown()
//	{
//		driver.close();
//	}

}
