package com.ebanking.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Basic_Scripts {

	public static void main(String[] args) throws InterruptedException {
		String Expval="Ranford Bank";
		WebDriver driver=new FirefoxDriver();
		
		driver.get("http://183.82.100.55/ranford2");
		
		driver.manage().window().maximize();
		String Actval=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		System.out.println(driver.getTitle());
		if(Expval.equalsIgnoreCase(Actval))
		{
			System.out.println("Ranford Application Launched");
		}
		else
		{
			System.out.println("Ranford Application not Launched");
		}
		
		//Home Page
		driver.findElement(By.xpath("//*[@id=\"txtuId\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id=\"txtPword\"]")).sendKeys("M1ndq");
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		Thread.sleep(5000);
		Expval="Welcome to Admin";
		if(Expval.equalsIgnoreCase(Actval))
		{
			System.out.println("Admin Login Successfully");
		}
		else
		{
			System.out.println("Admin Login Fial");
		}
		
		//Branch Page
		driver.findElement(By.xpath("//img[@src='images/Branches_but.jpg']")).click();
		Thread.sleep(2000);
		//New Branch Creation
		driver.findElement(By.id("BtnNewBR")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"txtbName\"]")).sendKeys("medical");
		driver.findElement(By.xpath("//*[@id=\"txtAdd1\"]")).sendKeys("Medical Chowk");
		driver.findElement(By.xpath("//*[@id=\"txtZip\"]")).sendKeys("44000");
		Select Ctry=new Select(driver.findElement(By.id("lst_counrtyU")));
		Ctry.selectByVisibleText("INDIA");
		Select state=new Select(driver.findElement(By.id("lst_stateI")));
		state.selectByVisibleText("MAHARASTRA");
		Select city=new Select(driver.findElement(By.id("lst_cityI")));
		city.selectByVisibleText("MUMBAI");
		
		driver.findElement(By.xpath("//*[@id=\"btn_insert\"]")).click();
		Thread.sleep(2000);
		Actval=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if(Actval.contains(Expval))
		{
			System.out.println("Branch Created");
		}
		else
		{
			System.out.println("Branch not Created");
		}
		Thread.sleep(2000);
		
		//Home Button
		driver.findElement(By.xpath("//img[@src='images/admin_but_01.jpg']")).click();
		Thread.sleep(5000);
		//Role Button
		driver.findElement(By.xpath("//img[@src='images/Roles_but.jpg']")).click();
		Thread.sleep(2000);
		//New Role Creation
		driver.findElement(By.xpath("//*[@id=\"btnRoles\"]")).click();
		Thread.sleep(2000);
		//Filling Details
		driver.findElement(By.xpath("//*[@id=\"txtRname\"]")).sendKeys("medicalchowk");
		driver.findElement(By.xpath("//*[@id=\"txtRDesc\"]")).sendKeys("medical chowk");
		driver.findElement(By.xpath("/html/body/div/form/div/table[1]/tbody/tr[4]/td[2]/select/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"btninsert\"]")).click();
		Thread.sleep(2000);
		String alert=driver.switchTo().alert().getText();
		System.out.println(alert);
		Actval=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if(Actval.contains(Expval))
		{
			System.out.println("Role Created");
		}
		else
		{
			System.out.println("Role Altready Existed");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='images/admin_but_01.jpg']")).click();
		Thread.sleep(2000);
		
		//Employee
		driver.findElement(By.xpath("//img[@src='images/emp_btn.jpg']")).click();
		//New Employee
		driver.findElement(By.xpath("//*[@id=\"BtnNew\"]")).click();
		//filling details in employee
		driver.findElement(By.xpath("//*[@id=\"txtUname\"]")).sendKeys("medical");
		driver.findElement(By.xpath("//*[@id=\"txtLpwd\"]")).sendKeys("medical");
		Select role=new Select(driver.findElement(By.id("lst_Roles")));
		role.selectByVisibleText("medicalchowk");
		Select branch=new Select(driver.findElement(By.id("lst_Branch")));
		branch.selectByVisibleText("medical");
		driver.findElement(By.xpath("//*[@id=\"BtnSubmit\"]")).click();
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='images/admin_but_01.jpg']")).click();
		Thread.sleep(5000);
		
		/*//User
		driver.findElement(By.xpath("//img[@src='images/Users_but.jpg']")).click();
		//new User creation
		driver.findElement(By.xpath("//*[@id=\"Btnuser\"]")).click();
		//Filling user details
		Select role1=new Select(driver.findElement(By.id("lst_Roles")));
		role1.selectByVisibleText("medicalchowk");
		Select branch1=new Select(driver.findElement(By.id("lst_Branch")));
		branch1.selectByVisibleText("medical");
		Select cid=new Select(driver.findElement(By.id("DrCName")));
		cid.selectByVisibleText("medical");
		driver.findElement(By.xpath("//*[@id=\"txtUname\"]")).sendKeys("medical");
		driver.findElement(By.xpath("//*[@id=\"txtLpwd\"]")).sendKeys("medical");
		driver.findElement(By.xpath("//*[@id=\"txtTpwd\"]")).sendKeys("medical");
		driver.findElement(By.xpath("//*[@id=\"BtnSubmit\"]")).click();
		Thread.sleep(2000);
		Actval=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if(Actval.contains(Expval))
		{
			System.out.println("User Created");
		}
		else
		{
			System.out.println("User Already Existed");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='images/admin_but_03.jpg']")).click();
	*/
		driver.close();

	}

}
