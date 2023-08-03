package PIMTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	protected WebDriver driver;
	@BeforeTest
	public void setup()

	{
		 String browser="chrome";
		 if(browser.equalsIgnoreCase("chrome"))
		 {
			 driver=new ChromeDriver();
			 System.out.println("successfully launched chrome browser");
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
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.navigate().refresh();
		 driver.manage().deleteAllCookies();
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
