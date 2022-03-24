Feature: fill passenger details

  Background: 
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

  Scenario Outline: validate spiceJet passengers page
    Given user is on spiceJet passengers page
    When user fill contact details "<fname>","<lname>","<phoneno>","<email>"and "<city>"
    And  user fill passenger information "<p_fname>","<p_lname>" and "<p_phoneno>"
    And click on continue button
    Then user navigate to next page

Examples:
| fname     |     lname   |   phoneno    |  email       |  city   |   p_fname      |  p_lname |  p_phoneno   |  
| Akshay    |     Kumar   |  9876654321  |  abc@xyz.com |  xxxxxx |   Salman       |   Khan   |  9876544421  |