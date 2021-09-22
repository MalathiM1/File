package com.crm.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.JSONFileUtility;
import com.crm.autodesk.GenericLibraries.WebDriverUtility;

public class LenzKart {

	@Test
	public void lenzKartPrint() throws Throwable
	{
		
		
		//WebDriverUtility wLib = new WebDriverUtility();
		//JSONFileUtility jsLib = new JSONFileUtility();
		
	//	String URL = jsLib.readDataFromJSON("url");
		//String BROWSER = jsLib.readDataFromJSON("browser");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	//	wLib.waitForPageLoad(driver);
		
	//	wLib.maximiseWindow(driver);
		
		driver.get("https://www.lenskart.com/");
		
		driver.findElement(By.name("q")).sendKeys(" ");
		Thread.sleep(2000);
		List<WebElement> ele = driver.findElements(By.xpath("//ul[@class='trending_list menu-link']"));
		
		for(WebElement wb:ele)
		{
			
			String result=wb.getText();
			System.out.println(result);
			
		}
			
		
		
		
		
	}
	
		
		
		
		
	

}
