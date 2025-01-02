Feature: Launch Google Page

  Scenario: Open Google homepage
    Given I open the browser
    When I navigate to Google
    Then I should see the Google homepage

Feature: Google Search Functionality
  Scenario Outline: Search for a specific term in Google
    Given I am on the Google homepage
    When I search for "<search_term>"
    Then I should see search results for "<search_term>"

    Examples:
      | search_term       |
      | HDFC ERGO plans   |
      | 10 lakh insurance |
      | Optima Secure     |
      | No claim bonus    |
