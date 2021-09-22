package com.crm.autodesk.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {
	
	
	public  void OrganizationInfoPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}
	//locate Web-elements
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizationInfo;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryInfo;

	public WebElement getOrganizationInfo() {
		return organizationInfo;
	}

	public WebElement getIndustryInfo() {
		return industryInfo;
	}
	public String getOrganizationsInformation()
	{
		String value=organizationInfo.getText();
		return value;
	}
	
	public String getIndustriesInfo()
	{
		return industryInfo.getText();
	}
	
	
	

}
