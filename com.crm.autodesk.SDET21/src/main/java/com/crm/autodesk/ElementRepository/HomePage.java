package com.crm.autodesk.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
	PageFactory.initElements(driver, this);
    }
	
	@FindBy ( linkText = "Organizations" )
	private WebElement organizationLnk;
	
	@FindBy (xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	
	@FindBy (xpath="//a[.='Sign Out']")
	private WebElement signoutLnk;
	
	@FindBy ( linkText = "Contacts" )
	private WebElement contactsLnk;
	
	@FindBy ( linkText = "Products" )
	private WebElement productsLnk;
	
	@FindBy ( linkText = "Email" )
	private WebElement emailLnk;
	
	@FindBy ( linkText = "Opportunities" )
	private WebElement opportunitiesLnk;
	
	@FindBy (xpath="//a[text()='Leads']" )
	private WebElement leadsLnk;

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getEmailLnk() {
		return emailLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}
	
	public void clickOnOrganizations()
	{
		organizationLnk.click();
	}
	
	public void clickOnContacts()
	{
		
		contactsLnk.click();
	}
	
	public void signOut(WebDriver driver)
	{
		mouseOver(driver,administratorImg);
		signoutLnk.click();
	}
	
	public void clickOnLeads()
	{
		organizationLnk.click();
		leadsLnk.click();
	}
	
	
	
	
	
	
	
	

}
