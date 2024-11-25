
public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int productId, String productName, double price) {
        this.id = productId;
        this.name = productName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}