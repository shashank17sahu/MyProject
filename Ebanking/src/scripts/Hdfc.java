package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hdfc {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\Santhosh\\Desktop\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
	   // driver.switchTo().defaultContent();
	  driver.switchTo().frame("login_page");
       driver.findElement(By.className("input_password")).sendKeys("12345678");

	}

}
