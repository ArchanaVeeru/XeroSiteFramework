package com.qa.xero.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPwd {
	
	@CacheLookup
	@FindBy(linkText="Forgot your password?")
	WebElement forgot;
	
	@CacheLookup
	@FindBy(id="UserName")
	WebElement enteremail;
	
	@CacheLookup
	@FindBy(linkText="Send link")
	WebElement sendLink;
	
	@CacheLookup
	@FindBy(xpath="//div[@class='x-boxed noBorder']")
	WebElement verify;
	WebDriver ldriver;

	public ForgotPwd(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		}
	
	
	public void clickForgotPwd() {
		forgot.click();
	}
	
	public void sendEmail(String email)
	{
		enteremail.clear();
		enteremail.sendKeys(email);
	}
	
	public void sendLink() {
		sendLink.click();
	}
	
	public boolean verify() {
		return verify.isDisplayed();
	}
	
	
	
}
