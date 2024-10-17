
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class CarGenerator {
    static List<String> brands = Arrays.asList("Toyota", "BMW", "Porsche", "Ford", "Audi", "Mercedes", "Volkswagen");
    static List<String> models = Arrays.asList(
        "Camry", "X5", "Focus", "A4", "C-Class",
        "Accord", "Model S", "Mustang", "Civic", "Altima",
        "Cherokee", "Outback", "Golf", "Mazda3", "Sonata",
        "Forte", "Jetta", "Challenger", "Tucson", "Rogue",
        "Soul", "CR-V", "Venza", "Q5", "S60",
        "GT-R", "Aventador", "M3", "RX-7", "Cayenne",
        "S60", "Elantra", "i30", "Kona"
    );
    static List<String> carClasses = Arrays.asList("Economy", "Luxury", "SUV", "Truck", "Sporty", "Electric");

    public static Car generate() {
        String brand = brands.get(ThreadLocalRandom.current().nextInt(brands.size()));
        String model = models.get(ThreadLocalRandom.current().nextInt(models.size()));
        Date manufactureDate = new Date(ThreadLocalRandom.current().nextLong(new Date(946684800000L).getTime(), new Date().getTime())); // Random date between 2000 and now
        String classType = carClasses.get(ThreadLocalRandom.current().nextInt(carClasses.size()));
    
        double price;
        
        double chance = ThreadLocalRandom.current().nextDouble();
        
        if (chance < 0.05) { // 5% chance of an outlier
            if (ThreadLocalRandom.current().nextBoolean()) {
                price = ThreadLocalRandom.current().nextDouble(100000, 200000); 
            } else {
                price = ThreadLocalRandom.current().nextDouble(1000, 5000);
            }
        } else {
            price = ThreadLocalRandom.current().nextDouble(10000, 100000);
        }
    
        return new Car(brand, model, manufactureDate, classType, price);
    }
    
}