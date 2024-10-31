package CustomerTests;

import Inventory.Management.DAO.CustomerDAO;
import Inventory.Management.Persistence.Customer;
import Inventory.Management.Persistence.DatabaseConnection;
import ResetDatabaseQueries.ResetDatabase;
import org.junit.jupiter.api.Test;

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

}
