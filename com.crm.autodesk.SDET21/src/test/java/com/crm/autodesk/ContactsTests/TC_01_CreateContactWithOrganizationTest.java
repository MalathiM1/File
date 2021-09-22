package com.crm.autodesk.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.BaseClass;
import com.crm.autodesk.GenericLibraries.ExcelFileUtility;
import com.crm.autodesk.GenericLibraries.JSONFileUtility;
import com.crm.autodesk.GenericLibraries.JavaUtility;
import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class TC_01_CreateContactWithOrganizationTest extends BaseClass{
	WebDriver driver=null;
@Test
	
	public void contactWithOrgTest() throws Throwable {
		//read all the neccesery data
		
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jlib = new JavaUtility();
		JSONFileUtility jsLib = new JSONFileUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
	
		
		String USERNAME = jsLib.readDataFromJSON("username");
		String PASSWORD = jsLib.readDataFromJSON("password");
		String URL = jsLib.readDataFromJSON("url");
		String BROWSER = jsLib.readDataFromJSON("browser");
		
		String lastName = eLib.getExcellData("Sheet1", 1, 2);
		
		
		//Launch the browser
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		}else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			System.out.println("browser invalid");
		}
		
		
		
		wLib.maximiseWindow(driver);
		
		driver.get(URL);
	
		//login to application
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//click on contacts
		
		driver.findElement(By.linkText("Contacts")).click();
		
		//click on create contact link
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//create contact
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		//switch to child window
		
		wLib.switchToWindow(driver, "Accounts");
		
		
		//driver.findElement(By.id("search_text")).click();
		
		driver.findElement(By.linkText("ACC4")).click();
		//switch to parent window
		
		Thread.sleep(2000);
		wLib.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//logout
		
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseOver(driver, ele);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	   
		
		
		
	}


}
