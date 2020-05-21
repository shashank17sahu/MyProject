package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExePOM 
{
	
	WebDriver driver;
	@BeforeTest
	public void Ranford() throws InterruptedException
	{
	
		driver=new FirefoxDriver();
		driver.get("http://183.82.100.55/ranford2");
		driver.manage().window().maximize();
		
		RanfordHP hp=PageFactory.initElements(driver, RanfordHP.class);
		hp.Login();
	}
	@Test(priority=1)
	public void Branch(String Branch,String Add1,String Add2,String Add3,String Ar,String Zip,String Count,String State,String City) throws InterruptedException
	{
		AdminHP ahp=PageFactory.initElements(driver, AdminHP.class);
		ahp.Branch();
		BranchHP bhp=PageFactory.initElements(driver, BranchHP.class);
		bhp.NewBranch();
		bhp.BranchDetails(Branch, Add1, Add2, Add3, Ar, Zip, Count, State, City);
		driver.switchTo().alert().accept();
	}
	@Test(priority=2)
	public void Role(String Rname, String Rtype)
	{
		AdminHP ahp=PageFactory.initElements(driver, AdminHP.class);
		ahp.Role();
		RoleHP rhp=PageFactory.initElements(driver, RoleHP.class);
		rhp.NewRole();
		rhp.RoleDetails(Rname, Rtype);
		driver.switchTo().alert().accept();
		
	}
	@Test(priority=3)
	public void Employee(String EName,String EPassword,String EmRole,String EmBranch) throws InterruptedException
	{
		AdminHP ahp=PageFactory.initElements(driver, AdminHP.class);
		ahp.Employee();
		EmployeeHP ehp=PageFactory.initElements(driver, EmployeeHP.class);
		ehp.NewEmployee();
		ehp.EmployeeDetails(EName, EPassword, EmRole, EmBranch);
		driver.switchTo().alert().accept();
	}
	@AfterTest
	public void LogOut()
	{
		AdminHP ahp=PageFactory.initElements(driver, AdminHP.class);
		ahp.LogOut();
		driver.close();
	}		
		
}

