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

public class TC_01_ProductTest {

	WebDriver driver=null;
	@Test
		
		public void ProductNum() throws Throwable {
			//read all the neccesery data
			
			WebDriverUtility wLib = new WebDriverUtility();
			JavaUtility jlib = new JavaUtility();
			JSONFileUtility jsLib = new JSONFileUtility();
			ExcelFileUtility eLib = new ExcelFileUtility();
		
			
			String USERNAME = jsLib.readDataFromJSON("username");
			String PASSWORD = jsLib.readDataFromJSON("password");
			String URL = jsLib.readDataFromJSON("url");
			String BROWSER = jsLib.readDataFromJSON("browser");
			
			String ProductName = eLib.getExcellData("Sheet1", 1, 1);
			double PartNumber = eLib.getintExcellData("Sheet1", 1, 2);
			
			
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
			
			//click on Products
			driver.findElement(By.xpath("//a[text()='Products']")).click();
			//click on create product
			driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
			//click on product name and pass the product name from excell sheet
			
			driver.findElement(By.name("productname")).sendKeys(ProductName);
			
			////click on part number and pass the product name from excell sheet
			driver.findElement(By.id("productcode")).sendKeys(""
					+PartNumber);
			
			//click on save
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			// again go to products click on search
			driver.findElement(By.xpath("//a[text()='Products']")).click();
			
			
			//click on part number by using dropdown
			WebElement ele = driver.findElement(By.id("bas_searchfield"));
			wLib.select(driver, ele, "Part Number");
			//click on search
			driver.findElement(By.name("search_text")).sendKeys(""+PartNumber);
			
			//click on search now
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			
			
			
	}
			
}
