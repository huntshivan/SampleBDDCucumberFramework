package parallel;

import java.util.List;
import java.util.Map;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class AccountPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage acctPage;
	String acctTitle;
	List<String> options;
	
	@Given("User is logged in to the app")
	public void user_is_logged_in_to_the_app(DataTable credData) {
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		List<Map<String, String>> cred = credData.asMaps();
		String user = cred.get(0).get("Username");
		String pass = cred.get(0).get("Password");
		acctPage = loginPage.doLogin(user, pass);
		
	}

	@Given("user is on Account page")
	public void user_is_on_account_page() {
		acctTitle = acctPage.getPageTitle();
	}

	@When("User gets the account page title")
	public void user_gets_the_page_title() {
		acctTitle = acctPage.getPageTitle();
	}

	@Then("account page title should be {string}")
	public void title_should_be(String expectedTitle) {
	    Assert.assertEquals(expectedTitle, acctTitle);
	}

	@When("user gets list of options available")
	public void user_gets_list_of_options_available() {
	    options = acctPage.getAcctOptions();
	}

	@SuppressWarnings("deprecation")
	@Then("list of options is displayed")
	public void list_of_options_is_displayed(DataTable optns) {
		List<String> items = optns.asList();
		Assert.assertTrue(options.equals(items));
	    
	}

	@SuppressWarnings("deprecation")
	@Then("total list items is {int}")
	public void total_list_items_is(int expectedCount) {
	    Assert.assertEquals(expectedCount, options.size());
	}

}
