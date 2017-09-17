package advance.selenium.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyWishList {
	
	WebDriver driver;
	 
	 public MyWishList(WebDriver driver){		 
		 this.driver = driver;
	 }
	 
	 public WishListSharing share_wishlist(){
		 driver.findElement(By.xpath("//*[text()[contains(.,'Share Wishlist')]]")).click();
		return new WishListSharing(driver); 
	 }
	 
	 public MyWishList verify_wishlist_share(){
		 Assert.assertEquals(driver.findElement(By.xpath("//*[text()[contains(.,'Your Wishlist')]]")).getText(), "Your Wishlist has been shared.");
		 return this;
	 }
	 
	 public ShoppingCart AddtoCart(String product) {
		driver.findElement(By.xpath("//a[@title='"+ product +"']/../parent::tr//button[@title='Add to Cart']")).click();
		return new ShoppingCart(driver);
	}
}

