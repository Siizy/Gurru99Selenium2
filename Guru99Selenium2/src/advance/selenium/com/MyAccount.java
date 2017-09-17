package advance.selenium.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyAccount {

	WebDriver driver;
	 
	 public MyAccount(WebDriver driver){		 
		 this.driver = driver;
	 }
	 
	 public MyAccount verify_Registration() {
	     Assert.assertEquals(driver.findElement(By.xpath("//span[text()[contains(.,'Thank you')]]")).getText(), "Thank you for registering with Main Website Store.");	     
		 return this;
	}
	 
	 public TV select_TVmenu()
	   {
		   driver.findElement(By.xpath(".//*[text()[contains(.,'TV')]]")).click();	
		   return new TV(driver);
	   }
	   
	public MyWishList click_My_WishList() {
		driver.findElement(By.xpath("//li/a[text()='My Wishlist']")).click();
		return  new MyWishList(driver);
		
	}
	
	public MyAccount click_My_Orders() {
		driver.findElement(By.xpath("//*[text()='My Orders']")).click();
		return  this;
	} 
	
	public MyAccount verify_IsOrderDisplayed(String order_number) {
		Assert.assertEquals(driver.findElement(By.xpath("//div/table//td[text()='"+order_number+"']")).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath("//div/table//td[text()='"+order_number+"']//following-sibling::td/em")).getText(), "Pending");
		return this;
	}
	
	public MyAccount click_ViewOrder(String order_number){
		driver.findElement(By.xpath("//div/table//td[text()='"+order_number+"']//following-sibling::td//a[text()='View Order']")).click();
		return this;
	}
	
	public MyAccount click_PrintOrder(){
		driver.findElement(By.xpath("//a[text()='Print Order']")).click();
		return this;
	}
	
	public ShoppingCart click_Reorder(String order_number){
		driver.findElement(By.xpath("//tbody//tr//td[text()='"+order_number+"']/following-sibling::td//a[text()='Reorder']")).click();;
		return new ShoppingCart(driver);
	}
}
