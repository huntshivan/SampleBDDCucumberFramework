Feature: Login Feature

Background: 
	Given User is on opencart login page
	
@smoke
Scenario: Login page title
	When User gets the page title
	Then title should be "Account Login"
@smoke
Scenario: Valid user login
  When User enters a valid username
  And enters a valid password
  And click on Login
  And User gets the page title
  Then title should be "My Account"
