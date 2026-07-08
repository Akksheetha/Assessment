Feature: Registering in Demo web shop
@Register
Scenario: Register

Given the user is on demo web shop register page
When the user fills the credentials
|fname | lname | email          |
|akkshu|M      |akkshu345@gmail.com|
And fills the password and confirm password
|pass          |cpass        |
|Password@1234 |Password@1234|
When then user clicks the register button and then continue  
Then the user should be directed to the home page successfully