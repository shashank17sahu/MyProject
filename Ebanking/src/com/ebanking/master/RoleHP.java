package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoleHP 
{
	@FindBy(id="btnRoles")
	WebElement Nrole;
	@FindBy(xpath="//*[@id=\"txtRname\"]")
	WebElement Rolename;
	@FindBy(id="lstRtypeN")
	WebElement RoleType;
	@FindBy(xpath="//*[@id=\"btninsert\"]")
	WebElement RoleSubmit;
	
	public void NewRole()
	{
		Nrole.click();
	}
	public String RoleDetails(String Rname,String Rtype)
	{
		Rolename.sendKeys(Rname);
		RoleType.sendKeys(Rtype);
		RoleSubmit.click();
		return Rtype;
	}
	
}
	