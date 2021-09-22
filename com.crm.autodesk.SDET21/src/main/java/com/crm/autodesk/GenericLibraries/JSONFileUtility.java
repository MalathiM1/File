package com.crm.autodesk.GenericLibraries;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class JSONFileUtility {
	
	public String readDataFromJSON(String key) throws Throwable 
	{
		//read the data from JSON file
		FileReader file = new FileReader("./commonData.json");
		
		
		//convert the json file into java object
		JSONParser jsonobj=new JSONParser();
		Object jobj=jsonobj.parse(file);
		
		//typecast java obj to hashmap
		HashMap map = (HashMap)jobj;
		String value = map.get(key).toString();
		
		//return the value
		return value;
		
	}

	}


