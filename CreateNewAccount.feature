Feature: Create Account function - Salesforce application

Scenario: Create new account using App Launcher with my name as Account name

Given Launch the chrome browser
And Load the Salesforce url
And Enter the username as vidyar@testleaf.com
And Enter the password
When Click Login button
Then should be able to login
And  Click on toggle menu button from the left corner 
And Click view All and click Sales from App Launcher
And Click on Accounts tab 
And Click on New button
And  Enter Sindhuja as account name
And  Select Ownership as Public   
And Click save and verify Account name 
Then The Account name displayed in the screen should be Sindhuja