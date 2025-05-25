package parallel;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	String title;
	
	@Given("User is on opencart login page")
	public void user_is_on_opencart_login_page() {
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@When("User gets the page title")
	public void user_gets_the_page_title() {
	    title = loginPage.getPageTitle();
	}
	
	@Then("title should be {string}")
	public void title_should_be(String expectedTitle) {
	    Assert.assertEquals(expectedTitle, title);
	}

	@When("User enters a valid username")
	public void user_enters_a_valid_username() {
	    loginPage.enterUserName("shivansharma07@gmail.com");
	}

	@When("enters a valid password")
	public void enters_a_valid_password() {
	    loginPage.enterPassword("Selenium@12345");
	}

	@When("click on Login")
	public void click_on_login() throws InterruptedException {
	    loginPage.submitLogin();
	    Thread.sleep(5000);
	}

//	@Then("User is successfully logged in")
//	public void user_is_successfully_logged_in() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}

}
