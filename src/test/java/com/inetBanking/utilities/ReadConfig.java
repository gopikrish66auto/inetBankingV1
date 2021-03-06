package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() 
	{
			File src = new File("./Configurations/config.properties");
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		}catch (Exception e) 
		{
			
			Log.error("Exception is " + e.getMessage());
		}
		
	}
	
	public String getBaseurl() 
	{
		String baseURL = pro.getProperty("baseURL");
		return baseURL;
		
	}
	
	
	public String getUsername() 
	{
		String username = pro.getProperty("username");
		return username;
		
	}
	
	public String getPassword() 
	{
		String password = pro.getProperty("password");
		return password;
		
	}

	public String getChromepath() 
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
		
	}
	
	public String getIEpath() 
	{
		String iepath = pro.getProperty("iepath");
		return iepath;
		
	}

}
