Feature: Searching feature in Tutorials Ninja 

Scenario Outline: Searching a product in Tutorials Ninja
 
Given the user is on product search page
When user tries to search a product "<keyword>" in the product page
And based on the product "<resultstatus>"
Then proper details of the product or error message should be displayed

Examples:
| keyword | resultstatus |
| iPhone  | contain      |
| Samsung | contain      |
| Nike    | not contain  |