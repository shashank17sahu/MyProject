package com.ebanking.master;

import org.testng.annotations.Test;

public class AdminLoginNG extends Base
{
	@Test
	public void Role() throws InterruptedException
	{
		lb.RoleCre("SCBIBANK", "E");
	}
	@Test
	public void Br() throws InterruptedException
	{
		lb.BranchCre("cbisbipnb", "sbimedcho", "cnimedcho", "pnbmedcho", "nagpur", "12345", "INDIA", "GOA", "GOA");
	}
	@Test
	public void Employee() throws InterruptedException
	{
		lb.EmployeeCre("EmpSBIcbi", "EmpSBIpw", "SCBIBANK", "cbisbipnb");
	}
}
