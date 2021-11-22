Feature: Landing Page Validation

Scenario: Landing Page Validated Successfully

	Given Customer Launch Browser 
	When Customer Landing page 
	Then Landing Page text should be "How much can I borrow?" Page 
	And Enters Input to Personal Info for Loan eligibility
	
	Scenario: StartOver
	Given Click On StartOver Button
	
	Scenario:
	Given Enter Living Expenses Only
	
	

