package com.unicorn;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class UnicornExecute {
			
	@Test
	public  void  launch_browser() {	  
		  WebDriver driver;			  		  
		  System.setProperty("webdriver.chrome.driver", "D:/Letsjava/workspace/LearnPom/chromedriver.exe");
		  driver= new ChromeDriver();		  		   
		  WebDriverWait wait=new WebDriverWait(driver, 20);
		  System.out.println("Browser Launched with driver id : " + driver);
		  driver.manage().window().maximize();		  
		  driver.get("http://10.2.138.25/Unicorn");			  
		  driver.findElement(By.id("userid")).sendKeys("101453");
		  driver.findElement(By.id("password")).sendKeys("abc@123");
		  driver.findElement(By.id("loginbtn")).click();		  		  		  		  
		  driver.findElement(By.xpath("//*[text()='Test Design']")).click();		  	  
		  WebElement hi= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[text()='Test Cases']")));
		  hi.click();			  
		  driver.findElement(By.xpath(".//*[@id='tssearchtxt2']")).sendKeys("DrawAudit.TestScenarios.Admin.ValidationTemplate.AddColumnValidationConfiguration");		 
		  String selectAll = Keys.chord(Keys.TAB);
		  driver.findElement(By.xpath(".//*[@id='tssearchtxt2']")).sendKeys(selectAll);
		  //selectAll = Keys.chord(Keys.ENTER);
		  //driver.findElement(By.xpath(".//*[@id='tssearchbtn2']")).sendKeys(selectAll);
		  driver.findElement(By.xpath(".//*[@id='tssearchbtn2']")).click();
		  JavascriptExecutor js1 = (JavascriptExecutor) driver;
		  js1.executeScript("document.body.style.zoom='80%'");
		  driver.findElement(By.xpath(".//*[@id='tcname']")).sendKeys("Ola I am adding a new testcases");;
		  
		  JavascriptExecutor javascriptExecutor= (JavascriptExecutor)driver;		  
		  System.out.println("Domain name: " + js1.executeScript("return document.domain"));
		  		  
	     }	
	  

}
