package Ecommerce.com;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Ecommerce.Test.SerachFunction;
import Ecommerce.Test.setup;

public class SerachFunctionRunner extends setup {
	
	SerachFunction search;
	
	
	@Test(priority = 1,description = "user check searchicon is prent or not")
	public void searchiconispresentornot()
	{
		search=new SerachFunction(driver);
		boolean searchicon= search.searciconispresntornot();
		Assert.assertTrue(searchicon);
	
	}
@Test(priority = 2,description = "test blank search")
public void emptysearchproduct() throws InterruptedException
{
	 search=new SerachFunction(driver);
	search.emptysearchtest(" ");
	
}
@Test(priority = 3,description = "user test invalid search product")
public void invalidsearchproduct() throws InterruptedException
{
	 search=new SerachFunction(driver);
	 String validationmessage= search.invalidsearchtest("efrfrfs");
	System.out.println( validationmessage.contains("No products were found that matched your criteria."));
	 Assert.assertTrue(validationmessage.contains("No products were found that matched your criteria."));
	 
}
@SuppressWarnings("unused")
@Test(priority = 4,description = "user test valid search product")
public void validsearchproduct() throws InterruptedException
{
	 search=new SerachFunction(driver);
	 search.validsearchproduct("Cell Phones");
	 WebElement filteredElement= search.products.stream()
     .filter(element -> element.getText().contains("HTC One Mini Blue"))  // Filtering condition
     .findFirst()  // Get the first matching element
     .orElse(null);  // Return null if no matching element is found
	String particulatext= filteredElement.getText();
	Assert.assertTrue(true, filteredElement.getText());

if (filteredElement != null) {

System.out.println( filteredElement.getText());
filteredElement.click();
} else {
System.out.println("No element matching the condition found.");
}

}
@Test(priority = 5,description = "user validate searchproduct and display product")
public void verifyproductdetails()
{
	search=new SerachFunction(driver);
	String descriptionmessage= search.productdescriptiondetails.getText();
	System.out.println(descriptionmessage);
	Assert.assertTrue(descriptionmessage.contains("HTC One mini smartphone with 4.30-inch 720x1280 display powered by 1.4GHz processor alongside 1GB RAM and 4-Ultrapixel rear camera."));
	@SuppressWarnings("unused")
	String pricemessage= search.productpricedetails.getText();
	System.out.println(pricemessage);
	Assert.assertTrue(pricemessage.contains("$100.00"));
	String namemessgae= search.productnamedeails.getText();
	System.out.println(namemessgae);
	Assert.assertTrue(namemessgae.contains("HTC One Mini Blue"));
	
	}

}
