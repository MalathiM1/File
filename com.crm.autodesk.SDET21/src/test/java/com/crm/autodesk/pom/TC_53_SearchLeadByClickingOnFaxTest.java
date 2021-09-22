package com.crm.autodesk.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.ElementRepository.CreateLeadPage;
import com.crm.autodesk.ElementRepository.HomePage;
import com.crm.autodesk.ElementRepository.LeadPage;
import com.crm.autodesk.ElementRepository.LoginPage;
import com.crm.autodesk.GenericLibraries.BaseClass;
import com.crm.autodesk.GenericLibraries.ExcelFileUtility;
import com.crm.autodesk.GenericLibraries.JSONFileUtility;
import com.crm.autodesk.GenericLibraries.JavaUtility;
import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class TC_53_SearchLeadByClickingOnFaxTest extends BaseClass{

	
	@Test(groups="RegressionSuite")
	
	public void SearchLeadByClickingOnFax() throws Throwable
	{
		int FaxNo = eLib.getintExcellData("Sheet1", 1, 4);
		
		

		//navigate to lead page
		
		HomePage hp=new HomePage(driver);
		hp.clickOnLeads();
		
		//navigate to go to Advanced search
		
		LeadPage lp1=new LeadPage(driver);
		lp1.clickOnAdvanceSearch();
		
		
		//navigate to solution
		
		lp1.solution();
		
		WebElement lpar = driver.findElement(By.name("fcol0"));
		wLib.select(driver, lpar, "Fax" );
		lp1.clickonCreateddate();
		
		 Thread.sleep(2000);
        
		
		lp1.none();
		
		WebElement lpn = driver.findElement(By.name("fop0"));
		wLib.select(driver, lpn, "equals" );
		
		lp1.clickOnEquals();
		
		
		
		CreateLeadPage leadp=new CreateLeadPage(driver);
		leadp.clickonFaxnoEdt(FaxNo);
		
		
		
		

		
		
		Thread.sleep(5000);
		
		
		lp1.clickOnsearchnow();
		
		
		
	}
}
