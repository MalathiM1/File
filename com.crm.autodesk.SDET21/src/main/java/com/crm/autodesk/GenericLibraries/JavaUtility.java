package com.crm.autodesk.GenericLibraries;

import java.util.Random;

/*This class contains to read datafrom java utility
 * @author malathi
 */

public class JavaUtility {
	/* this method generates random number */
	public int getRandom()
	{
		Random ran=new Random();
		int randomNum=ran.nextInt(1000);
		return randomNum;
	}

}
