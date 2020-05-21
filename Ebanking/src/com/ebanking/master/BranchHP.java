package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BranchHP 
{
	@FindBy(id="BtnNewBR")
	WebElement NewBranch;
	@FindBy(id="txtbName")
	WebElement BranchName;
	@FindBy(id="txtAdd1")
	WebElement Address1;
	@FindBy(id="Txtadd2")
	WebElement Address2;
	@FindBy(id="txtadd3")
	WebElement Address3;
	@FindBy(id="txtArea")
	WebElement Area;
	@FindBy(id="txtZip")
	WebElement ZipCode;
	@FindBy(id="lst_counrtyU")
	WebElement Country;
	@FindBy(id="lst_stateI")
	WebElement Stat;
	@FindBy(id="lst_cityI")
	WebElement Cit;
	@FindBy(xpath="//*[@id=\"btn_insert\"]")
	WebElement BrSubmit;
	
	public void NewBranch()
	{
		NewBranch.click();
	}
	public void BranchDetails(String Branch,String Add1,String Add2,String Add3,String Ar,String Zip,String Count,String State,String City ) throws InterruptedException
	{
		BranchName.sendKeys(Branch);
		Address1.sendKeys(Add1);
		Address2.sendKeys(Add2);
		Address3.sendKeys(Add3);
		Area.sendKeys(Ar);
		ZipCode.sendKeys(Zip);
		Country.sendKeys(Count);
		Thread.sleep(1000);
		Stat.sendKeys(State);
		Thread.sleep(1000);
		Cit.sendKeys(City);
		BrSubmit.click();
	}
}
