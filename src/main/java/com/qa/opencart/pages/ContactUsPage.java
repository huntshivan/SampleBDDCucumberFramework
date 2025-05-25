package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementsUtility;

public class ContactUsPage {
	
	private WebDriver driver;
	private ElementsUtility eleUtil;
	
	private By name = By.id("input-name");
	private By email = By.id("input-email");
	private By enquiry = By.id("input-enquiry");
	private By submitBtn = By.xpath("//input[@value = 'Submit']");
	private By successMsg = By.xpath("//div[@id='content']/p");
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementsUtility(driver);
	}
	
	public String getPageTitle() {
		return eleUtil.waitForTitleIs("Contact Us", 10);
	}
	
	public void fillContactUsPage(String uname, String uemail, String uenquiry) {
		eleUtil.doSendKeys(name, uname, 10);
		eleUtil.doSendKeys(email, uemail, 10);
		eleUtil.doSendKeys(enquiry, uenquiry, 10);
	}
	
	public void submitForm() {
		eleUtil.doClick(submitBtn, 10);
	}
	
	public String getSuccessMsgConfirmation() {
		return eleUtil.waitForElementPresence(successMsg, 10).getText();
	}

}
