import java.util.Map;
import java.util.stream.Collectors;

public abstract class SQLGenerator<T> {
    private final String tableName;
    private final Map<String, FieldMapper<T>> fieldToColumnMapping;

    public SQLGenerator(String tableName, Map<String, FieldMapper<T>> fieldToColumnMapping) {
        this.tableName = tableName;
        this.fieldToColumnMapping = fieldToColumnMapping;
    }

    public String generateCreate(T obj) {
        String columns = String.join(", ", fieldToColumnMapping.keySet());
        String values = fieldToColumnMapping.values().stream()
                .map(mapper -> {
                    Object value = mapper.getValue(obj);
                    if (value instanceof Number) {
                        return value.toString();
                    } else {
                        return "'" + value + "'";
                    }
                })
                .collect(Collectors.joining(", "));
        return String.format("INSERT INTO %s (%s) VALUES (%s);", tableName, columns, values);
    }

    public String generateRead(String condition) {
        return String.format("SELECT * FROM %s WHERE %s;", tableName, condition);
    }

    public String generateUpdate(T obj, String condition) {
        String setClause = fieldToColumnMapping.entrySet().stream()
                .map(entry -> {
                    String column = entry.getKey();
                    Object value = entry.getValue().getValue(obj);
                    if (value instanceof Number) {
                        return column + " = " + value;
                    } else {
                        return column + " = '" + value + "'";
                    }
                })
                .collect(Collectors.joining(", "));
        return String.format("UPDATE %s SET %s WHERE %s;", tableName, setClause, condition);
    }

    public String generateDelete(String condition) {
        return String.format("DELETE FROM %s WHERE %s;", tableName, condition);
    }

    @FunctionalInterface
    public interface FieldMapper<T> {
        Object getValue(T obj);
    }
}