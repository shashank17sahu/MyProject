package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoleNG extends Base
{
	@Test(dataProvider="Rdata")
	public void Role(String Rn,String Rt) throws InterruptedException
	{
		lb.RoleCre(Rn, Rt);
	}
	
	@DataProvider
	public Object [][] Rdata()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="TellsaabSBI";
		obj[0][1]="E";
		
		obj[1][0]="TellsbaaCBI";
		obj[1][1]="E";
		
		obj[2][0]="TellsbaaPNB";
		obj[2][1]="E";
		
		return obj;
	}

}
