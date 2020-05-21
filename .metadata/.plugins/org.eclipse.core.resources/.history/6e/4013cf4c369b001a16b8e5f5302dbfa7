package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Mousehover {
	
	public static void main(String[] args) throws InterruptedException
	{
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\Santhosh\\Desktop\\geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	//Sleeper.sleepTightInSeconds(7);
	driver.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.xpath(".//*[@id='btnLogin']")).click();
	//Sleeper.sleepTightInSeconds(4);
	
	Actions act=new Actions(driver);
	Thread.sleep(4000);
	
	act.moveToElement(driver.findElement(By.xpath(".//*[@id='menu_leave_viewLeaveModule']"))).build().perform();
	Thread.sleep(4000);
	act.moveToElement(driver.findElement(By.xpath("//*[@id='menu_leave_Reports']"))).build().perform();
	//act.moveToElement(driver.findElement(By.partialLinkText("Reports"))).build().perform();
	//Thread.sleep(3000);
	//act.moveToElement(driver.findElement(By.partialLinkText("Leave Entitlements and Usage Report"))).build().perform();;
	//	Sleeper.sleepTightInSeconds(4);
	//act.moveToElement(driver.findElement(By.id("menu_leave_Reports"))).build().perform();
	//Sleeper.sleepTightInSeconds(4);
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@id='menu_leave_viewLeaveBalanceReport']")).click();
	//driver.findElement(By.xpath(".//*[@id='menu_leave_viewLeaveModule']/b")).click();
	
	//*[@id="menu_leave_Reports"]
	
	
	
	
	
	//driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]")).click();
	
	/*
Sleeper.sleepTightInSeconds(4);
    Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"))).build().perform();
	 Sleeper.sleepTightInSeconds(5);
  act.moveToElement(driver.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]/span[6]/span"))).build().perform();
    Sleeper.sleepTightInSeconds(5);
// driver.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[3]/div[6]/div[1]/div/a[1]/span[1]")).click();
    driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]")).click();
	*/
		
	}

}
