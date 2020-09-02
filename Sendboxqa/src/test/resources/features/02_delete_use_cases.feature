Feature: Delete Use Cases
  @Ignore
  Scenario: 2.1 Delete all use Cases
    Given I open QA SandBox
    And I click on the Login button
    When I login into QASandbox portal as "Vladimir Nikolic"
    Then I can see the 'Sandbox' navigation tab
    And I open 'Use Cases' navigation tab
    And I can delete all cases
