import java.util.HashMap;
import java.util.Map;

class ProductSQLGenerator extends SQLGenerator<Product> {

    public ProductSQLGenerator() {
        super("products", createMapping());
    }

    private static Map<String, FieldMapper<Product>> createMapping() {
        Map<String, FieldMapper<Product>> mapping = new HashMap<>();
        mapping.put("id", Product::getId);
        mapping.put("name", Product::getName);
        mapping.put("price", Product::getPrice);
        return mapping;
    }
}