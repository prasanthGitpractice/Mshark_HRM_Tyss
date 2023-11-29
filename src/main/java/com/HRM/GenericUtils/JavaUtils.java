package com.HRM.GenericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils 
{

	public int getRandomNO()
	{
		Random r = new Random();
		int random = r.nextInt();
		return random;
	}

	public String systemDate()
	{
		Date date = new Date();
		String systemdate = date.toString();
		return systemdate;
	}

	public String systemDateInFormat()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		Date date = new Date();
		String systemDateInFormat = sdf.format(date);
		return systemDateInFormat;
	}
}
