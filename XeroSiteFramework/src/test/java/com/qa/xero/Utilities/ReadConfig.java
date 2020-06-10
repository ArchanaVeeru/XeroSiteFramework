package com.qa.xero.Utilities;


import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	public ReadConfig() {
		try {
	
		FileInputStream fis=new FileInputStream("./Configurations/config.properties");
		prop=new Properties();
		prop.load(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getUrl() {
		String url=prop.getProperty("baseUrl");
		return url;
		
	}
	public String getUserName() {
		String username=prop.getProperty("username");
		return username;
	}
	public String password() {
		String password=prop.getProperty("password");
		return password;
	}
	public String getChromePath() {
		String chromePath=prop.getProperty("chromePath");
		return chromePath;
	}
	public String getFirefoxPath() {
		String firefoxPath=prop.getProperty("firefoxPath");
		return firefoxPath;
	}
	public String getIEPath() {
		String iePath=prop.getProperty("iePath");
		return iePath;
	}
	
//	public String getExcelFilePath() {
//		String path=prop.getProperty("excelFilePath");
//		return path;
//	}
	
	
}

