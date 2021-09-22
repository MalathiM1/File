package com.crm.autodesk.ElementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class LeadPage extends WebDriverUtility{

WebDriver driver;

public LeadPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
//locate all the elements

@FindBy(xpath="//a[text()='Leads']")
private WebElement createLeadImg;

@FindBy(xpath="//a[text()='Go to Advanced ']")
private WebElement advancedsearch;

@FindBy(name="fcol0")
private WebElement solutionEdt;

@FindBy(name="fcol0")
private WebElement AnnualRevenueLnk;

@FindBy(name="fcol0")
private WebElement CreateddateEdt;

@FindBy(name="fcol0")
private WebElement LeadNoEdt;

@FindBy(name="fcol0")
private WebElement LeadSourceEdt;


public WebElement getLeadSourceEdt() {
	return LeadSourceEdt;
}

public WebElement getLeadNoEdt() {
	return LeadNoEdt;
}

@FindBy(name="fop0")
private WebElement noneEdt;

@FindBy(xpath="//select[@class='repBox']")
private WebElement equalsEdt;

@FindBy(xpath="//input[@class='repBox']")
private WebElement AmountEdt;

@FindBy(xpath="(//input[@value=' Search Now '])[2]")
private WebElement searchnowEdt;





public WebElement getSearchnowEdt() {
	return searchnowEdt;
}

@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement administatorImg;

@FindBy(xpath="//a[text()='Sign Out']")
private WebElement signoutEdt;



public WebElement getCreateLeadImg() {
	return createLeadImg;
}

public WebElement getAdvancedsearch() {
	return advancedsearch;
}

public WebElement getSolutionEdt() {
	return solutionEdt;
}

public WebElement getAnnualRevenueLnk() {
	return AnnualRevenueLnk;
}

public WebElement getCreateddateEdt() {
	return CreateddateEdt;
}

public WebElement getNoneEdt() {
	return noneEdt;
}

public WebElement getEqualsEdt() {
	return equalsEdt;
}

public WebElement getAmountEdt() {
	return AmountEdt;
}


public WebElement getAdministatorImg() {
	return administatorImg;
}

public WebElement getSignoutEdt() {
	return signoutEdt;
}

public void clickOnLeads()
{
	createLeadImg.click();
}

public void clickOnAdvanceSearch()
{
	advancedsearch.click();
}

public void solution()
{
	select(driver,solutionEdt,"Annual Revenue" );
	
	select(driver,solutionEdt,"Created Time" );
 
}

public void clickonAnnualRevenue()
{
	AnnualRevenueLnk.click();
	
	
}



public void clickonCreateddate()
{
	CreateddateEdt.click();
}
public void clickonLeadNo()
{
	LeadNoEdt.click();
}

public void clickonLeadSource()
{
	LeadSourceEdt.click();
}


public void none()
{
	select(driver,noneEdt,"equals" );
	
	
 
}

public void clickOnEquals()
{
	equalsEdt.click();
	

}

public void clickOnAmount()
{
	AmountEdt.click();
}

public void clickOnsearchnow()
{
	searchnowEdt.click();
}
 public void clickOnsignout()
 {
   mouseOver(driver, administatorImg);
   signoutEdt.click();
}
    

}
