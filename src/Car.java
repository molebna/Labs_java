import java.util.Date;

class Car {
    private String brand;
    private String model;
    private Date manufactureDate;
    private String classType;
    private double price;

    public Car(String brand, String model, Date manufactureDate, String classType, double price) {
        this.brand = brand;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.classType = classType;
        this.price = price;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public Date getManufactureDate() { return manufactureDate; }
    public String getClassType() { return classType; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Car{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", manufactureDate=" + manufactureDate + ", classType='" + classType + '\'' + ", price=" + price + '}';
    }
}