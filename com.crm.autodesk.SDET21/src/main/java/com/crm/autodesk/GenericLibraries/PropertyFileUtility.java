package com.crm.autodesk.GenericLibraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility{
	
	public String getpropertyFileData(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(Ipathconstants.PropertyFilePath);
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}
}

