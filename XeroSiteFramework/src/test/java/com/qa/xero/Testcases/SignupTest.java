package com.qa.xero.Testcases;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.xero.PageObjects.SignUpForm;
import com.qa.xero.PageObjects.TestBase;

public class SignupTest extends TestBase{
  @Test
  public void signupForm() throws InterruptedException {
	  SignUpForm signup=new SignUpForm(driver);
	  signup.clickFreetrail();
	  signup.enterFirstname("Hello");
	  signup.enterLastname("Hello");
	 // Thread.sleep(2000);
	  String email=randomEmail()+"@gmail.com";
	  String phone=randomphone();
	  signup.enterEmail(email);
	  signup.enterPhone(phone);
	 // Thread.sleep(2000);
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,500)");
	  signup.selectState("US");
	  //Thread.sleep(2000);
//	  signup.clickRobot();
//	  //Thread.sleep(2000);
//	  signup.clickagrement();
//	  signup.clickGetStarted();
//	  boolean text=signup.getpageText();
//	  if(text==true)
//	  {
//		  Assert.assertTrue(true);
//		  logger.info("Signed up successfully");
//	  }
//	  else {
//		  logger.info("sign up failed");
//		  Assert.assertTrue(false);
//	  }
//	  
  }
  
  public String randomEmail() {
	  String randomemail=RandomStringUtils.randomAlphabetic(6);
	  return(randomemail);
  }
  public String randomphone() {
	  String randomphone=RandomStringUtils.randomNumeric(10);
	  return randomphone;
  }
}
