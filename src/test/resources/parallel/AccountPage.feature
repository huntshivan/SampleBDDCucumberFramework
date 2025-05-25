Feature: Verify user account page

	Background:
		Given User is logged in to the app
		|Username|Password|
		|shivansharma07@gmail.com|Selenium@12345|
	@smoke
  Scenario: Account Page Title
  	Given user is on Account page
    When User gets the account page title
    Then account page title should be "My Account"
	@Regression
  Scenario: My Account Options
    Given user is on Account page
    When user gets list of options available
    Then list of options is displayed
    |My Account|
    |Edit Account|
    |Password|
    |Address Book|
    |Wish List|
    |Order History|
    |Downloads|
    |Recurring payments|
    |Reward Points|
    |Returns|
    |Transactions|
    |Newsletter|
    |Logout|
    And total list items is 13