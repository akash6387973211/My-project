Feature: Check Dashboard Scenarios
  Background:
    Given Set chrome WebDriver

  Scenario: Launch_Dashboard_UI_Validation
    Given Launch Dashboard UI

  Scenario Outline: Launch_Beta_Dashboard
    Given Launch Beta URL at "<url>"
    Examples:
      |url|
      | https://www.browserstack.com  |





