Feature: verify selected cities are displayed correctly and flight prices are same or not

  Background: user is on payment page
         Given user is on spiceJet welcome board page
    When user select "DEL" and "BLR" cities
    And user select "21-April-2022" from calender
    And user click on search flight
    Then user nevigate to flights page
    Given user is on spiceJet flight search page
    When user select any flight
    And user select "Spicemax" and fetch flight number and price
    And user click on continue button
    Then user navigate to passengers page
    Given user is on spiceJet passengers page
    When user fill contact details "Peter","Desuja","9876543211","abcd@pqr.com"and "Munbai"
    And  user fill passenger information "Remo","Desuja" and "9876543221"
    And click on continue button
    Then user navigate to next page
    Given user already fill passenger details and user is on Add-on page
    When user first select seat "2B"
    And user select meals "Dosa" and click on done button
    Then user nevigate to Add-on page
    And click on continue button again
    Then user nevigate to payment page

  Scenario: validate selected cities are displayed correctly and flight prices are same or not
    Given user is on payment page
    When user fetch data from payment page
    And verify the prices and cities name are same or not
    And verify prices without adding convenience fee
    Then user print message all test cases are correctlly done
