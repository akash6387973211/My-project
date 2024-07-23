
Feature: Check form
  Background:
    Given Set chrome WebDriver
  Scenario: Launch url


  Scenario Outline: Fill form
    Given Launch dse URL at "<url>"
    When user enter name "<username>" and email "<email>" and contact no "<contactNo>"
    Then click on submit button and verify thank you msg
    Examples:
      |url                                   |username|email         |contactNo|
      | https://www.squareyards.ca/new-homes |test    |test@gmail.com|1111111111|
      | https://www.squareyards.ca/new-homes/on |test    |test@gmail.com|1111111111|
      | https://www.squareyards.ca/new-homes/on/toronto|test |test@gmail.com|1111111111|
      | https://www.squareyards.ca/new-homes/on/toronto/waterfront-communities|test    |test@gmail.com|1111111111|
      | https://www.squareyards.ca/new-homes/on/york/vaughan|test    |test@gmail.com|1111111111|








