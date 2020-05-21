package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoleDP {
	WebDriver driver;
	
    @BeforeTest
	  public void login()
	  {
		  driver=new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.get("http://183.82.100.55/ranford2");

		  RanfordHP RHP=PageFactory.initElements(driver,RanfordHP.class);
		  RHP.Login();
		  
	  }
    
    @Test(dataProvider="Rdata")
    public void Role(String Rna,String Rty)
    {  	  
		 AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
		 AHP.Role();

		 RoleHP RD=PageFactory.initElements(driver,RoleHP.class);
		 RD.NewRole();
		 RD.RoleDetails(Rna, Rty);

		  driver.switchTo().alert().accept();
    }
		  
    @DataProvider
	
	public Object [][] Rdata()
	{
		Object [][] Obj =new Object[3][2];
		
		Obj[0][0]="managerhdfc";
		Obj[0][1]="E";
		
		Obj[1][0]="Manageraxis";
		Obj[1][1]="E";
		
		Obj[2][0]="Managericici";
		Obj[2][1]="E";
		
		return Obj;		
	}
    
    @AfterTest
	public void LogOut()
	{
		AdminHP ahp=PageFactory.initElements(driver, AdminHP.class);
		ahp.LogOut();
		driver.close();		
	}

}
