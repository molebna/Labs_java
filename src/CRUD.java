import java.lang.reflect.Field;

public class CRUD {
    
    public static String generateInsert(Object obj) throws IllegalArgumentException, IllegalAccessException
    {
        Class<?> cl = obj.getClass();

        if (!cl.isAnnotationPresent(Table.class)) {
            throw new IllegalArgumentException("Class is not annotated with @Table");
        }

        Table tableAnnotation = cl.getAnnotation(Table.class);
        StringBuilder query = new StringBuilder("INSERT INTO " + tableAnnotation.name() + " (");

        Field[] fields = cl.getDeclaredFields();
        StringBuilder values = new StringBuilder("VALUES (");

        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column columnAnnotation = field.getAnnotation(Column.class);
                query.append(columnAnnotation.name()).append(", ");

                field.setAccessible(true);
                Object value = field.get(obj);
                if (value instanceof String) {
                    values.append("'").append(value).append("', ");
                } else {
                    values.append(value).append(", ");
                }
            }
        }

        query.setLength(query.length() - 2);
        values.setLength(values.length() - 2);

        query.append(") ").append(values).append(");");
        return query.toString();
    }

    public static String generateSelect(Class<?> cl) {
        if (!cl.isAnnotationPresent(Table.class)) {
            throw new IllegalArgumentException("Class is not annotated with @Table");
        }

        Table tableAnnotation = cl.getAnnotation(Table.class);
        StringBuilder query = new StringBuilder("SELECT ");

        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column columnAnnotation = field.getAnnotation(Column.class);
                query.append(columnAnnotation.name()).append(", ");
            }
        }

        query.setLength(query.length() - 2);
        query.append(" FROM ").append(tableAnnotation.name()).append(";");
        return query.toString();
    }

    public static String generateUpdate(Object obj) throws IllegalAccessException {
        Class<?> cl = obj.getClass();
        if (!cl.isAnnotationPresent(Table.class)) {
            throw new IllegalArgumentException("Class is not annotated with @Table");
        }

        Table tableAnnotation = cl.getAnnotation(Table.class);
        StringBuilder query = new StringBuilder("UPDATE " + tableAnnotation.name() + " SET ");

        Field[] fields;
        fields = cl.getDeclaredFields();
        String primaryKeyCondition = "";

        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column columnAnnotation = field.getAnnotation(Column.class);

                field.setAccessible(true);
                Object value = field.get(obj);
                if (columnAnnotation.primaryKey()) {
                    primaryKeyCondition = " WHERE " + columnAnnotation.name() + " = " + (value instanceof String ? "'" + value + "'" : value);
                } else {
                    query.append(columnAnnotation.name()).append(" = ");
                    query.append(value instanceof String ? "'" + value + "', " : value + ", ");
                }
            }
        }

        query.setLength(query.length() - 2);
        query.append(primaryKeyCondition).append(";");
        return query.toString();
    }

    public static String generateDelete(Object obj) throws IllegalAccessException {
        Class<?> cl = obj.getClass();
        if (!cl.isAnnotationPresent(Table.class)) {
            throw new IllegalArgumentException("Class is not annotated with @Table");
        }

        Table tableAnnotation = cl.getAnnotation(Table.class);
        StringBuilder query = new StringBuilder("DELETE FROM " + tableAnnotation.name());

        Field[] fields = cl.getDeclaredFields();
        String primaryKeyCondition = "";

        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column columnAnnotation = field.getAnnotation(Column.class);
                if (columnAnnotation.primaryKey()) {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    primaryKeyCondition = " WHERE " + columnAnnotation.name() + " = " + (value instanceof String ? "'" + value + "'" : value);
                }
            }
        }

        if (primaryKeyCondition.isEmpty()) {
            throw new IllegalArgumentException("Primary key not specified for DELETE operation");
        }

        query.append(primaryKeyCondition).append(";");
        return query.toString();
    }

    private static String getSqlType(Class<?> type)
    {
        if (type == String.class) {
            return "VARCHAR(255)";
        } else if (type == int.class || type == Integer.class) {
            return "INT";
        } else if (type == double.class || type == Double.class) {
            return "DOUBLE";
        } else {
            throw new UnsupportedOperationException("Type " + type.getSimpleName() + " is not supported");
        }
    }
}
