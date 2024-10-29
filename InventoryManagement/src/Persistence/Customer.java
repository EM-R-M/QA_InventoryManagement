package Persistence;

public class Customer {

    private static int nextCustomerID = 0;
    private final int customerID;
    private String customerName;
    private String customerEmail;

    public Customer(String customerName, String customerEmail) {
        this.customerID = nextCustomerID++;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    public int getCustomerID() {
        return customerID;
    }

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
}
