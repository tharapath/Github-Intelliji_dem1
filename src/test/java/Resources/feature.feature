Feature: Launch Google Page

  Scenario: Open Google homepage
    Given I open the browser
    When I navigate to Google
    Then I should see the Google homepage