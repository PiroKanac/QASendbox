Feature: Login to QA SendBox
 @Ignore
  Scenario Outline: 1.1 Login with valid credentials to QA SendBox
    Given I open QA SandBox
    And I click on the Login button
    When I login as <email> with password <password>
    Then I can see the 'Sandbox' navigation tab
    And I log out

 Examples:
   | email                   |  password |
   | "nikolic_vla@yahoo.com" |  "gzNfVHHPYUhh3Xx" |

 @Ignore
  Scenario Outline: 1.2 Login with invalid credentials to QA SendBox
    Given I open QA SandBox
    And I click on the Login button
    When I login as <email> with password <password>
    Then I got error <messages>
    Then I login into QASandbox portal as "<string>"
    Then I can see the 'Sandbox' navigation tab
    And I log out

    Examples:
      | email                  |  password | messages                                        |
      | ""                     |   ""      | "Email field is required\nPassword is required" |
      | ""                     |  "Test1!" | "Email field is required"                       |
      | "aa@a.com"             |  ""       | "Password is required"                          |
      | "aa@a.com"             |  "Tt111!" | "User not found"                                |
      | "nikolic_vla@yahoo.com"|  "Testt!" | "Password incorrect"                            |
