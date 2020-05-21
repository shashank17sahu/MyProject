package com.ebanking.master;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class POMRoleExcel {
		WebDriver driver;
		@BeforeTest
		public void Login() throws InterruptedException
		{
			driver=new FirefoxDriver();
			driver.get("http://183.82.100.55/ranford2");
			driver.manage().window().maximize();
			
			RanfordHP hp=PageFactory.initElements(driver, RanfordHP.class);
			hp.Login();
			
		}
		@Test
		public void Role() throws IOException
		{
			FileInputStream Fis=new FileInputStream("F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\testdata\\Role.xlsx");
		//WorkBook
			XSSFWorkbook wb=new XSSFWorkbook(Fis);
		//Sheet
			XSSFSheet ws=wb.getSheet("RData");
		//Row Count
			int rc=ws.getLastRowNum();
			System.out.println(rc);
		//Multiple Iteration -----Loop
			for(int i=1;i<=rc;i++)
			{
				XSSFRow wr=ws.getRow(i);
			
				XSSFCell wc=wr.getCell(0);
				XSSFCell wc1=wr.getCell(1);
			
			
				String Rname=wc.getStringCellValue();
				String Rtyp=wc1.getStringCellValue();
			 
				AdminHP ahp=PageFactory.initElements(driver, AdminHP.class);
				ahp.Role();
				RoleHP rhp=PageFactory.initElements(driver, RoleHP.class);
				rhp.NewRole();
				rhp.RoleDetails(Rname, Rtyp);
				driver.switchTo().alert().accept();
		
			}
			wb.close();	
		}
		
		@AfterTest
		public void LogOut()
		{
			AdminHP ahp=PageFactory.initElements(driver, AdminHP.class);
			ahp.LogOut();
			driver.close();
			
		}
	}
	

