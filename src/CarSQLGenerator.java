import java.util.HashMap;
import java.util.Map;

class CarSQLGenerator extends SQLGenerator<Car> {

    public CarSQLGenerator() {
        super("cars", createMapping());
    }

    private static Map<String, FieldMapper<Car>> createMapping() {
        Map<String, FieldMapper<Car>> mapping = new HashMap<>();
        mapping.put("id", Car::getId);
        mapping.put("name", Car::getName);
        mapping.put("price", Car::getPrice);
        mapping.put("producer", Car::getProducer);
        mapping.put("speed", Car::getSpeed);
        return mapping;
    }
}