Feature: This has all possible scenarios for getting employees

  Scenario: Getting all employees from company 
  Given User get all employee
  Then  User get status code as "200"
  And   User get "message" as "Successfully! All records has been fetched." in response body
  And   User get "status" as "success" in response body