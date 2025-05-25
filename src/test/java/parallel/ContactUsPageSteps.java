package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.ContactUsPage;
import com.qa.opencart.utils.ExcelUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ContactUsPageSteps {
	
	String contactUsPageTitle;
	
	private ContactUsPage contactPage = new ContactUsPage(DriverFactory.getDriver());
	
	@Given("user is on contact us page")
	public void user_is_on_contact_us_page() {
	 DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=information/contact");
	}

	@When("user gets the page title")
	public void user_gets_the_page_title() {
	    contactUsPageTitle = contactPage.getPageTitle();
	}

	@SuppressWarnings("deprecation")
	@Then("the title should be {string}")
	public void the_title_should_be(String expectedTitle) {
	    Assert.assertEquals(expectedTitle, contactUsPageTitle);
	}

	@When("user fills the form from sheet {string} and rownumber {int}")
	public void user_fills_the_form_from_sheet_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelUtility exlUtil = new ExcelUtility();
		
			List<Map<String, String>> testData = exlUtil.getData("./src/test/resources/testdata/automation.xlsx", sheetName);
			
			String name = testData.get(rowNumber).get("name");
			String email = testData.get(rowNumber).get("email");
			String enquiry = testData.get(rowNumber).get("enquiry");
			contactPage.fillContactUsPage(name, email, enquiry);
	}

	@When("user clicks on the submit button")
	public void user_clicks_on_the_submit_button() {
	    contactPage.submitForm();
	}

	@SuppressWarnings("deprecation")
	@Then("message {string} is displayed")
	public void message_is_displayed(String expectedMessage) {
		String actualMessage = contactPage.getSuccessMsgConfirmation();
		Assert.assertEquals(expectedMessage, actualMessage);
	    
	}

}
