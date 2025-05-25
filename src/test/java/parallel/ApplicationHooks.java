package parallel;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private Properties prop;
	
	@Before(value = "@skip", order = 0)
	public void skip_scenario(Scenario scenario) {
		System.out.println("SKIPPED SCENARIO is "+scenario.getName());
		Assume.assumeTrue(false);
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		driverFactory = new DriverFactory();
		prop = driverFactory.initProperties();
		String browserName = prop.getProperty("browser");
		if(browserName!=null) {
			prop.setProperty("browser", browserName);
		}
		driver = driverFactory.driverInIt(prop);
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}

}
