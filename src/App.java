public class App {
    public static void main(String[] args) throws Exception {
        User user = new User(1, "John Doe", 25);
        Product product = new Product(101, "Laptop", 1200.50);
        Car car = new Car(10, "X5", 105000.00, "BMW", 200);

        // Create
        System.out.println("--- CREATE ---");

        System.out.println(CRUD.generateInsert(user));
        System.out.println(CRUD.generateInsert(product));
        System.out.println(CRUD.generateInsert(car));

        System.out.println("");

        // Read
        System.out.println("--- READ ---");

        System.out.println(CRUD.generateSelect(User.class));
        System.out.println(CRUD.generateSelect(Product.class));
        System.out.println(CRUD.generateSelect(Car.class));

        System.out.println("");

        // Update
        System.out.println("--- UPDATE ---");

        System.out.println(CRUD.generateUpdate(user));
        System.out.println(CRUD.generateUpdate(product));
        System.out.println(CRUD.generateUpdate(car));

        System.out.println("");

        // Delete
        System.out.println("--- DELETE ---");

        System.out.println(CRUD.generateDelete(user));
        System.out.println(CRUD.generateDelete(product));
        System.out.println(CRUD.generateDelete(car));

        System.out.println("");

        long startWithReflection = System.nanoTime();
        CRUD.generateInsert(user);
        CRUD.generateSelect(User.class);
        CRUD.generateUpdate(user);
        CRUD.generateDelete(user);
        long endWithReflection = System.nanoTime();

        long startWithoutReflection = System.nanoTime();
        UserQueryGenerator.generateInsert(user);
        UserQueryGenerator.generateSelect();
        UserQueryGenerator.generateUpdate(user);
        UserQueryGenerator.generateDelete(user);
        long endWithoutReflection = System.nanoTime();

        System.out.println("Time with reflection: " + (endWithReflection - startWithReflection) / 1000 + " micro sec");
        System.out.println("Time without reflection: " + (endWithoutReflection - startWithoutReflection) / 1000 + " micro sec");
    }
}
