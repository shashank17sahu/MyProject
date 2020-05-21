package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmployeeNG extends Base
{
	@Test(dataProvider="Edata")
	public void Employee(String EName,String EPassword,String EmRole,String EmBranch) throws InterruptedException
	{
		lb.EmployeeCre(EName, EPassword, EmRole, EmBranch);
	}
	
	@DataProvider
	public Object [][] Edata()
	{
		Object[][] obj=new Object[3][4];
		obj[0][0]="CashEmpSBI";
		obj[0][1]="RamNagar";
		obj[0][2]="TellsaabSBI";
		obj[0][3]="CashSBI";
		
		obj[1][0]="CashEmpCBI";
		obj[1][1]="Ramagar";
		obj[1][2]="TellsbaaCBI";
		obj[1][3]="CashCBI";
		
		
		
		obj[2][0]="CashEmpPNB";
		obj[2][1]="Ramgar";
		obj[2][2]="TellsbaaPNB";
		obj[2][3]="CashPNB";
		
		return obj;
	}
}
