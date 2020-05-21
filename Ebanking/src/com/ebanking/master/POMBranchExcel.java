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

public class POMBranchExcel 
{
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
	public void Branch() throws InterruptedException, IOException
	{
		FileInputStream Fis=new FileInputStream("F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\testdata\\Branch.xlsx");
		//WorkBook
		XSSFWorkbook wb=new XSSFWorkbook(Fis);
		//Sheet
		XSSFSheet ws=wb.getSheet("Sheet1");
		//Row Count
		int rc=ws.getLastRowNum();
		System.out.println(rc);
		//Multiple Iteration -----Loop
		for(int i=1;i<=rc;i++)
		{
			XSSFRow wr=ws.getRow(i);
			
			XSSFCell wc=wr.getCell(0);
			XSSFCell wc1=wr.getCell(1);
			XSSFCell wc2=wr.getCell(2);
			XSSFCell wc3=wr.getCell(3);
			XSSFCell wc4=wr.getCell(4);
			XSSFCell wc5=wr.getCell(5);
			XSSFCell wc6=wr.getCell(6);
			XSSFCell wc7=wr.getCell(7);
			XSSFCell wc8=wr.getCell(8);
			
			
			String Branch=wc.getStringCellValue();
			String Address1=wc1.getStringCellValue();
			String Address2=wc2.getStringCellValue();
			String Address3=wc3.getStringCellValue();
			String Area=wc4.getStringCellValue();
			String Zipcode=wc5.getStringCellValue();
			String Country=wc6.getStringCellValue();
			String State=wc7.getStringCellValue();
			String City=wc8.getStringCellValue();
			
			AdminHP ahp=PageFactory.initElements(driver, AdminHP.class);
			ahp.Branch();
			BranchHP bhp=PageFactory.initElements(driver, BranchHP.class);
			bhp.NewBranch();
			bhp.BranchDetails(Branch, Address1, Address2, Address3, Area, Zipcode, Country, State, City);
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
