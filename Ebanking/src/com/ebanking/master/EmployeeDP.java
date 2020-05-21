package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmployeeDP {
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
    
	@Test(dataProvider="Edata")
	public void Employee(String EName,String EPassword,String EmRole,String EmBranch) throws InterruptedException
	{
		AdminHP ahp=PageFactory.initElements(driver, AdminHP.class);
		ahp.Employee();
		EmployeeHP ehp=PageFactory.initElements(driver, EmployeeHP.class);
		ehp.NewEmployee();
		ehp.EmployeeDetails(EName, EPassword, EmRole, EmBranch);
		driver.switchTo().alert().accept();
	}
	
	@DataProvider
	public Object [][] Edata()
	{
		Object[][] obj=new Object[3][4];
		obj[0][0]="CashEmpSBI";
		obj[0][1]="RamNagar";
		obj[0][2]="TellsaabSBI";
		obj[0][3]="CashSBI";
		
		obj[1][0]="CashEmpCBI";
		obj[1][1]="Ramagar";
		obj[1][2]="TellsbaaCBI";
		obj[1][3]="CashCBI";
		
		
		
		obj[2][0]="CashEmpPNB";
		obj[2][1]="Ramgar";
		obj[2][2]="TellsbaaPNB";
		obj[2][3]="CashPNB";
		
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
