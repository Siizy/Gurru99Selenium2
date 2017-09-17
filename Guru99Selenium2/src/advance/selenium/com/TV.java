package advance.selenium.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TV {
	
	WebDriver driver;
	 
	 public TV(WebDriver driver){		 
		 this.driver = driver;
	 }
	 
	 public MyWishList select_a_Tv(String tv){
		 driver.findElement(By.xpath("//a[@title='"+tv+"']/parent::li//a[text()='Add to Wishlist']")).click();		 
		 return new MyWishList(driver);
	 }

}
