package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.Log;

public class TC_LoginTest_001 extends BaseTestClass
{

	@Test
	public void loginTest() throws IOException {
		
//		driver.get(baseURL);
//		Log.info(this.getClass().getName()+"Loaded basurl:"+baseURL);
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		Log.info(this.getClass().getSimpleName() +"Entered username:"+username);
		
		lp.setPassword(password);
		Log.info("Entered password:"+password);
		lp.clickSubmit();
		
		Log.info("Clicked on login button");
		
		if(driver.getTitle().contains("Guru99")) {
			
			Assert.assertTrue(true);
			Log.info("Test Case is Passed");
		}
		else {
			captureScreen(driver, "logintest");
			Assert.assertTrue(false);
			Log.error("Test Case is Failed");
		}
		
	}
	
}
