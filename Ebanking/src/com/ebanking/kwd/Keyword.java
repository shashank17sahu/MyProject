package com.ebanking.kwd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ebanking.master.Library;

public class Keyword 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//instance class		
		Library LB=new Library();				 
				 String Res=null;				 
				 String Kpath="F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\kwd\\keyword_data.xlsx";				 
				 String Kout="F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\kwd\\keywordres_data.xlsx";
								 
				 FileInputStream fi=new FileInputStream(Kpath);					
				 //Workbook
					XSSFWorkbook wb=new XSSFWorkbook(fi);                   
				//Sheet
					XSSFSheet ws=wb.getSheet("TestCase");
					XSSFSheet ws1=wb.getSheet("TestSteps");					
				//XSSFSheet ws2=wb.getSheet("TestData");
		
				//Row count				
					int tcRc=ws.getLastRowNum();
			        System.out.println(tcRc);
			        
					int tsRc=ws1.getLastRowNum();
					System.out.println(tsRc);				
				//test cases

					for (int i = 1;i<=tcRc;i++)
					{
						String exe=ws.getRow(i).getCell(2).getStringCellValue();
						if (exe.equalsIgnoreCase("Y"))
						{
							String tcId=ws.getRow(i).getCell(0).getStringCellValue();
						System.out.println(tcId);						
				//test steps							
							for (int j = 1; j <= tsRc ; j++) 
							{
								String tsTcid=ws1.getRow(j).getCell(0).getStringCellValue();
								//System.out.println(tsTcid);
								if (tcId.equalsIgnoreCase(tsTcid))
								{
									String key=ws1.getRow(j).getCell(3).getStringCellValue();
									System.out.println(key);
									switch (key) 
									{
									case "RLanch":
										Res=LB.OpenApp("http://183.82.100.55/ranford2");
										break;
									case "RLogin":
										Res=LB.AdminLogin("Admin", "M1ndq");
										break;
									case "RLogout": 	
										LB.AdmLogOut();
										break;
									case "RBranch":
										LB.BranchCre("medical", "Chowk", "square", "Ajni", "Ajni", "12345", "INDIA", "GOA", "GOA");
										break;
									case "RRole":
										LB.RoleCre("medicalasdf", "E");
										break;
									case "REmR":
										LB.EmployeeCre("medicala", "chowk", "medicalchowk", "CBIBranCBI");
										break;
									case "RClose":
										LB.AppClose();
										break;
					
									default:
										System.out.println("Pass a Valid Keyword");
										break;
									}
					//result updation in test steps sheet									
									ws1.getRow(j).createCell(4).setCellValue(Res);									
					//result updation in test case sheet									
									if (!ws1.getRow(j).getCell(4).getStringCellValue().equalsIgnoreCase("Fail"))
									{
										ws.getRow(i).createCell(3).setCellValue(Res);
									}
									else
									{
										ws.getRow(i).createCell(3).setCellValue("Fail");
									}										
								}									
							}							
						}
						else
						{
							ws.getRow(i).createCell(3).setCellValue("BLOCKED");
						}
					}
					FileOutputStream fo=new FileOutputStream(Kout);
					wb.write(fo);
					wb.close();
				}

		
	}