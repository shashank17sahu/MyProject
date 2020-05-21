package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelEmployee {

	public static void main(String[] args) throws IOException, InterruptedException {
		Library lb=new Library();
		lb.OpenApp("http://183.82.100.55/ranford2");
		lb.AdminLogin("Admin", "M1ndq");
		
		//To Get Test Data Excel File
		FileInputStream Fis=new FileInputStream("F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\testdata\\Employee.xlsx");
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
			XSSFCell wc4=wr.createCell(4);
			
			String Empname=wc.getStringCellValue();
			String Emplpw=wc1.getStringCellValue();
			String EmpRole=wc2.getStringCellValue();
			String EmpBranch=wc3.getStringCellValue();
			
			String res=lb.EmployeeCre(Empname, Emplpw, EmpRole, EmpBranch);
			System.out.println(res);
			wc4.setCellValue(res);
		}
		FileOutputStream fos=new FileOutputStream("F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\result\\Res.Employee.xlsx");
		wb.write(fos);
		wb.close();
	}


}
