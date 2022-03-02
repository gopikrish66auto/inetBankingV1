package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.Log;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseTestClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) 
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		Log.info("user name provided");
		lp.setPassword(pwd);
		Log.info("password provided");
		lp.clickSubmit();
		
//		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Log.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			Log.info("Login passed");
			lp.clickLogout();
//			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String xpath=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		Log.info("Inside Data Provider");
		int rownum=XLUtils.getRowCount(xpath, "Sheet1");
		int colcount=XLUtils.getCellCount(xpath,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(xpath,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
}