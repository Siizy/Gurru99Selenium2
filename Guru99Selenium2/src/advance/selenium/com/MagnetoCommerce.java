package advance.selenium.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MagnetoCommerce {
	
	WebDriver driver;
	 
	 public MagnetoCommerce(WebDriver driver){
		 
		 this.driver = driver;
	 }
	 
	 public MagnetoCommerce verify_ifOrderisplaced(){
		 Assert.assertEquals(driver.findElement(By.xpath("//*[text()[contains(.,'Your order has')]]")).getText(), "YOUR ORDER HAS BEEN RECEIVED.");
		 return this;
	 }
	 
	 
}
