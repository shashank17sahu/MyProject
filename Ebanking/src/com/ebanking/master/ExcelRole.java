package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRole {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Library lb=new Library();
		lb.OpenApp("http://183.82.100.55/ranford2");
		lb.AdminLogin("Admin", "M1ndq");
		
		//To Get Test Data Excel File
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
			XSSFCell wc2=wr.createCell(2);
			
			String Rname=wc.getStringCellValue();
			String Rtyp=wc1.getStringCellValue();
			
			String res=lb.RoleCre(Rname, Rtyp);
			System.out.println(res);
			wc2.setCellValue(res);
		}
		FileOutputStream fos=new FileOutputStream("F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\result\\Res.Role.xlsx");
		wb.write(fos);
		wb.close();
		
	}


}






















