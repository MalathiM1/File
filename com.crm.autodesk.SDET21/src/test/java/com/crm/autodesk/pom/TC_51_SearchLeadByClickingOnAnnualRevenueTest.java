package com.crm.autodesk.pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ElementRepository.CreateLeadPage;
import com.crm.autodesk.ElementRepository.HomePage;
import com.crm.autodesk.ElementRepository.LeadPage;
import com.crm.autodesk.ElementRepository.LeadPageInfo;
import com.crm.autodesk.ElementRepository.LoginPage;
import com.crm.autodesk.GenericLibraries.ExcelFileUtility;
import com.crm.autodesk.GenericLibraries.JSONFileUtility;
import com.crm.autodesk.GenericLibraries.JavaUtility;
import com.crm.autodesk.GenericLibraries.WebDriverUtility;
@Listeners(com.crm.autodesk.GenericLibraries.Listeners.class)
public class TC_51_SearchLeadByClickingOnAnnualRevenueTest  {
WebDriver driver;
	
	@Test(groups="SmokeSuite")
	public void SearchLeadByClickingOnAnnualRevenue() throws Throwable
	{
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JSONFileUtility jsLib = new JSONFileUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		
		
		
		String USERNAME = jsLib.readDataFromJSON("username");
		String PASSWORD = jsLib.readDataFromJSON("password");
		String URL = jsLib.readDataFromJSON("url");
		String BROWSER = jsLib.readDataFromJSON("browser");
		
		
		int AnnualRev = eLib.getintExcellData("Sheet1", 1, 1);
		
		//CHOOSE THE BROWSER
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		
		}
		
		//load the url
		wLib.waitForPageLoad(driver);
		wLib.maximiseWindow(driver);
		driver.get(URL);
		
		//login to application
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME,PASSWORD);
		

		//navigate to lead page
		
		HomePage hp=new HomePage(driver);
		hp.clickOnLeads();
		
		//navigate to go to Advanced search
		
		LeadPage lp1=new LeadPage(driver);
		lp1.clickOnAdvanceSearch();
		
		
		//navigate to solution
		
		lp1.solution();
		
		WebElement lpar = driver.findElement(By.name("fcol0"));
		wLib.select(driver, lpar, "Annual Revenue" );
		lp1.clickonAnnualRevenue();
		
		
		 Thread.sleep(2000);
			
			lp1.none();
			
			WebElement lpn = driver.findElement(By.name("fop0"));
			wLib.select(driver, lpn, "equals" );
			
			lp1.clickOnEquals();
			
			
			
			CreateLeadPage leadp=new CreateLeadPage(driver);
			leadp.PassAnnualRev(AnnualRev);
			
			Thread.sleep(5000);
		
	
		lp1.clickOnsearchnow();
		
		
		hp.signOut(driver);
		
		
		
}
}