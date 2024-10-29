package Inventory.Management.Persistence;

public class Product {
    private final int productId;
    private String productName;
    private double productPrice;
    private String productDescription;
    private int quantityInStock;
    private static int nextProductId = 0;

    public Product(String productName, double productPrice, String productDescription, int quantityInStock) {
        this.productId = nextProductId++;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public static int getNextProductId() {
        return nextProductId;
    }

    public static void setNextProductId(int nextProductId) {
        Product.nextProductId = nextProductId;
    }

    @Override
    public String toString() {
        return "\nproductId=" + productId +
                "\nproductName='" + productName + '\'' +
                "\nproductPrice=" + productPrice +
                "\nproductDescription='" + productDescription + '\'' +
                "\nquantityInStock=" + quantityInStock;
    }
}

