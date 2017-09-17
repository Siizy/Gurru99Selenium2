package advance.selenium.com;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.sun.jna.platform.unix.X11.Atom;

public class Test {
	
	 WebDriver driver;
	 HomePage hPage;
	 
	 
	 
	 
	
	public static void main(String [] args) {
		
		//hPage = new HomePage(driver);
		
		ArrayList<Object> at = new ArrayList<Object>();
		at.add(0, "sdjf");
		at.add(1, 2);
		at.add(2, "element");
		
		System.out.println(at.get(2));
	}

}
