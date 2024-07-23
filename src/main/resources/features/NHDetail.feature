
Feature: Check Detail lead-form
  Background:
    Given Set chrome WebDriver
  Scenario: Launch url


  Scenario Outline: Fill Detail lead-form
    Given Launch detail URL at "<url>"
    When user enter name "<username>" and email "<email>" and contact no "<contactNo>"
    Then click on submit button and verify thank you msg
    Examples:
      |url                                                                                   |username|email         |contactNo|
      | https://www.squareyards.ca/new-homes/on/york/vaughan/beverley-glen/the-thornhill/155 |test    |test@gmail.com|1111111111|


  Scenario Outline: Fill gallery lead-form
    Given Launch detail URL at "<url>"
    When user clicks on image
    When user enter name "<username>" on gallery lead form and email "<email>" and contact no "<contactNo>"
    Then click on submit button and verify thank you msg
    Examples:
      |url                                                                                   |username|email         |contactNo|
      | https://www.squareyards.ca/new-homes/on/york/vaughan/beverley-glen/the-thornhill/155 |test    |test@gmail.com|1111111111|

   Scenario Outline: Check footer links
    Given Launch detail URL at "<url>"
     When user clicks on link
     Then it should not return error
   Examples:
     |url                                        |
     |https://www.squareyards.ca/new-homes/on/york/vaughan/elder-mills/the-towns-of-rutherford-heights/389|




