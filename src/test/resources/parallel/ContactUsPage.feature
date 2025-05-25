
Feature: Contact Us Feature

	@skip
  Scenario: Title of the page
    Given user is on contact us page
    When user gets the page title
    Then the title should be "Contact Us"
	@smoke
  Scenario Outline: Contact Us form submission
    Given user is on contact us page
    When user fills the form from sheet "<SheetName>" and rownumber <RowNumber>
    And user clicks on the submit button
    Then message "Your enquiry has been successfully sent to the store owner!" is displayed

    Examples: 
      |SheetName|RowNumber|
      |contactus |0|
      |contactus |1|
      |contactus |2|
