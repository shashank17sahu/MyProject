package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelBranch {

	public static void main(String[] args) throws IOException, InterruptedException {
		Library lb=new Library();
		lb.OpenApp("http://183.82.100.55/ranford2");
		lb.AdminLogin("Admin", "M1ndq");
		
		//To Get Test Data Excel File
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
			XSSFCell wc9=wr.createCell(9);
			
			String Branch=wc.getStringCellValue();
			String Address1=wc1.getStringCellValue();
			String Address2=wc2.getStringCellValue();
			String Address3=wc3.getStringCellValue();
			String Area=wc4.getStringCellValue();
			String Zipcode=wc5.getStringCellValue();
			String Country=wc6.getStringCellValue();
			String State=wc7.getStringCellValue();
			String City=wc8.getStringCellValue();

			
			String res=lb.BranchCre(Branch, Address1, Address2, Address3, Area, Zipcode, Country, State, City);
			System.out.println(res);
			wc9.setCellValue(res);
		}
		FileOutputStream fos=new FileOutputStream("F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\result\\Res.Branch.xlsx");
		wb.write(fos);
		wb.close();
	}

}
