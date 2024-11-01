package Inventory.Management.Persistence;

import java.util.Objects;

public class Customer {

    private int customerID;
    private String customerName;
    private String customerEmail;

    public Customer(String customerName, String customerEmail) {
        this.customerID = -1;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    public Customer(int customerID, String customerName, String customerEmail) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {this.customerID = customerID; }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "\ncustomerID=" + customerID +
                "\ncustomerName='" + customerName + '\'' +
                "\ncustomerEmail='" + customerEmail + "\n";
    }


    /////////////////////////////////////////////////////////////
    //                EXPLANATION OF CODE BELOW                //
    /////////////////////////////////////////////////////////////
    // When attempting to "assertEquals" in the test cases, it //
    // was failing although the strings are identical. This is //
    // because Java will compare the memory addresses and not  //
    // the values themselves. By overriding this, it compares  //
    // the contents of the objects fields, letting them be     //
    // logically the same, although they're in two different   //
    // instances of memory.                                    //
    /////////////////////////////////////////////////////////////

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerID == customer.customerID &&
                Objects.equals(customerName, customer.customerName) &&
                Objects.equals(customerEmail, customer.customerEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, customerName, customerEmail);
    }

    /////////////////////////////////////////////////////////////
    //                     END OF SEGMENT                      //
    /////////////////////////////////////////////////////////////

}
