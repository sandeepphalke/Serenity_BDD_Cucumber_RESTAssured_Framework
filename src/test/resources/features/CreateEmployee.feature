Feature: This has all possible scenarios for creating employee

  Scenario: Create an employee for company 
  Given User set the header "Content-Type" as "application/json"
  When  User set the request body as "createEmployee"
  And   User create an employee
  Then  User get status code as "200"
  And   User get "status" as "success" in response body
  And   User get "message" as "Successfully! Record has been added." in response body