package com.HRM.GenericUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtils 

{
	/**
	 * This method is used to read data from Property file
	 * @author PRASANTH
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.FilePath);
		Properties plib = new Properties();
		plib.load(fis);
		String value = plib.getProperty(key);		
		return value;		
	}
}
