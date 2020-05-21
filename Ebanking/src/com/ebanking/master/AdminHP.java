package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminHP
{
	@FindBy(xpath="//img[@src='images/Branches_but.jpg']")
	WebElement Branch;
	@FindBy(xpath="//img[@src='images/Roles_but.jpg']")
	WebElement Role;
	@FindBy(xpath="//img[@src='images/emp_btn.jpg']")
	WebElement Employee;
	@FindBy(xpath="//img[@src='images/admin_but_01.jpg']")
	WebElement Home;
	@FindBy(xpath="//img[@src='images/admin_but_03.jpg']")
	WebElement LogOut;
	public void Branch()
	{
		Branch.click();
	}
	public void Role()
	{
		Role.click();
	}
	public void Employee()
	{
		Employee.click();
	}
	public void Home()
	{
		Home.click();
	}
	public void LogOut()
	{
		LogOut.click();
	}

}
