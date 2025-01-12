Feature: Test button functionality
  Background:
  Given I am on DemoQAbuttons page

  Scenario: Test Double click button
    When  I click on the Double click button
    Then I see You have done Double click text

  Scenario: Test Button Right click functionality
    When  I click on the Right click button
    Then I see You have done a Right click text


  Scenario: Test Button Click Me functionality
    When  I click on the Click Me button
    Then I see You have done a dynamic click text

