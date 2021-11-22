$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./Features/CustomerLandingPage.feature");
formatter.feature({
  "line": 1,
  "name": "Landing Page Validation",
  "description": "",
  "id": "landing-page-validation",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Landing Page Validated Successfully",
  "description": "",
  "id": "landing-page-validation;landing-page-validated-successfully",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Customer Launch Browser",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Customer Landing page",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Landing Page text should be \"How much can I borrow?\" Page",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Enters Input to Personal Info for Loan eligibility",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.Launch_Browser()"
});
formatter.result({
  "duration": 7350445300,
  "status": "passed"
});
formatter.match({
  "location": "Steps.title_of_Landing_page()"
});
formatter.result({
  "duration": 22278400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "How much can I borrow?",
      "offset": 29
    }
  ],
  "location": "Steps.Text_On_Landing_Page(String)"
});
formatter.result({
  "duration": 5064675300,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Enter_Customer_Info()"
});
formatter.result({
  "duration": 2079124900,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "StartOver",
  "description": "",
  "id": "landing-page-validation;startover",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "Click On StartOver Button",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.Click_StartOverButton()"
});
formatter.result({
  "duration": 1203241600,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "",
  "description": "",
  "id": "landing-page-validation;",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "Enter Living Expenses Only",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.Loan_Eligibility_OnLivingExpenses_Only()"
});
formatter.result({
  "duration": 1295991700,
  "status": "passed"
});
});