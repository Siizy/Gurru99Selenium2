package advance.selenium.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerLogin {
	
	WebDriver driver;
	 
	 public CustomerLogin(WebDriver driver){
		 
		 this.driver = driver;
	 }
	
	 public CreateNewCustomerAccount click_CreateAnAccount() {
		driver.findElement(By.xpath("//a[@class='button' and @title='Create an Account']")).click();		 
		 return new CreateNewCustomerAccount(driver);
	}
   
	public MyAccount Login(String username, String password) {
		driver.findElement( By.id("email")).sendKeys(username);
		driver.findElement( By.id("pass")).sendKeys(password);
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		return new MyAccount(driver);
	}

	 
}
