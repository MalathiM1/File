package com.crm.autodesk.GenericLibraries;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listeners implements ITestListener
{
   private  ExtentReports reports;//attach the reporter
     private ExtentTest test;//to make evtreis of test cases and logs
	public void onTestStart(ITestResult result) {
		
		test=reports.createTest(result.getMethod().getMethodName());
		// TODO Auto-generated method stub
		
	}

	

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+"is Failed");
		test.log(Status.FAIL, result.getThrowable());
		
		
		BaseClass bug=new BaseClass();
		
		{
			try {
				String p = bug.getScreenshot(result.getMethod().getMethodName());
				test.addScreenCaptureFromPath(p);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP, result.getMethod().getMethodName()+"is SKIPPED");
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReportsSDET21/ExtentReports1.html");
		reporter.config().setDocumentTitle("SDET21");
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("BuildNo", "5.1");
		reports.setSystemInfo("Env", "pre-prod");
		reports.setSystemInfo("PlatForm", "Windows");
		reports.setSystemInfo("Browser Version", "Chrome-93");
		
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		
		reports.flush();
		// TODO Auto-generated method stub
		
	}



	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
