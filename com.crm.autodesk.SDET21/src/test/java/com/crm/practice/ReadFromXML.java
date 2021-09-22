package com.crm.practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadFromXML {
	
	@Test
	public void readDataFromXML(XmlTest xml)
	{
		System.out.println(xml.getParameter("browser"));
		System.out.println(xml.getParameter("url"));
		
	}

}
