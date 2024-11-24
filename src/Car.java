@Table(name = "cars")
public class Car {
    @Column(name = "car_id", primaryKey = true)
    private int carId;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "price")
    private double price;

    @Column(name = "produser")
    private String produser;
    
    @Column(name = "speed")
    private double speed;

    public Car(int carId, String carName, double price, String produser, double speed) {
        this.carId = carId;
        this.carName = carName;
        this.price = price;
        this.produser = produser;
        this.speed = speed;
    }
}