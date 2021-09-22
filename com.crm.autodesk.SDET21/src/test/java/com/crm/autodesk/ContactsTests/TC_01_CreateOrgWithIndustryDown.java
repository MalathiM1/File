package com.crm.autodesk.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.ExcelFileUtility;
import com.crm.autodesk.GenericLibraries.JSONFileUtility;
import com.crm.autodesk.GenericLibraries.JavaUtility;
import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class TC_01_CreateOrgWithIndustryDown {
@Test
	
	public void withIndustryTest() throws Throwable {
		
WebDriver driver = null;
		
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JSONFileUtility jsLib = new JSONFileUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		
		int randomInt = jLib.getRandom();
		
		String USERNAME = jsLib.readDataFromJSON("username");
		String PASSWORD = jsLib.readDataFromJSON("password");
		String URL = jsLib.readDataFromJSON("url");
		String BROWSER = jsLib.readDataFromJSON("browser");
		String orgName = eLib.getExcellData("Sheet1", 1, 3);
		
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
	
		//login 
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+randomInt);
		
		WebElement dd = driver.findElement(By.name("industry"));
		wLib.select(driver, dd, "Education");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
	}

}
