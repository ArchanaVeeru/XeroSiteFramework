package com.qa.xero.Testcases;


import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.qa.xero.PageObjects.LoginPage;
import com.qa.xero.PageObjects.TestBase;

public class LoginTest extends TestBase{
	
	
  @Test
  public void logIn() throws IOException, InterruptedException {
	  LoginPage login=new LoginPage(driver);
	  login.clickLogin();
	  logger.info("entering username and password");
	  login.setUserName("archana.mca19@gmail.com");
	  login.setPassword("veeru146");
	  login.clickSubmit();
	  logger.info("submitted");
	 String title=driver.getTitle();
	 Thread.sleep(2000);
//	 if(title.equals("Xero | Dashboard | Nothing")) {
//		Assert.assertTrue(true);
//		logger.info("login successful");
//	 }
//	 else
//	 {
//		// captureScreen(driver,"logIn");
//		 Assert.assertTrue(false);
//		 logger.info("login failed");
//	 }
	 //driver.switchTo().frame(0);
	  login.clickAg();
	  login.logout();
	 //Assert.assertEquals(title,"Xero | Dashboard | Nothing","assert failed");
  }
}
