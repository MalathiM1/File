package com.crm.autodesk.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPageInfo {
	//constructor
	public LeadPageInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//locate webelements
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement leadsInfo;
	
	@FindBy(id="dtlview_Annual Revenue")
	private WebElement annualRevenueInfo;
	
	@FindBy(xpath="//td[@class='dvtCellInfo']")
	private WebElement createdDateInfo;
	
	@FindBy(id="dtlview_Fax")
	private WebElement faxInfo;
	
	
	@FindBy(xpath="//td[@class='dvtCellInfo']")
	private WebElement leadNoInfo;
	
	@FindBy(xpath="//font[text()='Employee']")
	private WebElement leadSourceinfo;
	
	@FindBy(xpath="//td[@onmouseover='vtlib_listview.trigger('cell.onmouseover', $(this))']")
	private WebElement companyname;
	
	// provide getters

	public WebElement getCompanyname() {
		return companyname;
	}

	public WebElement getLeadsInfo() {
		return leadsInfo;
	}

	public WebElement getAnnualRevenueInfo() {
		return annualRevenueInfo;
	}

	public WebElement getCreatedDateInfo() {
		return createdDateInfo;
	}

	public WebElement getFaxInfo() {
		return faxInfo;
	}

	public WebElement getLeadNoInfo() {
		return leadNoInfo;
	}

	public WebElement getLeadSourceinfo() {
		return leadSourceinfo;
	}
	
	/* get annual revenue info
	 * 
	 */
	
	public String getannualRevenuesInfo() {
		return annualRevenueInfo.getText();
	}
	
	public String getcreatedDatesInfo() {
		return createdDateInfo.getText();
	}
	
	public String getfaxsInfo() {
		return faxInfo.getText();
	}
	
	public String getleadsNoInfo() {
		return leadNoInfo.getText();
	}
	
	public String getleadSourcesinfo() {
		return leadSourceinfo.getText();
	}
	
	public String getCompanynameinfo() {
		return companyname.getText();
	}
	

}
