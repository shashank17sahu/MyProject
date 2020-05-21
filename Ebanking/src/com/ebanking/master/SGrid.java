package com.ebanking.master;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SGrid 
{
	DesiredCapabilities Cap=null;
	@Parameters("browser")
	@Test
	public void gd(String Br) throws MalformedURLException 
	{
		if (Br.equalsIgnoreCase("firefox"))
		{
			Cap=new  DesiredCapabilities();
			Cap.setBrowserName("firefox");
			Cap.setPlatform(Platform.WINDOWS);
		}
		else if (Br.equalsIgnoreCase("chrome")) 
		{
			Cap=new  DesiredCapabilities();
			Cap.setBrowserName("chrome");
			Cap.setPlatform(Platform.ANY);	
		}
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.137.1:4444/wd/hub"), Cap);
		driver.get("http://183.82.100.55/ranford2");
		driver.manage().window().maximize();
		
		RanfordHP hp=PageFactory.initElements(driver, RanfordHP.class);
		hp.Login();
		
		AdminHP ahp=PageFactory.initElements(driver, AdminHP.class);
		ahp.Role();
		RoleHP rhp=PageFactory.initElements(driver, RoleHP.class);
		rhp.NewRole();
		rhp.RoleDetails("Tellerasdf", "E");
		driver.switchTo().alert().accept();

		ahp.LogOut();
		driver.close();
	}

}