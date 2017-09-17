package advance.selenium.com;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Mobilepage {

	WebDriver driver;
	String expected_pagetitle = "Mobile";
	List<String> items  = new ArrayList<String>();
	List<String> rawproducts  = new ArrayList<String>();
	
	public Mobilepage(WebDriver driver){
		this.driver = driver;
	
	}
	
	public Mobilepage verify_pagetitle() {
		System.out.println("verify_pagetitle : "+driver);
		String actual_title = driver.getTitle();
		Assert.assertEquals(actual_title, expected_pagetitle);
		return this;
	}
	
	public String costof(String product){
		String productcost = driver.findElement(By.xpath("//a[text()='" +product+ "']//following::span[@class='price']")).getText();		
		return productcost;
	}
	
	public SonyXperia select_product(String product ){
		driver.findElement(By.xpath("//a[@title='"+product+"']")).click();		
		return new SonyXperia(driver);
	}
	
	public ShoppingCart AddtoCart(String product){		
		driver.findElement(By.xpath("//a[@title='"+product+"']/../following-sibling::div/button[@title='Add to Cart']")).click();;
		return new ShoppingCart(driver);
	}
	
	public Mobilepage SortBy(String element) {
		System.out.println("SortBy : "+driver);
		Select sortby = new Select(driver.findElement(By.xpath(".//select[@title='Sort By']")));
		sortby.selectByVisibleText(element);
		return this;	
	}
	
	
	public Mobilepage GetallProducts_name() {
		System.out.println("GetallProducts_name: "+driver);
	    List<WebElement> products = driver.findElements(By.xpath(".//*[@class='product-name']"));	    	    
	    for(int i = 0;i<products.size();i++ ){	    	
	    	items.add(products.get(i).getText());
	    }	
	    rawproducts = items;
		return this;				
	}
	
	public Mobilepage SortProducts() {		
		System.out.println("SortProducts: "+driver);
		Collections.sort(items);		
		return this;
	}	
	
	public Mobilepage verifySorting(){
		System.out.println("verifySorting: "+driver);
		for(int p = 0; p<items.size(); p++){
			System.out.println(items.get(p)+"::" + rawproducts.get(p));
			Assert.assertEquals(items.get(p), rawproducts.get(p));			
		}
		
		return this;
	}
	
	public Mobilepage AddtoCompare(List<String> Addproducts2compare) throws InterruptedException{
		//Iterator<String> iterator = Addproducts2compare.iterator();
		for(int i=0; i<Addproducts2compare.size();i++){		
			  System.out.println(i +"."+ "Selected product for comparison is " +" :"+ Addproducts2compare.get(i));
			  driver.findElement(By.xpath("//div[@class='product-info']//a[@title='"+Addproducts2compare.get(i)+"']/ancestor::div[1]//a[text()='Add to Compare']")).click();	
			  Thread.sleep(2000);
			}
				
		return this;	
	}
	
	public Mobilepage Compare(List<String> products2compare) throws Exception{
		driver.findElement(By.xpath("//button[@title='Compare']")).click();
		Thread.sleep(3000);
		String mainWindowHandle=driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		System.out.println("total windows :"+s.size());
		for (String popup : s){		
			driver.switchTo().window(popup);
			if(driver.getTitle().contains("Product Comparison")){				
				break;
			}			
		}		
		
		for(int j=0; j<products2compare.size();j++){	
			System.out.println(j+"."+"product to find "+ products2compare.get(j));
			Assert.assertEquals(driver.findElement(By.xpath("//td/a[@title='"+products2compare.get(j)+"']")).isDisplayed(), true);
		}
		driver.close();
		System.out.println("Switching back to main window");
		driver.switchTo().window(mainWindowHandle);
			
		return this;	
	}
	
}

