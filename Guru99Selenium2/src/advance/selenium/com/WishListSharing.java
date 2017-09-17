package advance.selenium.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListSharing {

	WebDriver driver;
	 
	 public WishListSharing(WebDriver driver){		 
		 this.driver = driver;
	 }
	 
	 public WishListSharing Enter_email(String email){
		 driver.findElement(By.id("email_address")).sendKeys(email);
		 return this;
	 }
	 
	 public WishListSharing Enter_message(String message){
		 driver.findElement(By.id("message")).sendKeys(message);
		 return this;
	 }
	 
	 public MyWishList share_wishlist(){
		 driver.findElement(By.xpath("//*[text()[contains(.,'Share Wishlist')]]")).click();
		return new MyWishList(driver); 
	 }
	 
}
