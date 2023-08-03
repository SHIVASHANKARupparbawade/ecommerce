package E2ETEST;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class ExcelUtils {
	WebDriver driver;
	public void scrollby()
	{
		JavascriptExecutor ja= (JavascriptExecutor)driver;
		ja.executeScript("window.scrollBy(0,500)");
	}
	
	
     @DataProvider(name="logindata")
     
	  public static Object[][] readTestData(String filePath, String sheetName) {
	        try (FileInputStream fis = new FileInputStream(filePath);
	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	            XSSFSheet sheet = workbook.getSheet(sheetName);
	            int rowCount = sheet.getLastRowNum();
	            int colCount = sheet.getRow(0).getLastCellNum();
	            Object[][] data = new Object[rowCount][colCount];

	            for (int i = 0; i < rowCount; i++) {
	                XSSFRow row = sheet.getRow(i + 1); // Skip header row (i + 1)
	                for (int j = 0; j < colCount; j++) {
	                    Cell cell = row.getCell(j);
	                    data[i][j] = cell.toString();
	                }
	            }
	            return data;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	        
	    }
     @DataProvider(name="searchdata")
     
	  public static Object[][] searchdata(String Path, String Name) {
	        try (FileInputStream fis = new FileInputStream(Path);
	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	            XSSFSheet sheet = workbook.getSheet(Name);
	            int rowCount = sheet.getLastRowNum();
	            int colCount = sheet.getRow(0).getLastCellNum();
	            Object[][] data = new Object[rowCount][colCount];

	            for (int i = 0; i < rowCount; i++) {
	                XSSFRow row = sheet.getRow(i + 1); // Skip header row (i + 1)
	                for (int j = 0; j < colCount; j++) {
	                    Cell cell = row.getCell(j);
	                    data[i][j] = cell.toString();
	                }
	            }
	            return data;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	        
	    }
}
    
