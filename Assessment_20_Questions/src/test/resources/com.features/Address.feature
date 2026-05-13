Feature: Address Book Feature

Scenario: Add a new address

Given user is logged into TutorialsNinja
When user adds a new address with following details
| firstname | John            |
| lastname  | Doe             |
| address1  | 123 Main Street |
| city      | Chennai         |
| postcode  | 600001          |
| country   | India           |
| region    | Tamil Nadu      |
Then address should be added successfully