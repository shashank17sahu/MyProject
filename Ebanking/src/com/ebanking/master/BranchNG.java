package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BranchNG extends Base
{
	@Test(dataProvider="Bdata")
	public void Br(String Branch,String Add1,String Add2,String Add3,String Area,String Zip,String Country,String state,String city) throws InterruptedException
	{
		lb.BranchCre(Branch, Add1, Add2, Add3, Area, Zip, Country, state, city);
	}
	
	@DataProvider
	public Object [][] Bdata()
	{
		Object[][] obj=new Object[3][9];
		obj[0][0]="CashSBI";
		obj[0][1]="RamNagar";
		obj[0][2]="RamAjni";
		obj[0][3]="MedRam";
		obj[0][4]="AJni";
		obj[0][5]="12345";
		obj[0][6]="INDIA";
		obj[0][7]="GOA";
		obj[0][8]="GOA";
		
		obj[1][0]="CashCBI";
		obj[1][1]="RamNagar";
		obj[1][2]="RamAjni";
		obj[1][3]="MedRam";
		obj[1][4]="AJni";
		obj[1][5]="12345";
		obj[1][6]="INDIA";
		obj[1][7]="GOA";
		obj[1][8]="GOA";
		
		obj[2][0]="CashPNB";
		obj[2][1]="RamNagar";
		obj[2][2]="RamAjni";
		obj[2][3]="MedRam";
		obj[2][4]="AJni";
		obj[2][5]="12345";
		obj[2][6]="INDIA";
		obj[2][7]="GOA";
		obj[2][8]="GOA";
		return obj;
	}
}
