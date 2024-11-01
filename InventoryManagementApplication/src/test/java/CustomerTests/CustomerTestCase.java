package CustomerTests;

import Inventory.Management.DAO.CustomerDAO;
import Inventory.Management.Persistence.Customer;
import Inventory.Management.Persistence.DatabaseConnection;
import ResetDatabaseQueries.ResetDatabase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTestCase {

    DatabaseConnection inventoryDatabase = new DatabaseConnection();

    @Test
    void addNewCustomer(){
        ResetDatabase database = new ResetDatabase(inventoryDatabase);
        database.reset();

        Customer newCustomer = new Customer("Jess", "jess@email.com");

        CustomerDAO customerDAO = new CustomerDAO();
        boolean returnedValue = customerDAO.addCustomer(newCustomer);
        boolean expectedValue = true;

        assertEquals(returnedValue, expectedValue);
    }

    @Test
    void getAllCustomersSize(){
        ResetDatabase database = new ResetDatabase(inventoryDatabase);
        database.reset();

        CustomerDAO customerDAO = new CustomerDAO();
        int returnedValue = customerDAO.getAllCustomers().size();
        int expectedValue = 3;

        assertEquals(returnedValue, expectedValue);
    }

    @Test
    void getAllCustomersData(){
        ResetDatabase database = new ResetDatabase(inventoryDatabase);
        database.reset();

        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> returnedCustomers = customerDAO.getAllCustomers();
        List<Customer> expectedCustomers = new ArrayList<>();
        Customer customer1 = new Customer(1, "Emily", "emily@email.com");
        Customer customer2 = new Customer(2, "John", "john@email.com");
        Customer customer3 = new Customer(3, "Joe", "joe@email.com");
        expectedCustomers.add(customer1);
        expectedCustomers.add(customer2);
        expectedCustomers.add(customer3);

        assertEquals(returnedCustomers, expectedCustomers);
    }

}
