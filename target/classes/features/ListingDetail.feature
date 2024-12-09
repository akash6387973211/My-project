
Feature: Check Listing Detail lead-form
  Background:
    Given Set chrome WebDriver
  Scenario: Launch url


  Scenario Outline: Fill Listing Detail lead-form
    Given Launch detail URL at "<url>"
    When user enter name "<username>" and email "<email>" and contact no "<contactNo>" on Listing detail lead form
    Then click on submit button and verify thank you msg
    Examples:
      |url                                                                                   |username|email         |contactNo|
      | https://www.squareyards.ca/sale/on/toronto/west-humber-clairville/125-alicewood-court-m9v-3y1 |test    |test@gmail.com|1111111111|

  Scenario Outline: Fill Listing detail gallery lead-form
    Given Launch detail URL at "<url>"
    When user clicks on Listing detail image
    When user enter name "<username>" on gallery lead form and email "<email>" and contact no "<contactNo>"
    Then click on submit button and verify thank you msg
    Examples:
      |url                                                                                   |username|email         |contactNo|
      | https://www.squareyards.ca/sale/on/toronto/kennedy-park/5-greystone-walk-dr-unit-1502|test    |test@gmail.com|1111111111|








