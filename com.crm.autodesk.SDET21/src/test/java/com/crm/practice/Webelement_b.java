package com.crm.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.JSONFileUtility;

public class Webelement_b {
	WebDriver driver;
		
		@Test
		public void handlingDynamicWebtable() throws Throwable
		{
			JSONFileUtility jsonLib = new JSONFileUtility();
			String BROWSER = jsonLib.readDataFromJSON("browser");
			String URL = jsonLib.readDataFromJSON("url");
			String USERNAME = jsonLib.readDataFromJSON("username");
			String PASSWORD = jsonLib.readDataFromJSON("PASSWORD");
			
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
			driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(URL);
			
			//login to application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			//click on organization
			driver.findElement(By.linkText("Organizations")).click();
			
			//click on all the checkboxes
			List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name=selectall']"));
			
			for(int i=2;i<list.size();i++)
			{
				for(WebElement wb:list)
				{
					wb.click();
					
				}
				//click on last check box
				list.get(list.size()-1).click();
				
				/*//for clicking 5th element 
				 * for(int i=2;i<list.size();i++)
				 * list.get(i=6).click();     */   
				
				 
			}
		}
}
			


