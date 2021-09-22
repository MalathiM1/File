package com.crm.autodesk.pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.ElementRepository.HomePage;
import com.crm.autodesk.ElementRepository.OrganisationPage;
import com.crm.autodesk.GenericLibraries.BaseClass;

public class TC_CreateOrganizationTestDataProvider extends BaseClass
{
	@DataProvider
	public Object[][] getData()
	{
		return eLib.getExcellData("Sheet1");
	}
		@Test(dataProvider="getData")
		public void createOrgTestDataProvider(String OrgName,String IndType)
		{
			HomePage hp=new HomePage(driver);
			hp.clickOnOrganizations();
			
			OrganisationPage orgp=new OrganisationPage(driver);
			orgp.clic
		}
		private void new OrganisationPage(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}
	
	

}
