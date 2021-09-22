package com.crm.autodesk.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPage {
	WebDriver driver;
	//constructor
	public CreateLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//locate all the webelements
	@FindBy(xpath="//a[text()='Leads']")
	private WebElement CreateLeadImg;
	
	@FindBy(name="firstname")
	private WebElement FirstNameEdt;
	
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(name="company")
	private WebElement CompanyEdt;
	
	@FindBy(xpath="//input[@title='Save[Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@class='repBox']")
	private WebElement AmountEdt;
	
	@FindBy(xpath="//input[@class='repBox']")
	private WebElement CreateddateEdt;
	
	@FindBy(xpath="//input[@class='repBox']")
	private WebElement FaxnoEdt;
	
	public WebElement getFaxnoEdt() {
		return FaxnoEdt;
	}

	public WebElement getLeadnoEdt() {
		return LeadnoEdt;
	}

	public WebElement getLeadSourseEdt() {
		return LeadSourseEdt;
	}
	@FindBy(xpath="//input[@class='repBox']")
	private WebElement LeadnoEdt;
	
	@FindBy(xpath="//input[@class='repBox']")
	private WebElement LeadSourseEdt;

	public WebElement getCreateddateEdt() {
		return CreateddateEdt;
	}

	

	public WebElement getCreateLeadImg() {
		return CreateLeadImg;
	}

	public WebElement getFirstNameEdt() {
		return FirstNameEdt;
	}

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getCompanyEdt() {
		return CompanyEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getAmountEdt() {
		return AmountEdt;
	}
	

	public void createLeadPagefirstname(String FirstName)
	{
		FirstNameEdt.sendKeys(FirstName);
		saveBtn.click();
	}
	
	public void createLeadPagelastname(String LastName)
	{
		LastNameEdt.sendKeys(LastName);
		saveBtn.click();
	}
	
	public void createLeadPagecompany(String Company)
	{
		CompanyEdt.sendKeys(Company);
		saveBtn.click();
	}
	public void PassAnnualRev(int AnnualRev)
	{
		AmountEdt.sendKeys(""+AnnualRev);
		
	}
    
	public void clickoncreateddate(String CreatedDate)
	{
		CreateddateEdt.sendKeys(CreatedDate);
		
	}
	public void clickonFaxnoEdt(int FaxNo)
	{
		FaxnoEdt.sendKeys(""+FaxNo);
		
	}
	
	public void clickonLeadnoEdt(String LeadNo)
	{
		LeadnoEdt.sendKeys(LeadNo);
		
	}
	
	public void clickonLeadSourseEdt(String LeadSource)
	{
		LeadSourseEdt.sendKeys(LeadSource);
		
	}
	
	

}
