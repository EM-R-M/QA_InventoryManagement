package CustomerTests;

import Inventory.Management.DAO.CustomerDAO;
import Inventory.Management.Persistence.Customer;

import Inventory.Management.Persistence.DatabaseConnection;
import ResetDatabaseQueries.ResetDatabase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCustomerStepDefinitions {

    private Customer customer;
    DatabaseConnection inventoryDatabase = new DatabaseConnection();
    CustomerDAO customerDAO = new CustomerDAO();

    @Given ("a Customer's details")
    public void givenCustomerDetails(){
        customer = new Customer("Terry", "terry@email.com");
    }

    @When ("I add a new customer")
    public void addNewCustomer(){
        ResetDatabase resetDatabase = new ResetDatabase(inventoryDatabase);
        resetDatabase.reset();
        customerDAO.addCustomer(customer);
    }

    @Then ("the result is the customer being added to the database")
    public void getTotalCustomers(){
        int expectedNoCustomers = 4;
        List<Customer> actualNoCustomers = customerDAO.getAllCustomers();
        assertEquals(expectedNoCustomers, actualNoCustomers.size());
    }

}
