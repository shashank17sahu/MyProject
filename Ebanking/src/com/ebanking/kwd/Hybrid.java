package com.ebanking.kwd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ebanking.master.Library;

public class Hybrid {

	public static void main(String[] args) throws IOException, InterruptedException {
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
												FileInputStream Fis=new FileInputStream("F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\testdata\\Branch.xlsx");
					    //WorkBook
												XSSFWorkbook bwb=new XSSFWorkbook(Fis);
					    //Sheet
												XSSFSheet bws=bwb.getSheet("Sheet1");
						//Row Count
												int rc=bws.getLastRowNum();
												System.out.println(rc);
						//Multiple Iteration -----Loop
												for(int i1=1;i1<=rc;i1++)
												{
													XSSFRow bwr=bws.getRow(i1);
													
													XSSFCell bwc=bwr.getCell(0);
													XSSFCell bwc1=bwr.getCell(1);
													XSSFCell bwc2=bwr.getCell(2);
													XSSFCell bwc3=bwr.getCell(3);
													XSSFCell bwc4=bwr.getCell(4);
													XSSFCell bwc5=bwr.getCell(5);
													XSSFCell bwc6=bwr.getCell(6);
													XSSFCell bwc7=bwr.getCell(7);
													XSSFCell bwc8=bwr.getCell(8);
													XSSFCell bwc9=bwr.createCell(9);
													
													String Branch=bwc.getStringCellValue();
													String Address1=bwc1.getStringCellValue();
													String Address2=bwc2.getStringCellValue();
													String Address3=bwc3.getStringCellValue();
													String Area=bwc4.getStringCellValue();
													String Zipcode=bwc5.getStringCellValue();
													String Country=bwc6.getStringCellValue();
													String State=bwc7.getStringCellValue();
													String City=bwc8.getStringCellValue();

													
													String res=LB.BranchCre(Branch, Address1, Address2, Address3, Area, Zipcode, Country, State, City);
													System.out.println(res);
													bwc9.setCellValue(res);
												}
												FileOutputStream fos=new FileOutputStream("F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\result\\Res.Branch.xlsx");
												wb.write(fos);
												wb.close();;
												break;
											case "RRole":
												FileInputStream Fis1=new FileInputStream("F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\testdata\\Role.xlsx");
							//WorkBook
												XSSFWorkbook rwb=new XSSFWorkbook(Fis1);
							//Sheet
												XSSFSheet rws=rwb.getSheet("RData");
			     			//Row Count
												int rc1=rws.getLastRowNum();
												System.out.println(rc1);
							//Multiple Iteration -----Loop
												for(int i1=1;i1<=rc1;i1++)
												{
													XSSFRow rwr=rws.getRow(i1);
													
													XSSFCell rwc=rwr.getCell(0);
													XSSFCell rwc1=rwr.getCell(1);
													XSSFCell rwc2=rwr.createCell(2);
													
													String Rname=rwc.getStringCellValue();
													String Rtyp=rwc1.getStringCellValue();
													
													String res=LB.RoleCre(Rname, Rtyp);
													System.out.println(res);
													rwc2.setCellValue(res);
												}
												FileOutputStream fos1=new FileOutputStream("F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\result\\Res.Role.xlsx");
												rwb.write(fos1);
												rwb.close();
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


