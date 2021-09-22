package com.crm.practice;

import com.crm.autodesk.GenericLibraries.JSONFileUtility;
import com.crm.autodesk.GenericLibraries.JavaUtility;

public class DemoFileReader {
	
	public static void main(String[] args) throws Throwable
	{
		JSONFileUtility jsonlib = new JSONFileUtility();
		
		JavaUtility jlib=new JavaUtility();
		String value = jsonlib.readDataFromJSON("url");
		System.out.println(value);
	}


}
