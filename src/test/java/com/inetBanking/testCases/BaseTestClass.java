package com.inetBanking.testCases;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.Log;
import com.inetBanking.utilities.ReadConfig;

public class BaseTestClass {
	
	public ReadConfig rc = new ReadConfig();
	public String baseURL = rc.getBaseurl();
	public String username = rc.getUsername();
	public String password = rc.getPassword();
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", rc.getChromepath());
			driver = new ChromeDriver();
			
		}
		else if (br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", rc.getIEpath());
			driver = new InternetExplorerDriver();
		}
//		System.setProperty("webdriver.chrome.driver", rc.getChromepath());
//		driver = new ChromeDriver();
		Log.info("Driver initialised");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		Log.info(this.getClass().getName()+"Loaded basurl:"+baseURL);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		Log.info("TearDown");
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
	
		
	

}
