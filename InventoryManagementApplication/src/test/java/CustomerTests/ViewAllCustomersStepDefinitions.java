package CustomerTests;

import Inventory.Management.DAO.CustomerDAO;
import Inventory.Management.Persistence.Customer;
import Inventory.Management.Persistence.DatabaseConnection;
import ResetDatabaseQueries.ResetDatabase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewAllCustomersStepDefinitions {

    private List<Customer> actualCustomers = new ArrayList<>();
    DatabaseConnection inventoryDatabase = new DatabaseConnection();
    CustomerDAO customerDAO = new CustomerDAO();

    @Given ("a database with customer details")
    public void customerDatabaseCreation(){
        ResetDatabase resetDatabase = new ResetDatabase(inventoryDatabase);
        resetDatabase.reset();
    }

    @When("I ask to view all customer details")
    public void getCustomerDetails() {
        actualCustomers = customerDAO.getAllCustomers();
    }

    @Then("the list of all of the customers is returned")
    public void showCustomerDetails() {
        List<Customer> expectedCustomers = new ArrayList<>();
        Customer customer1 = new Customer(1, "Emily", "emily@email.com");
        Customer customer2 = new Customer(2, "John", "john@email.com");
        Customer customer3 = new Customer(3, "Joe", "joe@email.com");
        expectedCustomers.add(customer1);
        expectedCustomers.add(customer2);
        expectedCustomers.add(customer3);

        assertEquals(expectedCustomers, actualCustomers);

    }

}
