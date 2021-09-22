package com.crm.autodesk.GenericLibraries;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.autodesk.ElementRepository.HomePage;
import com.crm.autodesk.ElementRepository.LoginPage;
import com.google.common.io.Files;

public class BaseClass {
	
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jlib = new JavaUtility();
	public JSONFileUtility jsLib = new JSONFileUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public DataBaseUtility dLib =new DataBaseUtility();
	public WebDriver driver;
	public static WebDriver staticdriver; 
	
	
	@BeforeSuite(groups={"RegressionSuite","SmokeSuite"})
	public void ConnecttoDB() throws Throwable
	{
		//dLib.connectToDB();
	}
	
	@BeforeClass(groups={"RegressionSuite","SmokeSuite"})
	public void LaunchBrowser() throws Throwable
	{
		String USERNAME = jsLib.readDataFromJSON("username");
		String PASSWORD = jsLib.readDataFromJSON("password");
		String URL = jsLib.readDataFromJSON("url");
		String BROWSER = jsLib.readDataFromJSON("browser");
	
	//Launch the browser
	
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
				
			}
			else if (BROWSER.equalsIgnoreCase("firefox")) 
			{
				driver = new FirefoxDriver();
			}
			else 
			{
				System.out.println("browser invalid");
			}
			
			wLib.waitForPageLoad(driver);
			
			wLib.maximiseWindow(driver);
		    BaseClass.staticdriver=driver;
			driver.get(URL);
			
	}
	@BeforeMethod(groups={"RegressionSuite","SmokeSuite"})
	
	public void loginToAPP() throws Throwable 
	
	{
		String USERNAME = jsLib.readDataFromJSON("username");
		String PASSWORD = jsLib.readDataFromJSON("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME,PASSWORD);
		
		System.out.println("loggedin to application");
				
	    
	}
	
	@AfterMethod(groups={"RegressionSuite","SmokeSuite"})
	public void logoutOfApp()
	
	{
		HomePage hp=new HomePage(driver);
		hp.signOut(driver);
		
		System.out.println("loggedout to application");

	}
	
	@AfterClass(groups={"RegressionSuite","SmokeSuite"})
	
	public void closeBrowser()
	{
		driver.close();
		
	}
	
	@AfterSuite(groups={"RegressionSuite","SmokeSuite"})
	
	public void closeDB() throws Throwable
	
	{
		//dLib.closeDB();
	}
	
	public String getScreenshot(String name) throws Throwable 
	{
		File srcfile=((TakesScreenshot)staticdriver).getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File finaldest = new File(destFile);
//		FileUtils.copyFile(srcfile, finaldest);
		Files.copy(srcfile, finaldest);
		
		return destFile;
		
	}

}
