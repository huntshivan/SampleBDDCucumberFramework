package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.exceptions.MyException;

public class DriverFactory {
	
	protected static WebDriver driver;
	protected Properties prop;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver driverInIt(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		String highlight = prop.getProperty("highlight");
		
		System.out.println("Browser Name Passed: "+browserName);
		
		switch (browserName.toLowerCase().trim()) {
		
		case "chrome":
			tlDriver.set(new ChromeDriver());
			System.out.println("Chrome Browser Launched....");
			break;
			
		case "firefox":
			tlDriver.set(new FirefoxDriver());
			System.out.println("Firefox Browser Launched....");
			break;
			
		case "edge":
			tlDriver.set(new EdgeDriver());
			System.out.println("Edge Browser Launched....");
			break;

		default:
			System.out.println("Browser Passed Is Not A Valid Browser: "+browserName);
			throw new MyException("INVALID BROWSER NAME...");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	public Properties initProperties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/configs/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
