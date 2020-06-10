package com.qa.xero.PageObjects;

import java.util.List;

import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.FindFailed;
//import org.sikuli.script.Screen;

//import org.sikuli.api.Screen;
//import org.sikuli.api.Screen;

public class SignUpForm {
	
	@CacheLookup
	@FindBy(linkText="Free trial")
	WebElement freetrial;
	
	@CacheLookup
	@FindBy(how=How.NAME,using="FirstName")
	WebElement firstName;
	
	@CacheLookup
	@FindBy(name="LastName")
	WebElement lastName;
	
	@CacheLookup
	@FindBy(name="EmailAddress")
	WebElement email;
	
	@CacheLookup
	@FindBy(name="PhoneNumber")
	WebElement phonenum;
	
	@CacheLookup
	@FindBy(name="LocationCode")
	WebElement location;
	
	@CacheLookup
	@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
	WebElement robot;
	

	@CacheLookup
	@FindBy(name="TermsAccepted")
	WebElement agrement;
	
	@CacheLookup
	@FindBy(xpath="//span[@class='g-recaptcha-submit']")
	WebElement start;
	
	@FindBy(linkText="Go to inbox")
	WebElement text;
	
	
	
	
	WebDriver ldriver;
	
	public SignUpForm(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	public void clickFreetrail() {
		freetrial.click();
	}
	
	public void enterFirstname(String fname) {
		firstName.clear();
		firstName.sendKeys(fname);
	}
	
	public void enterLastname(String lname) {
		lastName.clear();
		lastName.sendKeys(lname);
	}
	
	public void enterEmail(String email1) {
		email.clear();
		email.sendKeys(email1);
	}
	
	public void enterPhone(String phone) {
		phonenum.clear();
		phonenum.sendKeys(phone);
	}
	
	public void selectState(String value) {
		//phonenum.clear();
		//location.sendKeys(String.valueOf(phone));
		Select state=new Select(location);
		state.selectByValue(value);
		
	}
	
	public void clickRobot()  {
//		try {
//		Screen s=new Screen();
//		//Pattern img=new Pattern("C:\\Users\\ArchanaVeeru\\eclipse-workspace\\XeroSiteFramework\\Images\\robot.jpg");
//		s.wait("C:\\Users\\ArchanaVeeru\\eclipse-workspace\\XeroSiteFramework\\Images\\robot.jpg",10);
//		s.click();
//		}
//		catch(FindFailed e) {
//			e.printStackTrace();
//		}
//				
		//robot.click();
	}
	
	public void clickagrement() {
		agrement.click();
	}
	
	public void clickGetStarted() {
		start.click();
	}
	
	public boolean getpageText() {
		return text.isDisplayed();
	}

}
