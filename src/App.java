public class App {
    public static void main(String[] args) throws Exception {
        UserSQLGenerator userSQLGenerator = new UserSQLGenerator();
        User user = new User(1, "Alexandr", 22);

        System.out.println(userSQLGenerator.generateCreate(user));
        System.out.println(userSQLGenerator.generateRead("id = 1"));
        System.out.println(userSQLGenerator.generateUpdate(user, "id = 1"));
        System.out.println(userSQLGenerator.generateDelete("id = 1"));

        System.out.println("");
        
        CarSQLGenerator carSQLGenerator = new CarSQLGenerator();
        Car car = new Car(10, "X5", 105000.00, "BMW", 200);

        System.out.println(carSQLGenerator.generateCreate(car));
        System.out.println(carSQLGenerator.generateRead("id = 1"));
        System.out.println(carSQLGenerator.generateUpdate(car, "id = 1"));
        System.out.println(carSQLGenerator.generateDelete("id = 1"));
        
        System.out.println("");
        
        ProductSQLGenerator productSQLGenerator = new ProductSQLGenerator();
        Product product = new Product(101, "Laptop", 1200.50);

        System.out.println(productSQLGenerator.generateCreate(product));
        System.out.println(productSQLGenerator.generateRead("id = 1"));
        System.out.println(productSQLGenerator.generateUpdate(product, "id = 1"));
        System.out.println(productSQLGenerator.generateDelete("id = 1"));
    }
}
