package com.crm.autodesk.GenericLibraries;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*This class contains all the generic methods related to webdriver
 * @author malathi
 * 
 */

public class WebDriverUtility {
	/* this method will waot for the page load for 20 seconds
	 * @parameter driver
	 * 
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/*
	 * this method will maximize the window
	 */
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/*
	 * this method will select from the dropdown using visible text
	 * @param element
	 * @param valueS
	 */
	public void select(WebDriver driver, WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
		
	}
	/*
	 * this method is used for mouse over actions
	 * @parameter driver
	 * @parameter driver
	 */
	public void mouseOver(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	/*
	 * this method will double click
	 * @parameter driver
	 * @parameter element
	 *
	 */
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/*
	 * accept the alert popup
	 * @parameter driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/*
	 * this method will cancel the aler popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/*
	 * this method will switch to frame wrt to index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, String frameid)
	{
		driver.switchTo().frame(frameid);
	}
	/*
	 * this method will switch to frame wrt to element
	 * @param driver
	 * @param frameElement
	 */
	public void switchToWindow(WebDriver driver, String partialwinTitle)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		while(it.hasNext())
		{
			String winId = it.next();
			String actTitle = driver.switchTo().window(winId).getTitle();
			if(actTitle.contains(partialwinTitle))
			{
				break;
			}
		}
	}
	/*
	 * wait for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
}
