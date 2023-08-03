package Ecommerce.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class ExcelUtilsTest {
	WebDriver driver;
	DataFormatter formatter=new DataFormatter();
	
public ExcelUtilsTest(WebDriver driver)
{
	this.driver=driver;
}

public void waitforelementobeappear(WebDriver driver)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement displayproduct= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='item-grid'] //div[@class='picture'] //img[@title='Show details for Apple MacBook Pro 13-inch']")));
	displayproduct.click();
	
	
	
}

public void scrollby()
{
	 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
     jsExecutor.executeScript("window.scrollBy(0, 500)");
}
@DataProvider(name= "exceldata")
public Object getdata(String filepah,String sheetname) throws IOException
{
	FileInputStream file=new FileInputStream(filepah);
	XSSFWorkbook workbook=new XSSFWorkbook(file);
	//get the sheetname
	XSSFSheet excelsheet= workbook.getSheet(sheetname);
	//get the physical no of rows in sheet
	int rowcount = excelsheet.getLastRowNum();
	int cellcount= excelsheet.getRow(rowcount).getLastCellNum();
	Object[][] data=new Object[rowcount-1][cellcount];
	for(int i=0;i<rowcount-1;i++)
	{
		XSSFRow row= excelsheet.getRow(i);
		for(int j=0;j<cellcount;j++)
		{
			XSSFCell cell= row.getCell(j);
			data[i][j]=formatter.formatCellValue(cell);
		}
	}
	return data;
	
	
	
}
}
