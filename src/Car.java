@Table(name = "cars")
public class Car {

    private int id;
    private String name;
    private double price;
    private String produser;
    private double speed;

    public Car(int carId, String carName, double price, String produser, double speed) {
        this.id = carId;
        this.name = carName;
        this.price = price;
        this.produser = produser;
        this.speed = speed;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getProducer() {
        return produser;
    }

    public double getSpeed() {
        return speed;
    }
}