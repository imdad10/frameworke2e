Feature: Login into Application

Scenario Outline: Positive test validation login
Given Initialise the browser with chrome
And Navigate to "http://www.qaclickacademy.com/" site
And Click on login link in home page to land on secure sign in page
When User enters <username> and <password> and logs in
Then Verify that user is succesfully logged in
And close the browser

Examples:
|username                |password    |
|pathanimdad222@gmail.com   |Ikp987@123  |
|testing@gmail.com       |12344       |