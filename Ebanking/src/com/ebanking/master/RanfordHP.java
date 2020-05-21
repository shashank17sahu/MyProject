package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RanfordHP
{
 //Element Properties
	@FindBy(id="txtuId")
	WebElement uname;
	
	@FindBy(id="txtPword")
	WebElement Pswd;
	
	@FindBy(xpath="//*[@id=\"login\"]")
	WebElement Lgn;
	
//Element  Methods
	public void Login()
	{
		uname.sendKeys("Admin");
		Pswd.sendKeys("M1ndq");
		Lgn.click();
	}
}
