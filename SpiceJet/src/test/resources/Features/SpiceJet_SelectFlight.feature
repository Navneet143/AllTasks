Feature: select any flight and choose spicemax radio button

Background: user is on spiceJet flight search page
Given user is on spiceJet welcome board page
When user select "DEL" and "BLR" cities
And user select "20-April-2022" from calender
And user click on search flight
Then user nevigate to flights page

Scenario Outline: validate spiceJet flight search page

Given user is on spiceJet flight search page
When user select any flight
And user select "<Flight_Type>" and fetch flight number and price
And user click on continue button
Then user navigate to passengers page

Examples:
| Flight_Type         | 
| Spicemax            |
|	Spicesaver					|
|	Spiceflex		      	|