package PIMModule.Test;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import E2ETEST.ExcelUtils;
import E2ETEST.LoginPageTest;
import E2ETEST.PIMTestrun;
import E2ETEST.logoutpage;
import PIMTest.BaseTest;

public class E2ETesting extends BaseTest{
	//login with invalid credentials
	 @Test(priority = 1,description = "user do login with invalid credentials")
	    public void logintestwithinvalidcred() throws InterruptedException
	    {
	    	LoginPageTest login1=new LoginPageTest(driver);
	    	String actualresult= login1.TestLoginWithInvalidCreds("admin", "wrongpassword");
	    	String expectedresult= "Invalid credentials";
	    	Assert.assertTrue(actualresult.contains(expectedresult));
	    	Thread.sleep(3000);
	    	
	    }
	//login with credentials
	    @Test(priority = 2,description = "user do login with valid cred")
	    public void loginTest() throws InterruptedException {
	        LoginPageTest login=new LoginPageTest(driver);
	        login.TestLogin("admin", "admin123");
	       
	    }
	    //click on add employee button
	   @Test(priority = 3,description = "user click on add employee button")
	   public void addemp() throws InterruptedException
	   {
		   driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
	    	  Thread.sleep(2000);
	    	PIMTestrun pim=new PIMTestrun(driver);  
	    	pim.clickonaddemployee();
	   }
	   
	    //add 3 employees in employee page
	    @DataProvider(name = "readTestData")
	    public Object[][] employeedata() throws IOException {
	    	
	 
	    	
	        String excelFilePath = "C:\\Users\\shivs\\Downloads\\addemployee.xlsx";
	        String sheetName = "Sheet1";
	        return ExcelUtils.readTestData(excelFilePath, sheetName);
	    }
	    
	    @Test(priority = 4,dataProvider  = "readTestData")
	    public void createemployee(String firstname,String lastname,String username,String password) throws InterruptedException
	    {
	    	 
	    	PIMTestrun pim=new PIMTestrun(driver);
	    	pim.clickonaddemployee();
	    	
	    	 
	    	pim.createEmployee(firstname, lastname, username, password);
	    	
	    	Thread.sleep(2000);
	    }
	    //click on employee list page
	    @Test(dependsOnMethods = "createemployee")
	    public void employeelistclick() throws InterruptedException
	    {
	    	PIMTestrun pim=new PIMTestrun(driver);
	    	pim.employeelist1();
	    	Thread.sleep(2000);
	    }
	    @DataProvider(name="searchdata")
	    public Object[][] searchemployee()
	    {
	    	String Path = "C:\\Users\\shivs\\Downloads\\a.xlsx";
	        String Name = "search employee";
	        return ExcelUtils.readTestData(Path, Name);
	       
	    }
	    
	   
	    
	    
	   //searching employee with valid name
	    @Test(priority = 5, description = "Searching with Valid Employee's name",dataProvider = "searchdata")
	    public void searchEmployeeByName(String employeename) throws IOException, InterruptedException  {
	        
	    	
           PIMTestrun pim= new PIMTestrun(driver);
           pim.txtSearchEmpName.get(1).sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
           
           
	        pim.SearchEmployeeByValidName(employeename);
	        
	        
	        Thread.sleep(7000);
	        
	     WebElement getemployee=   driver.findElement(By.xpath("//div[@class='oxd-table-body']"));
	     System.out.println( getemployee.getText());
	     
	     
	     
	     

	        //Assertion
	     String expectedresult= driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']")).getText();
	     String actualresult= "(1) Record Found";
	     Assert.assertTrue(expectedresult.contains(actualresult));
	     
	    }
	    //logout the employee
	    @Test(priority = 10,description = "Admin Logout Successfully")
	    public void logOut() {
	        logoutpage logout = new logoutpage(driver);
	        logout.doLogout();
	       
	    }
	    
	}

