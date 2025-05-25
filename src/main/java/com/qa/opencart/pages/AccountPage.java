package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementsUtility;

public class AccountPage {
	
	private WebDriver driver;
	private ElementsUtility eleUtil;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementsUtility(driver);
	}
	
	private By acctOptions = By.xpath("//aside[@id='column-right']//a");
	
	public String getPageTitle() {
		return eleUtil.waitForTitleContains("My Account", 10);
	}
	
	public int getAcctOptionsCount() {
		return eleUtil.getElementsCount(acctOptions);
		
	}
	
	public List<String> getAcctOptions() {
		List<String> items = new ArrayList<String>();
		List<WebElement> acctOption = eleUtil.waitForElementsPresence(acctOptions, 10);
		for(WebElement e:acctOption) {
			String text = e.getText();
			items.add(text);
		}
		return items;
	}
	

}
