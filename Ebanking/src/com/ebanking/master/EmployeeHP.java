package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeHP 
{
	@FindBy(id="BtnNew")
	WebElement NewEmployee;
	@FindBy(xpath="//*[@id=\"txtUname\"]")
	WebElement EmployerName;
	@FindBy(id="txtLpwd")
	WebElement LoginPassword;
	@FindBy(id="lst_Roles")
	WebElement EmRole;
	@FindBy(id="lst_Branch")
	WebElement EmBranch;
	@FindBy(id="BtnSubmit")
	WebElement EmpSubmit;
	
	public void NewEmployee()
	{
		NewEmployee.click();
	}
	public void EmployeeDetails(String EName,String EPassword,String EmRol,String EmBranc) throws InterruptedException
	{
		EmployerName.sendKeys(EName);
		LoginPassword.sendKeys(EPassword);
		EmRole.sendKeys(EmRol);
		Thread.sleep(1000);
		EmBranch.sendKeys(EmBranc);
		EmpSubmit.click();
	}
	

}
