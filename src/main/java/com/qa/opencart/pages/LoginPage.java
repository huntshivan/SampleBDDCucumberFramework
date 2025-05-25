package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementsUtility;

public class LoginPage {
	
	private WebDriver driver;
	private ElementsUtility eleUtil;
	
	private By email = By.id("input-email");
	private By pass = By.id("input-password");
	private By loginBtn = By.xpath("//input[@type='submit']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementsUtility(driver);
	}
	
	public String getPageTitle() {
		//String LoginPageTitle = eleUtil.waitForTitleContains("Account Login", 10);
		String pageTitle = driver.getTitle();
		System.out.println("Page Title: "+pageTitle);
		return pageTitle;
	}
	
	public void enterUserName(String uname) {
		eleUtil.doSendKeys(email, uname, 10);
	}
	
	public void enterPassword(String password) {
		eleUtil.doSendKeys(pass, password, 10);
	}
	
	public void submitLogin() {
		eleUtil.doClick(loginBtn, 10);
	}
	
	public AccountPage doLogin(String un, String pwd) {
		eleUtil.doSendKeys(email, un, 10);
		eleUtil.doSendKeys(pass, pwd, 10);
		eleUtil.doClick(loginBtn, 10);
		return new AccountPage(driver);
		
	}
}
