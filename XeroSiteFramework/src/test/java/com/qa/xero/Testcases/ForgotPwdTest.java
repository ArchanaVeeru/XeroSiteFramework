package com.qa.xero.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.xero.PageObjects.ForgotPwd;
import com.qa.xero.PageObjects.TestBase;

public class ForgotPwdTest extends TestBase{
  @Test
  public void forgotPwdLink() {
	  ForgotPwd link=new ForgotPwd(driver);
	  driver.navigate().to("https://login.xero.com/");
	  link.clickForgotPwd();
	  logger.info("clicking on forgot password");
	  link.sendEmail("arcgfjg@gmail.com");
	  logger.info("entering email");
	  link.sendLink();
	  logger.info("clicking on link");
	  boolean text=link.verify();
	  if(text==true)
	  {
		  Assert.assertTrue(true);
		  logger.info("email link sent to reset password");
		  System.out.println("an email was sent");
	  }
	  else
	  {
		  logger.info("something went wrong, please enter correct email");
		  Assert.assertTrue(false);
	  }
  }
}
