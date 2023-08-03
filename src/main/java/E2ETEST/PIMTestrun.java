package E2ETEST;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMTestrun {
	WebDriver driver;
	
	public PIMTestrun(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//	@FindBy(xpath="//div[@class='oxd-sidepanel-body']  //ul[@class='oxd-main-menu'] //a[.='PIM']")
//	WebElement pimbuton;

//	public void mouseoveronPim()
//	{
//		pimbuton.click();
//		}
	@FindBy(xpath="//nav[@role='navigation'] //a[normalize-space()='Add Employee']")
	WebElement addemployee;
	
	
    @FindBy(css = "[name=firstName]")
	 WebElement FirstNametext;
	@FindBy(css = "[name=lastName]")
	 WebElement LastNametext;
    @FindBy(className = "oxd-input")
	 List<WebElement> EmployeeIdtext;
	@FindBy(className = "oxd-switch-input")
	  WebElement Togglebutton;
	@FindBy(tagName = "input")
	  List<WebElement> UserNametext;
	  @FindBy(tagName = "input")
	  List<WebElement> Passwordtext;
	 @FindBy(tagName = "input")
	  List<WebElement> ConfirmPasswordtext;
	 @FindBy(css = "[type=submit]")
	  WebElement Submitbutton;
	 
	 @FindBy(xpath="//nav[@role='navigation'] //a[normalize-space()='Employee List']")
	 WebElement employeelistbutton;
	 @FindBy(css = "[type=submit]")
	    public WebElement Submit;
	
	 @FindBy(tagName = "input")
	    public List<WebElement> txtSearchEmpName;
	    @FindBy(tagName = "button")
	    public List<WebElement> btnUpdateEmployee;
	    @FindBy(className = "oxd-input")
	    public List<WebElement> txtUpdateEmployeeId;


		public Object Firstnametext;
	    
	    public void employeelist1()
	    {
	    	employeelistbutton.click();
	    }
	 public void clickonaddemployee()
	 {
		 addemployee.click(); 
	 }
	
	 public void createEmployee(String firstname, String lastname, String username, String password) throws InterruptedException {
		
		   
	        FirstNametext.sendKeys(firstname);
	        LastNametext.sendKeys(lastname);
	        WebElement empID = EmployeeIdtext.get(4);
	        Thread.sleep(1000);
//	        empID.clear();
//	        empID.sendKeys(Keys.CONTROL + "a");
//	        empID.sendKeys(employeeId);
	        Thread.sleep(1000);
	        Togglebutton.click();
	        UserNametext.get(7).sendKeys(username);
	        Passwordtext.get(10).sendKeys(password);
	        ConfirmPasswordtext.get(11).sendKeys(password);
	        Thread.sleep(1500);
	        Submitbutton.click();
	    }
	  public void SearchEmployeeByInvalidName(String employeeName) throws InterruptedException {
	        txtSearchEmpName.get(1).sendKeys(employeeName);
	        Thread.sleep(1500);
	        Submit.click();
	    }
	    public void SearchEmployeeByValidName(String employeeName) throws InterruptedException {
	        txtSearchEmpName.get(1).sendKeys(employeeName);
	        Thread.sleep(1500);
	        Submit.click();
	    }
		

}
