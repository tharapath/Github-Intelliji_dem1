Feature: Launch Google Page

  Scenario: Open Google homepage
    Given I open the browser
    When I navigate to Google
    Then I should see the Google homepage

  Scenario Outline: Search for a specific term in Google
    Given I am on the Google homepage
    When I search for "<search_term>"
    Then I should see search results for "<Result String>"

    Examples:
      | search_term       |Result String|
      | HDFC ERGO Plans    |HDFC        |
      | 10 lakh insurance | INSURANCE|
      | Optima Secure     | optima|
      | No claim bonus    | claim|
