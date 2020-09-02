$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:features/03_create_use_case.feature");
formatter.feature({
  "name": "Create use cases",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "3.1 Create five use cases",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I open QA SandBox",
  "keyword": "Given "
});
formatter.step({
  "name": "I click on the Login button",
  "keyword": "And "
});
formatter.step({
  "name": "I login into QASandbox portal as \"Vladimir Nikolic\"",
  "keyword": "When "
});
formatter.step({
  "name": "I can see the \u0027Sandbox\u0027 navigation tab",
  "keyword": "Then "
});
formatter.step({
  "name": "I open \u0027Use Cases\u0027 navigation tab",
  "keyword": "And "
});
formatter.step({
  "name": "I select Create Use Case",
  "keyword": "When "
});
formatter.step({
  "name": "I create new Case with \u003ctitle\u003e and \u003cdescription\u003e and \u003cexpected_result\u003e and \u003csteps\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "I log out",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "title",
        "description",
        "expected_result",
        "steps"
      ]
    },
    {
      "cells": [
        "\"Login to QA SendBox with wrong password\"",
        "\"Login with invalid credentials to QA SendBox\"",
        "\"Error message appeared\"",
        "\"I open QA SandBox,I click on the Login button,I login into QASandbox portal as user,I got error message\""
      ]
    }
  ]
});
formatter.scenario({
  "name": "3.1 Create five use cases",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open QA SandBox",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.iOpenTheQASandBox()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the Login button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.iClickOnTheLoginButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I login into QASandbox portal as \"Vladimir Nikolic\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.iLoginToCandidatePortal(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can see the \u0027Sandbox\u0027 navigation tab",
  "keyword": "Then "
});
formatter.match({
  "location": "NavigationSteps.iCanSeeTheTab(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I open \u0027Use Cases\u0027 navigation tab",
  "keyword": "And "
});
formatter.match({
  "location": "NavigationSteps.iOpenProfileTab(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select Create Use Case",
  "keyword": "When "
});
formatter.match({
  "location": "CreateUseCaseSteps.iSelectCreateUseCase()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I create new Case with \"Login to QA SendBox with wrong password\" and \"Login with invalid credentials to QA SendBox\" and \"Error message appeared\" and \"I open QA SandBox,I click on the Login button,I login into QASandbox portal as user,I got error message\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUseCaseSteps.iCreateNewCase(String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I log out",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.iLogOut()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});