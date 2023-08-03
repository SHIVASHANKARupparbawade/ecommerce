package Ecommerce.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SerachFunction extends ExcelUtilsTest {
	protected WebDriver driver;
	public SerachFunction(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='small-searchterms']")
	public WebElement searchtext;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	public WebElement searchicon;
	
	@FindBy(xpath="//div[@class='no-result']")
	public WebElement invalidsearchmessage;
	
	
	@FindBy(xpath="//div[@class='products-container']")
	public List<WebElement> products;
	
	@FindBy(xpath="//div[@class='full-description']")
	public WebElement productdescriptiondetails;
	@FindBy(xpath="//span[@id='price-value-19']")
	public WebElement productpricedetails;
	
	@FindBy(xpath="//h1[normalize-space()='HTC One Mini Blue']")
	public WebElement productnamedeails;
	
	
	public boolean searciconispresntornot()
	{
		return searchicon.isDisplayed();
	}
	
	public void emptysearchtest(String product) throws InterruptedException
	{
		searchtext.clear();
		searchtext.sendKeys(product);
		Thread.sleep(3000);
		searchicon.sendKeys(Keys.ENTER);
	}
	public String alertaccept()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		return alert.getText();
		
	}
	public String invalidsearchtest(String product) throws InterruptedException
	{
		searchtext.clear();
		searchtext.sendKeys(product);
		Thread.sleep(3000);
		searchicon.sendKeys(Keys.ENTER);
		return invalidsearchmessage.getText();
	}
	public List<WebElement> validsearchproduct(String product) throws InterruptedException
	{
		searchtext.clear();
		searchtext.sendKeys(product);
		Thread.sleep(3000);
		searchicon.sendKeys(Keys.ENTER);
		return products;
		
	}
	
	
	
	
	
	

}
