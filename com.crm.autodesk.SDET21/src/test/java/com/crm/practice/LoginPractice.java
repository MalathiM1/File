package com.crm.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.ElementRepository.LoginPage;
import com.crm.autodesk.GenericLibraries.JSONFileUtility;
import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class LoginPractice {
WebDriver driver;
	
	@Test
	public void handlingDynamicWebtable() throws Throwable
	{
		WebDriverUtility wLib=new WebDriverUtility();
		JSONFileUtility jsonLib = new JSONFileUtility();
		String BROWSER = jsonLib.readDataFromJSON("browser");
		String URL = jsonLib.readDataFromJSON("url");
		String USERNAME = jsonLib.readDataFromJSON("username");
		String PASSWORD = jsonLib.readDataFromJSON("password");
		
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
		
		System.out.println("login successfull");
	}//not correct

}
