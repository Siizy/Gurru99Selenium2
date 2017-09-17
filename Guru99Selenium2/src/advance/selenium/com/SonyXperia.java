package advance.selenium.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SonyXperia {
	
	WebDriver driver;
	
	public SonyXperia(WebDriver driver){
		this.driver = driver;
	}
	
	public String get_price() {
		String price = driver.findElement(By.xpath("//span[@class='price']")).getText();
		return price;
		
	}

	
}
