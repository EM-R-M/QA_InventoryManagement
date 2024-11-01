Feature: Customer Features

  Background: Customer Menu Options

  Scenario: Create Customer
    Given a Customer's details
    When I add a new customer
    Then the result is the customer being added to the database

  Scenario: View ALL Customer Details
    Given a database with customer details
    When I ask to view all customer details
    Then the list of all of the customers is returned