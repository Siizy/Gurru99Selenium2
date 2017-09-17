package advance.selenium.com;


import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;




public class OpenBrowser {
	
	WebDriver driver;
	
	public WebDriver launch_Browser(String browser)
	{
		switch (browser) {
		case "firefox":	
			System.setProperty("webdriver.gecko.driver", "D:/Letsjava/workspace/LearnPom/geckodriver.exe");			
			driver=  new FirefoxDriver();
			//log.info("Firefox is launched");
			break;
			
		case "Chrome":	
			//System.setProperty("webdriver.chrome.driver", "D:/Letsjava/workspace/LearnPom/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "D:/Letsjava/workspace2/drivers/chromedriver.exe");			
			driver = new ChromeDriver();
			break;
			
		case "IE":	
			System.setProperty("webdriver.ie.driver", "D:/Letsjava/IEDriverServer.exe");	
			driver = new InternetExplorerDriver();
			break;
			
		default:
			break;
		}
		
		return driver;
	}
	
	public void Add_Wait(int timeToWaitInSeconds){
		System.out.println("Adding a wait of :"+ timeToWaitInSeconds +"for each webelement before it throws error");
		driver.manage().timeouts().implicitlyWait(timeToWaitInSeconds, TimeUnit.SECONDS);
	}

}
