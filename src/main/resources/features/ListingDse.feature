
Feature: Check Listing Dse form
  Background:
    Given Set chrome WebDriver

  @smoke
  Scenario Outline: Fill Listing Dse form
    Given Launch dse URL at "<url>"
    When user enter name "<username>" and email "<email>" and contact no "<contactNo>"
    Then click on submit button and verify thank you msg
    Examples:
      |url                                   |username|email         |contactNo|
      | https://www.squareyards.ca/sale |test     |test@gmail.com|1111111111|
      | https://www.squareyards.ca/sale/on |test    |test@gmail.com|1111111111|
      | https://www.squareyards.ca/sale/on/toronto|test |test@gmail.com|1111111111|
      | https://www.squareyards.ca/sale/on/toronto/waterfront-communities-c1|test    |test@gmail.com|1111111111|
      | https://www.squareyards.ca/sale/on/york/vaughan|test    |test@gmail.com|1111111111|
      | https://www.squareyards.ca/sale/on/toronto/york|test    |test@gmail.com|1111111111|
      | https://www.squareyards.ca/sale/on/m5j|test    |test@gmail.com|1111111111|
      | https://www.squareyards.ca/neighbourhood-ontario-toronto/oakridge|test    |test@gmail.com|1111111111|
      | https://www.squareyards.ca/building-in-toronto/church-yonge-corridor/251-jarvis-st|test    |test@gmail.com|1111111111|


  Scenario Outline: new_testcase
    Given Launch dse URL at "<url>"
    When click on bed filter "<bed>"
    Then verify results at "<bed>"
    Examples:
      |url                                   |bed|
      | https://www.squareyards.ca/sale/on/toronto |2     |

    Scenario: Verify h1 of all pages
      Given  fetch community sale data from api
      Then I process the community sale data and verify h1 of every page

  Scenario: Verify h1 of all pages
    Given  fetch community lease data from api
    Then I process the community lease data and verify h1 of every page

  Scenario: Verify h1 of all pages
    Given  fetch municipality sale data from api
    Then I process the municipality sale data and verify h1 of every page

  Scenario: Verify h1 of all pages
    Given  fetch municipality lease data from api
    Then I process the municipality lease data and verify h1 of every page
