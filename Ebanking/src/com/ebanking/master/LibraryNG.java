package com.ebanking.master;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LibraryNG {
	WebDriver driver;
	String Expval,Actval;
	FileInputStream Fis;
	Properties Pr;
	
	@Test(priority=0)
	public void OpenApp() throws IOException
	{
		Fis=new FileInputStream("F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\properties\\Rep.properties");
		Pr=new Properties();
		Pr.load(Fis);
		
		
		Expval="Ranford Bank";
		driver=new FirefoxDriver();
		
		
		driver.get("http://183.82.100.55/ranford2");
		
		driver.manage().window().maximize();
		Actval=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		System.out.println(driver.getTitle());
		if(Expval.equalsIgnoreCase(Actval))
		{
			System.out.println("Ranford Application Launched");
		}
		else
		{
			System.out.println("Ranford Application not Launched");
		}
		
	}
	
	@Test(priority=1)
	public void AdminLogin() throws InterruptedException
	{
		driver.findElement(By.xpath(Pr.getProperty("Uname"))).sendKeys("Admin");
		driver.findElement(By.xpath(Pr.getProperty("Password"))).sendKeys("M1ndq");
		driver.findElement(By.xpath(Pr.getProperty("Login"))).click();
		Thread.sleep(1000);
		Expval="Welcome to Admin";
		Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		if(Expval.equalsIgnoreCase(Actval))
		{
			System.out.println("Admin Login Successfully");
		}
		else
		{
			System.out.println("Admin Login Fail");
		}
				
	}
	
	@Test(priority=2)
	public void BranchCre() throws InterruptedException
	{
		//Branch
		driver.findElement(By.xpath(Pr.getProperty("BranchBtn"))).click();
		Thread.sleep(1000);
		//New Branch Creation
		driver.findElement(By.id(Pr.getProperty("NBC"))).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(Pr.getProperty("BranchName"))).sendKeys("SBICBI");
		driver.findElement(By.xpath(Pr.getProperty("Address1"))).sendKeys("Ajjni");
		driver.findElement(By.xpath(Pr.getProperty("Address2"))).sendKeys("Ramnagar");
		driver.findElement(By.xpath(Pr.getProperty("Address3"))).sendKeys("IndiaGate");
		driver.findElement(By.xpath(Pr.getProperty("Area"))).sendKeys("Ajni");
		driver.findElement(By.xpath(Pr.getProperty("ZipCode"))).sendKeys("12345");
		Select Ctry=new Select(driver.findElement(By.id(Pr.getProperty("Country"))));
		Ctry.selectByVisibleText("INDIA");
		Select state=new Select(driver.findElement(By.id(Pr.getProperty("State"))));
		state.selectByVisibleText("GOA");
		Select city=new Select(driver.findElement(By.id(Pr.getProperty("City"))));
		city.selectByVisibleText("GOA");
		
		Expval="Successful";
		driver.findElement(By.xpath(Pr.getProperty("BrSubmit"))).click();
		Thread.sleep(1000);
		Actval=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if(Actval.contains(Expval))
		{
			System.out.println("Branch Created");
		}
		else
		{
			System.out.println("Branch Already Existed");
		}
		driver.findElement(By.xpath(Pr.getProperty("Home"))).click();
		Thread.sleep(1000);
			
	}
	@Test(priority=3)
	public void RoleCre() throws InterruptedException
	{
		//Role Button
		driver.findElement(By.xpath(Pr.getProperty("RoleButton"))).click();
		Thread.sleep(1000);
		//New Role Creation
		driver.findElement(By.xpath(Pr.getProperty("NewRoleCreation"))).click();
		Thread.sleep(1000);
		//Filling Details
		driver.findElement(By.xpath(Pr.getProperty("RName"))).sendKeys("PNBUCO");
		
		Select city=new Select(driver.findElement(By.id(Pr.getProperty("RoleType"))));
		city.selectByVisibleText("E");
		driver.findElement(By.xpath(Pr.getProperty("RoleSubmit"))).click();
		Thread.sleep(1000);
		
		String Actval=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if(Actval.contains(Expval))
		{
			System.out.println("Role Created");
		}
		else
		{
			System.out.println("Role Already Existed");
		}
		driver.findElement(By.xpath(Pr.getProperty("Home"))).click();
		Thread.sleep(1000);
			
	}
	
	@Test(priority=4)
	public void EmployeeCre() throws InterruptedException
	{
		//Employee
		driver.findElement(By.xpath(Pr.getProperty("Employee"))).click();
		//New Employee
		driver.findElement(By.xpath(Pr.getProperty("NewEmployee"))).click();
		//filling details in employee
		driver.findElement(By.xpath(Pr.getProperty("EmployerName"))).sendKeys("EmployeeSBI");
		driver.findElement(By.xpath(Pr.getProperty("LoginPassword"))).sendKeys("PasswordSBI");
		Select role=new Select(driver.findElement(By.id(Pr.getProperty("EmRole"))));
		role.selectByVisibleText("PNBUCO");
		Select branch=new Select(driver.findElement(By.id(Pr.getProperty("EmBranch"))));
		branch.selectByVisibleText("SBICBI");
		driver.findElement(By.xpath(Pr.getProperty("EmpSubmit"))).click();
		Thread.sleep(1000);
		
		Actval=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if(Actval.contains(Expval))
		{
			System.out.println("Employee Created");
		}
		else
		{
			System.out.println("Employee Already Existed");
		}
		
	}
	@Test(priority=5)
	public void AdmLogOut()
	{
		driver.findElement(By.xpath(Pr.getProperty("Logout")));
	}
	@Test(priority=6)
	public void AppClose()
	{
		driver.close();
	}
}
