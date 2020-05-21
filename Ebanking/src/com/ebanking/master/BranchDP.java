package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BranchDP{
	
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
    
      @Test(dataProvider="Bdata")
      public void Branch(String Branch,String Address1,String Address2,String Address3,String Area,String Zipcode,String Country,String State,String City) throws InterruptedException
      {
    	  AdminHP ahp=PageFactory.initElements(driver, AdminHP.class);
		  ahp.Branch();
	      BranchHP bhp=PageFactory.initElements(driver, BranchHP.class);
		  bhp.NewBranch();
		  bhp.BranchDetails(Branch, Address1, Address2, Address3, Area, Zipcode, Country, State, City);
	      driver.switchTo().alert().accept();
      }
 
      
      @DataProvider
  	public Object [][] Bdata()
  	{
  		Object[][] obj=new Object[3][9];
  		obj[0][0]="CashSBI";
  		obj[0][1]="RamNagar";
  		obj[0][2]="RamAjni";
  		obj[0][3]="MedRam";
  		obj[0][4]="AJni";
  		obj[0][5]="12345";
  		obj[0][6]="INDIA";
  		obj[0][7]="GOA";
  		obj[0][8]="GOA";
  		
  		obj[1][0]="CashCBI";
  		obj[1][1]="RamNagar";
  		obj[1][2]="RamAjni";
  		obj[1][3]="MedRam";
  		obj[1][4]="AJni";
  		obj[1][5]="12345";
  		obj[1][6]="INDIA";
  		obj[1][7]="GOA";
  		obj[1][8]="GOA";
  		
  		obj[2][0]="CashPNB";
  		obj[2][1]="RamNagar";
  		obj[2][2]="RamAjni";
  		obj[2][3]="MedRam";
  		obj[2][4]="AJni";
  		obj[2][5]="12345";
  		obj[2][6]="INDIA";
  		obj[2][7]="GOA";
  		obj[2][8]="GOA";
  		return obj;
  	}
      @AfterTest
		public void LogOut()
		{
			AdminHP ahp=PageFactory.initElements(driver, AdminHP.class);
			ahp.LogOut();
			driver.close();
			
		}
      
}



