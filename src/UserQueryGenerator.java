public class UserQueryGenerator {

    public static String generateInsert(User user) {
        return "INSERT INTO users (user_id, full_name, user_age) VALUES (" +
                user.getId() + ", '" +
                user.getName() + "', " +
                user.getAge() + ");";
    }

    public static String generateSelect() {
        return "SELECT user_id, full_name, user_age FROM users;";
    }

    // UPDATE
    public static String generateUpdate(User user) {
        return "UPDATE users SET full_name = '" +
                user.getName() + "', user_age = " +
                user.getAge() +
                " WHERE user_id = " + user.getId() + ";";
    }

    // DELETE
    public static String generateDelete(User user) {
        return "DELETE FROM users WHERE user_id = " + user.getId() + ";";
    }
}
