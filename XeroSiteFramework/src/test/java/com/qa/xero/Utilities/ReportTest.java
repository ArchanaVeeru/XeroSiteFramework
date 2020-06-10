package com.qa.xero.Utilities;


import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.xero.PageObjects.TestBase;

public class ReportTest extends TestListenerAdapter{
	
	ExtentHtmlReporter sparkReporter;
	ExtentReports extent;
	ExtentTest test;
//	 TestBase base=new TestBase();
//	WebDriver driver;
  @Test
 public void onStart(ITestContext testContext) {
	
	 
	String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	String repName="Test-Report-"+timeStamp+".html";
	sparkReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output//Extent-Reports/"+repName);
	sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	extent=new ExtentReports();
	extent.attachReporter(sparkReporter);
	extent.setSystemInfo("Host name","localhost");
	extent.setSystemInfo("Environment","QA");
	extent.setSystemInfo("user","Archana");
	
	sparkReporter.config().setDocumentTitle("xero site Testing");
	sparkReporter.config().setReportName("Functional Test");
	sparkReporter.config().setTheme(Theme.DARK);
	
  }
  
  public void onTestSuccess(ITestResult result) {
	  
	  test=extent.createTest(result.getName());
	  test.log(Status.PASS,"result is "+result.getName());
	 // test.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
	  
	  
  }
  public void onTestFailure(ITestResult result) {
	  test=extent.createTest(result.getName());
	  test.log(Status.FAIL,"result is "+result.getName());
	  //test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
	 // base.captureScreen(driver, result.getClass());
	 // System.out.println("name is "+result.getName());
	  //String screen=
	  String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
	  
	  File f=new File(screenshotPath);
	 // System.out.println(screenshotPath);
	  if(f.exists()) {
		  try {
			 // System.out.println(f);
			  test.fail("Screen shot is below "+test.addScreenCaptureFromPath(screenshotPath));
			 
			 // test.log(Status.FAIL,test.addScreenCaptureFromPath(screenshotPath));
			  
		  }
		  catch(IOException e) {
			  e.printStackTrace();
		  }
	  }
	  
  }
  public void onTestSkipped(ITestResult result) {
	  test=extent.createTest(result.getName());
	  test.log(Status.SKIP,"result is "+result.getName());
	  
  }
  public void onFinish(ITestContext context)
  {
	  extent.flush();
  }
}
