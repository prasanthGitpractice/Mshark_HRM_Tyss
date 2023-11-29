package com.Practice_Package;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJsonDataTest 
{

	public static void main(String[] args) throws Throwable 
	{	
		FileReader filePath=new FileReader(".\\src\\test\\resources\\JsonTestData.json");
		//Json Parser is used to read/write json formatted data
		JSONParser jsonp=new JSONParser();
		Object obj=jsonp.parse(filePath);
		
		//read data from json file
		JSONObject map=(JSONObject)obj;
		
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
	}

}
