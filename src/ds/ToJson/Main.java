package ds.ToJson;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        // Upswing  question
        Salary salary = new Salary(12.3, Currency.INR);
        Employee employee = new Employee("mohit", salary);
        System.out.println(toJson(employee));
    }

    public static String toJson(Object object) throws IllegalAccessException {

        StringBuilder jsonString = new StringBuilder("{");

        Field[] fields = object.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            jsonString.append("\"").append(field.getName()).append("\":");

            Object value = field.get(object);
            if (value.getClass().isEnum() || field.getType().isPrimitive()) {
                jsonString.append(value);
            } else if (value instanceof String) {
                jsonString.append("\"").append(value).append("\"");
            } else {
                jsonString.append(toJson(value));
            }
            if (i < fields.length - 1)
                jsonString.append(",");
        }

        jsonString.append("}");
        return jsonString.toString();
    }

}
class Employee {
    String name;
    Salary salary;
    Employee(String name, Salary salary) {
        this.name = name;
        this.salary = salary;
    }
}

class Salary {
    double value;
    Currency currency;
    Salary(double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }
}
enum Currency {
    INR, USD
}
