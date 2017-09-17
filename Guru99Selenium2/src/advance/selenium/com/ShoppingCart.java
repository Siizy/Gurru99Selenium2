package advance.selenium.com;

import java.text.NumberFormat;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ShoppingCart {
	
	WebDriver driver;
	
	public ShoppingCart(WebDriver driver){
		this.driver = driver;	
	 }
	
	public ShoppingCart Update_Quantity(int quantity, String product) throws InterruptedException {
		 WebElement product_to_update = driver.findElement(By.xpath("//a[@title='"+product+"']/../following-sibling::td/input[@title='Qty']"));
		 product_to_update.click();
		 product_to_update.clear();
		 product_to_update.sendKeys(Integer.toString(quantity));
		 Thread.sleep(2000);
		 product_to_update = driver.findElement(By.xpath("//a[@title='"+product+"']/../following-sibling::td/button[@title='Update']"));
		 product_to_update.click();
   		return this;
	}
	
	public ShoppingCart verify_GrandTotal(int quantity, double price){
		String grandTotal = driver.findElement(By.xpath(".//*[text()='Grand Total']/../parent::tr//span[@class='price']")).getText();
		double total_price = quantity*price;
		String expected_grandTotal = NumberFormat.getNumberInstance(Locale.US).format(total_price);
		//Assert.assertEquals(grandTotal, expected_grandTotal);
		Assert.assertEquals(grandTotal, expected_grandTotal, "Hi the price has been updated");
		return this;
	}
	
	public ShoppingCart verifycart_error_msg(){
		String expected_msg = "The maximum quantity allowed for purchase is 500";
		String actual_msg = driver.findElement(By.xpath("//p[@class='item-msg error']")).getText();
		Assert.assertTrue(actual_msg.contains(expected_msg));
 		return this;
	}
	
	public ShoppingCart empty_cart(){		
		driver.findElement(By.xpath("//button[@title='Empty Cart']")).click();
		String expt_msg = "SHOPPING CART IS EMPTY";
		String act_msg = driver.findElement(By.xpath("//*[text()='Shopping Cart is Empty']")).getText();
		Assert.assertEquals(act_msg, expt_msg);
 		return this;
	}
	
	public CheckOut ProceedtoCheckOut(){
		driver.findElement(By.xpath("//a[@title='Checkout with Multiple Addresses']/../parent::ul//button[@title='Proceed to Checkout']")).click();
		return new CheckOut(driver);
	}
	
	public ShoppingCart Add_ShippingAddress(String country,String state, String zip) {
		Select Country = new Select(driver.findElement(By.xpath("//select[@title='Country']")));
		Country.selectByVisibleText(country);
		Select State = new Select(driver.findElement(By.xpath("//select[@title='State/Province']")));		
		State.selectByVisibleText(state);
		driver.findElement(By.id("postcode")).sendKeys(zip);		
		return this ; 
	}
	
	public ShoppingCart Estimate() throws InterruptedException {
		driver.findElement(By.xpath("//button[@title='Estimate']")).click();		
		return this;
	}
	
	public ShoppingCart add_Shipping_cost(){
		driver.findElement(By.xpath("//li/input[@class='radio']")).click();		
		driver.findElement(By.xpath("//button[@title='Update Total']")).click();
		return this;
	}
	
	public ShoppingCart verify_ifShippingCostisApplied() {
		Assert.assertEquals(driver.findElement(By.xpath("//*[text()[contains(.,'Shipping & Handling (Flat Rate - Fixed)')]]/../parent::tbody//span[text()='$5.00']")).isDisplayed(), true);
		return this;
	}

} 
