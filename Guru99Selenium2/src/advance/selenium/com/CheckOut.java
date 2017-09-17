package advance.selenium.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckOut {
	
	WebDriver driver;
	 
	 public CheckOut(WebDriver driver){		 
		 this.driver = driver;
	 }
	 
	 public CheckOut Add_BillingAddress(){
		 ShippingAddress shi_add = new ShippingAddress();
		 driver.findElement(By.id("billing:street1")).sendKeys(shi_add.Address);
		 driver.findElement(By.id("billing:city")).sendKeys(shi_add.City);
		 Select State = new Select(driver.findElement(By.id("billing:region_id")));		 
		 State.selectByVisibleText(shi_add.StateProvince);		 
		 driver.findElement(By.id("billing:postcode")).sendKeys(shi_add.Zip);
		 Select Country = new Select(driver.findElement(By.id("billing:country_id")));
		 Country.selectByVisibleText(shi_add.Country);		 
		 driver.findElement(By.id("billing:telephone")).sendKeys(shi_add.Telephone);	 
		 return this;
	 }
	 
	 public CheckOut Billing_Continue() throws InterruptedException {
		 driver.findElement(By.xpath("//button[@title='Continue' and @onclick='billing.save()']")).click();
		 Thread.sleep(3000);
		return this;
	}
	 
	 public CheckOut Shipping_Continue() throws InterruptedException {
		 driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']")).click();
		 Thread.sleep(3000);
		return this;
	}
	 public CheckOut Payment_Continue() throws InterruptedException {
		 driver.findElement(By.xpath("//button[@onclick='payment.save()']")).click();
		 Thread.sleep(3000);
		return this;
	}
	 
	 public CheckOut select_PaymentMethod(String method){
		 driver.findElement(By.xpath("//input[@title='"+method+"']")).click();
		 return this;
	 }
	 
	 public MagnetoCommerce select_PlaceOrder() throws InterruptedException{
		 driver.findElement(By.xpath("//button[@title='Place Order']")).click();
		 Thread.sleep(5000);
		 return new MagnetoCommerce(driver);
	 }
	 
	 

}
