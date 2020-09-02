Feature: Create use cases

  Scenario Outline: 3.1 Create five use cases
    Given I open QA SandBox
    And I click on the Login button
    When I login into QASandbox portal as "Vladimir Nikolic"
    Then I can see the 'Sandbox' navigation tab
    And I open 'Use Cases' navigation tab
    When I select Create Use Case
    Then I create new Case with <title> and <description> and <expected_result> and <steps>
    And I log out

    Examples:
      | title                                       | description                                    | expected_result           | steps                                                                                                                               |
      | "Login to QA SendBox"                       | "Login with valid credentials to QA SendBox"   | "User login successfully" | "I open QA SandBox,I click on the Login button,I login into QASandbox portal as user,I can see the Sandbox navigation tab,I logout" |
      | "Delete button in input fields don't work"  | "Login with valid credentials to QA SendBox"   | "User login successfully" | "I open QA SandBox,I click on the Login button,I login into QASandbox portal as user,I can see the Sandbox navigation tab,I logout" |
      | "Login to QA SendBox with invalid email"    | "Login with invalid credentials to QA SendBox" | "Error message appeared"  | "I open QA SandBox,I click on the Login button,I login into QASandbox portal as user,I got error message"                           |
      | "Login to QA SendBox with invalid password" | "Login with invalid credentials to QA SendBox" | "Error message appeared"  | "I open QA SandBox,I click on the Login button,I login into QASandbox portal as user,I got error message"                           |
      | "Login to QA SendBox with wrong password"   | "Login with invalid credentials to QA SendBox" | "Error message appeared"  | "I open QA SandBox,I click on the Login button,I login into QASandbox portal as user,I got error message"                           |