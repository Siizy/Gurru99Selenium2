package advance.selenium.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
	
 WebDriver driver;
 
 public HomePage(WebDriver driver){
	 
	 this.driver = driver;
 }
	
 public static String homepage_title = "Home page";
 public static String Mobile_xpath = ".//*[text()[contains(.,'Mobile')]]"; 
 public static String Tv_xpath = ".//*[text()[contains(.,'TV')]]"; 
 By Mobile = By.xpath(Mobile_xpath);
 By Tv = By.xpath(Tv_xpath);
 
 public HomePage verify_title() {
    String page_title = driver.getTitle();
    Assert.assertEquals(page_title, homepage_title);
    return this;
}
   
   public Mobilepage select_MOBILEmenu()
   {
	   driver.findElement(Mobile).click();	
	   return new Mobilepage(driver);
   }
   
   public TV select_TVmenu()
   {
	   driver.findElement(Tv).click();	
	   return new TV(driver);
   }
   
   public CustomerLogin click_Account(){
	   driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();	   
	   return new CustomerLogin(driver);
   }
   
   
   
}
