Feature: Add Customer

  Background: Customer Menu Options

  Scenario: Create Customer
    Given a Customer's details
    When I add a new customer
    Then the result is the customer being added to the database