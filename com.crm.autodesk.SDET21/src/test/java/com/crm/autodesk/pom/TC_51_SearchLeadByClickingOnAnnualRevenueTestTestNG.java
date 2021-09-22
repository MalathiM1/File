package com.crm.autodesk.pom;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ElementRepository.CreateLeadPage;
import com.crm.autodesk.ElementRepository.HomePage;
import com.crm.autodesk.ElementRepository.LeadPage;
import com.crm.autodesk.ElementRepository.LeadPageInfo;
import com.crm.autodesk.GenericLibraries.BaseClass;
@Listeners(com.crm.autodesk.GenericLibraries.Listeners.class)
public class TC_51_SearchLeadByClickingOnAnnualRevenueTestTestNG extends BaseClass{

	
	@Test(groups="SmokeSuite", retryAnalyzer=com.crm.autodesk.GenericLibraries.ReTryAnalyser.class)
	public void SearchLeadByClickingOnAnnualRevenue(Object companyname) throws Throwable
	{
		
		
		int AnnualRev = eLib.getintExcellData("Sheet1", 1, 1);
		
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
		
		//verification
		//LeadPageInfo lpf=new LeadPageInfo(driver);
		//String actuallcompsny=lpf.getCompanynameinfo();
		//Assert.assertTrue(((String) lpf).contains(companyname));
		
		
		
		
		
		
}

}
