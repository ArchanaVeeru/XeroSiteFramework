package com.qa.xero.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@CacheLookup
	@FindBy(how=How.LINK_TEXT,using="Login")
	WebElement loginBtn;
	@CacheLookup
	@FindBy(how=How.ID,using="email")
	WebElement username;
	@CacheLookup
	@FindBy(id="password")
	WebElement password;
	@CacheLookup
	@FindBy(id="submitButton")
	WebElement submitBtn;
	@CacheLookup
	@FindBy(how=How.XPATH, using="//div[@class='x-boxed warning']")
	WebElement clickagain;
	
	@CacheLookup
	@FindBy(how=How.XPATH, using="//abbr[@class='xrh-avatar xrh-avatar-color-2']")
	WebElement clickAG;
	
	
	@CacheLookup
	@FindBy(how=How.LINK_TEXT, using="Log out")
	WebElement logout;
	WebDriver ldriver;
	
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	public void clickLogin() {
		loginBtn.click();
	}
	public void setUserName(String uname) {
		username.clear();
		username.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	public void clickSubmit() {
		submitBtn.click();
	}
	
	
	public boolean clickagain() {
		//if(clickagain) {
		
		boolean flag=clickagain.isDisplayed();
		System.out.println(flag);
		return flag;
		
	}
	
	public void clickAg() {
		clickAG.click();
	}
	
	public void logout() {
		logout.click();
	}
	
	
}
