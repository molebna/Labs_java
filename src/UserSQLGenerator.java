import java.util.HashMap;
import java.util.Map;

class UserSQLGenerator extends SQLGenerator<User> {

    public UserSQLGenerator() {
        super("users", createMapping());
    }

    private static Map<String, FieldMapper<User>> createMapping() {
        Map<String, FieldMapper<User>> mapping = new HashMap<>();
        mapping.put("id", User::getId);
        mapping.put("name", User::getName);
        mapping.put("age", User::getAge);
        return mapping;
    }
}