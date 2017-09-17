package advance.selenium.com;


import java.util.ArrayList;
import java.util.List;

import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExecuteTest {
	
	WebDriver driver;	
	Mobilepage mp;
	HomePage hp;
	
  @BeforeMethod
  public void  launch_browser() {	  
	  OpenBrowser browser = new OpenBrowser();
	  this.driver = browser.launch_Browser("firefox");
	  driver = browser.launch_Browser("firefox");
	  System.out.println("Browser Launched with driver id : " + driver);
	  driver.manage().window().maximize();
	  driver.get("http://live.guru99.com/");
	  hp = new HomePage(driver);
	  mp = new Mobilepage(driver);
	  
     }	
  
  
  //Verify items in Mobile List page can be sorted by Name
  @Test (priority = 0) 
  public void Day1() {
	hp = new HomePage(driver);	
	hp.verify_title().select_MOBILEmenu().verify_pagetitle().SortBy("Name").GetallProducts_name().SortProducts().verifySorting();	
   }
  
  //Verify that cost of product in list page and details page are equal 
  @Test (priority = 1)
  public void Day2(){
	  
	  String grid_cost = hp.select_MOBILEmenu().costof("Sony Xperia");
	  System.out.println("grid_cost : " + grid_cost);
	  String page_cost = mp.select_product("Sony Xperia").get_price();
	  System.out.println("page_cost : " + page_cost);
	  Assert.assertEquals(page_cost, grid_cost);	
	 // boolean t = driver.findElement(By.xpath("")).isDisplayed();
  }
  
  //verify that you cannot add more products than the product available in store
  @Test (priority = 2)
  public void Day3() throws Throwable {
	 hp.select_MOBILEmenu().AddtoCart("Sony Xperia").Update_Quantity(1000, "Sony Xperia").verifycart_error_msg().empty_cart();	  
  }
  
   @Test (priority = 3)
  public void Day4() throws Exception{
	  
	  List<String> products2compare = new ArrayList<String>();
	  products2compare.add("Samsung Galaxy");
	  products2compare.add("Sony Xperia");
	  
	  hp.select_MOBILEmenu().AddtoCompare(products2compare).Compare(products2compare);
  }
  
  @Test (priority = 4)
  public void Day5() throws Exception{
	  
	  List<String> user_data = new ArrayList<String>();
	  user_data.add("Chandan");
	  user_data.add("Gupta");
	  user_data.add("password@1");
	  user_data.add("password@1");
	  user_data.add("chandangupta12@gmail.com");
	  
	  hp.click_Account().click_CreateAnAccount().Register(user_data).verify_Registration().select_TVmenu().select_a_Tv("LG LCD").
	  share_wishlist().Enter_email("sizy@test.com").Enter_message("Hi I just bought a tv").share_wishlist().verify_wishlist_share();
	  
  }
  
 @Test(priority = 5)
  public void Day6() throws InterruptedException {
	  ShippingAddress sp = new ShippingAddress() ;	 	  
	  hp.click_Account().Login("chandangupta12@gmail.com", "password@1").click_My_WishList().AddtoCart("LG LCD").Add_ShippingAddress(sp.Country,sp.StateProvince,sp.Zip).Estimate().add_Shipping_cost().verify_ifShippingCostisApplied().
	  ProceedtoCheckOut().Add_BillingAddress().Billing_Continue().Shipping_Continue().select_PaymentMethod("Check / Money order").Payment_Continue().select_PlaceOrder().verify_ifOrderisplaced();
	  String OrderNumber = driver.findElement(By.xpath("//*[text()[contains(.,'Your order #')]]/a")).getText();
	  System.out.println("Order# " + OrderNumber );
  }
  	    
  @Test(priority = 6)
  public void Day7()throws  InterruptedException {
	 hp.click_Account().Login("chandangupta11@gmail.com", "password@1").click_My_Orders().click_ViewOrder("100002760").click_PrintOrder();
  }
  
   @Test(priority = 7)
  public void Day8() throws InterruptedException{
	  hp.click_Account().Login("chandangupta11@gmail.com", "password@1").click_Reorder("100002760").Update_Quantity(10, "LG LCD").verify_GrandTotal(10, 615.45);
	  //Assert.assertNotEquals("100", "900");
	  
	   
  }
          
  @AfterMethod
	public void closeBrowser(){
		driver.close();
		System.out.println("Browser closed");
	}
}
