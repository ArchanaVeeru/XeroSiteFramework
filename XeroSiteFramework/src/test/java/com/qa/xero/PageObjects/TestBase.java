package com.qa.xero.PageObjects;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.xero.Utilities.ReadConfig;

public class TestBase {
	static {
	    System.setProperty("log.timestamp", 
	        new  SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date()));
	}
	public static WebDriver driver;
	ReadConfig readConfig=new ReadConfig();
	//public String url=readConfig.getUrl();
	//public String baseUrl=readConfig.getChromePath();
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) throws IOException {
		
		
		//System.out.println("chromepath is "+readConfig.getChromePath());
		
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options=new ChromeOptions();
			options.setBinary("C:\\Users\\ArchanaVeeru\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\ArchanaVeeru\\chromedriver");
			
			System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
			driver=new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",readConfig.getIEPath());
			driver=new InternetExplorerDriver();
		}
		
		
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("url is "+readConfig.getUrl());
		driver.get(readConfig.getUrl());
	
		logger=Logger.getLogger("xerosite");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("opening browser");
	}
	
  @AfterClass
  public void tearDown() {
	  driver.quit();
  }
  
  public void captureScreen(WebDriver driver,String tname) throws IOException
  {
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File source=ts.getScreenshotAs(OutputType.FILE);
	  String target=System.getProperty("user.dir")+"/Screenshots/"+tname+".png";
	  File destination=new File(target);
	  FileUtils.copyFile(source, destination);
	  System.out.println("Screenshot taken");
	  
	  
  }
}
