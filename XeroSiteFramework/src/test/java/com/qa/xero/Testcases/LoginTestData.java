package com.qa.xero.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.xero.PageObjects.LoginPage;
import com.qa.xero.PageObjects.TestBase;
import com.qa.xero.Utilities.ExcelFileRead;

public class LoginTestData extends TestBase {
	 @Test(dataProvider="getExcelData")
	  public void logIn(String uname,String pwd) throws IOException {
		  LoginPage login=new LoginPage(driver);
		 // login.clickLogin();
		  driver.navigate().to("https://login.xero.com/");
		  logger.info("entering username and password");
		  login.setUserName(uname);
		  login.setPassword(pwd);
		  login.clickSubmit();
		  logger.info("submitted");
		 // boolean flag=login.clickagain();
		  //System.out.println(wrong);
		  System.out.println(driver.getTitle());
		 
		  if(driver.getTitle().equals("Login | Xero Accounting Software")) {
			  
			  System.out.println("your entered username or password are wrong");
			  Assert.assertTrue(false);
			  }
		  else {
			  System.out.println("username and pawword are correct");
			 // driver.switchTo().frame(0);
			  login.clickAg();
			  login.logout();
		  }
		  
//		 String title=driver.getTitle();
//		 if(title.equals("Xero | Dashboard | Nothing")) {
//			Assert.assertTrue(true);
//			logger.info("login successful");
//		 }
//		 else
//		 {
//			// captureScreen(driver,"logIn");
//			 Assert.assertTrue(false);
//			 logger.info("login failed");
//		 }
		 //Assert.assertEquals(title,"Xero | Dashboard | Nothing","assert failed");
	  }
	 @DataProvider
	 public Object[][] getExcelData() throws IOException {
		 String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\qa\\xero\\testdata\\LogintestData.xlsx";
		 int rowcount=ExcelFileRead.getRowCount(path,"Sheet1");
		 int colcount=ExcelFileRead.getcolCount(path,"Sheet1",1);
		 Object[][] data=new Object[rowcount][colcount];
		 for(int i=1;i<=rowcount;i++) {
			 for(int j=0;j<colcount;j++) {
				 data[i-1][j]=ExcelFileRead.getCellData(path,"Sheet1",i,j);
			 }
			 
		 }
		return data;
		 
		 
		 
		 
		 
		 
		 
		 
	 }
}
