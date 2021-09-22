package com.crm.autodesk.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibraries.JSONFileUtility;

//rule1 create a separate class for every webpage
public class LoginPage extends JSONFileUtility{
	
	public LoginPage(WebDriver driver)//rule 4 create a constructor and use a pagefactory class to initiate
	{
		PageFactory.initElements(driver, this);
	}
	//rule2 identify all the elements using @findBy @findBys and @findAll
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn;

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void login(String username, String password) 
	{
		userNameEdt.sendKeys(username);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
		
	}

	
}
