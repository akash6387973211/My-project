Feature: Check MegaMenu

  Background:
    Given Set chrome WebDriver

  Scenario: Launch url
    Given Launch Dashboard UI

  Scenario Outline: Launch_top cities url
    Given Launch Beta URL at "<url>"
    When user clicks on top cities megamenu it should not return 404
    Examples:
      | url                         |
      | https://www.squareyards.ca/ |


  Scenario Outline: Launch all url
    Given Launch Beta URL at "<url>"
#    When wait until the page is being loaded
    When user opens page  it should not return 404
  Examples:
      | url|
      | https://www.squareyards.ca/|
      | https://www.squareyards.ca/new-homes |
      | https://www.squareyards.ca/new-homes/on |
      | https://www.squareyards.ca/new-homes/on/toronto |
      | https://www.squareyards.ca/new-homes/on/toronto/waterfront-communities |
      | https://www.squareyards.ca/new-homes/on/york/vaughan |
      | https://www.squareyards.ca/new-homes/on/toronto/annex/the-bedford-condos/325 |
      | https://www.squareyards.ca/sale |
      | https://www.squareyards.ca/sale/on |
      | https://www.squareyards.ca/sale/on/toronto  |
      | https://www.squareyards.ca/sale/on/york/vaughan   |
      | https://www.squareyards.ca/sale/on/york/vaughan/concord |
      | https://www.squareyards.ca/sale/on/toronto/etobicoke |
      | https://www.squareyards.ca/sale/on/houses-nearby-adelaide-street-east-sherbourne-street-c08-for-sale |
      | https://www.squareyards.ca/sale/on/toronto/houses-near-king-subway-church-yonge-corridor-c08-sws |
      | https://www.squareyards.ca/sale/on/toronto/houses-near-george-brown-college-st-james-campus-moss-park-c08-scs |
      | https://www.squareyards.ca/sale/on/toronto/houses-near-beacon-health-moss-park-c08-hsp |
      | https://www.squareyards.ca/sale/on/toronto/houses-near-184-front-street-east-moss-park-c08-shp |
      | https://www.squareyards.ca/sale/on/toronto/moss-park/158-front-st-e-unit-411 |
      | https://www.squareyards.ca/lease |
      | https://www.squareyards.ca/lease/on |
      | https://www.squareyards.ca/lease/on/toronto |
      | https://www.squareyards.ca/lease/on/york/vaughan |
      | https://www.squareyards.ca/lease/on/york/vaughan/concord |
      | https://www.squareyards.ca/lease/on/toronto/etobicoke |
      | https://www.squareyards.ca/lease/on/houses-nearby-adelaide-street-east-sherbourne-street-c08-for-lease |
      | https://www.squareyards.ca/lease/on/toronto/houses-near-king-subway-church-yonge-corridor-c08-sws |
      | https://www.squareyards.ca/lease/on/toronto/houses-near-george-brown-college-st-james-campus-moss-park-c08-scs |
      | https://www.squareyards.ca/lease/on/toronto/houses-near-beacon-health-moss-park-c08-hsp |
      | https://www.squareyards.ca/lease/on/toronto/houses-near-184-front-street-east-moss-park-c08-shp |
      | https://www.squareyards.ca/lease/on/toronto/waterfront-communities-c8/70-princess-st-unit-2108-e |
      | https://www.squareyards.ca/building-in-toronto |
      | https://www.squareyards.ca/building-in-toronto/waterfront-communities-c1/38-widmer-st |
      | https://www.squareyards.ca/neighbourhood-ontario-toronto |
      | https://www.squareyards.ca/neighbourhood-ontario-toronto/oakridge |
      | https://www.squareyards.ca/housing-market/on-toronto |
      | https://www.squareyards.ca/housing-market/on-toronto-waterfront-communities-c1 |
      | https://www.squareyards.ca/knowledge-center-toronto |
      | https://www.squareyards.ca/knowledge-center-toronto/building-construction |










