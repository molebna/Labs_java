
public @interface Column {

    String name();
    boolean primaryKey() default false;
}
