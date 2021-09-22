package com.crm.autodesk.GenericLibraries;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTryAnalyser implements IRetryAnalyzer{

	int count=0;
	int retryCount=3;

	public boolean retry(ITestResult result) 
		
		{
			while(count<retryCount)
			{
				count++;
				return true;
			}
		
		return false;
	}
}
