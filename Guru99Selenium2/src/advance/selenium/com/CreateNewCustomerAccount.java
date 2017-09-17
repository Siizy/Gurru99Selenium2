package advance.selenium.com;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateNewCustomerAccount {
	
	WebDriver driver;
	 
	 public CreateNewCustomerAccount(WebDriver driver){
		 
		 this.driver = driver;
	 }
	 
	   
	 public MyAccount Register(List<String> acc_info){
		 
		 driver.findElement(By.xpath("//input[@title='First Name']")).sendKeys(acc_info.get(0));
		 driver.findElement(By.xpath("//input[@title='Last Name']")).sendKeys(acc_info.get(1));
		 driver.findElement(By.xpath("//input[@title='Password']")).sendKeys(acc_info.get(2));
		 driver.findElement(By.xpath("//input[@title='Confirm Password']")).sendKeys(acc_info.get(3));
		 driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys(acc_info.get(4));
		 driver.findElement(By.xpath("//button[@title='Register']")).click();		 
		 return new MyAccount(driver);
	 }
	

}
