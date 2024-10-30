package se.deved;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.List;

public class Main {

    // Consumer - ta in ett värde (forEach)
    // Supplier - returnera/ge ett värde
    // Predicate - bestämma ett villkor (filter)
    // Function - bestäm egen input och output (map)

    // streams, lambdas
    // reflection
    // generics List<String>
    // annotations

    public static void main(String[] args) throws Exception {
        // Exercise 1
        Class<Person> personClass = Person.class;
        Field personAgeField = personClass.getDeclaredField("age");
        personAgeField.setAccessible(true);

        Person person = new Person();
        personAgeField.set(person, 45);

        int personAge = (int) personAgeField.get(person);
        System.out.println(personAge);

        Person ironman = new Person("Ironman", 34, 6.4, new Address("some-street", 4));
        ironman.friends.add(new Person("Superman", 34, 5.3, new Address("some-street", 5)));
        ironman.friends.add(new Person("Batman", 34, 5.3, new Address("some-street", 5)));

        System.out.println(toStringAnyObject(ironman));

        File ironmanFile = new File("./ironman.txt");
        ironmanFile.createNewFile();
        saveAnyObjectToFile(ironman, ironmanFile);

        System.out.println("------------");
        Person autoPerson = createObjectWithDefaults(Person.class);
        System.out.println(toStringAnyObject(autoPerson));
    }

    // Exercise 2
    public static <T> String toStringAnyObject(T object) throws Exception {
        StringBuilder builder = new StringBuilder();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            builder.append(field.getName());
            builder.append(" = ");
            builder.append(field.get(object));
            builder.append("\n");
        }

        return builder.toString();
    }

    // Exercise 3
    public static <T> void saveAnyObjectToFile(T object, File file) throws Exception {
        FileWriter writer = new FileWriter(file);

        saveAnyObjectToFileInner(object, writer);

        writer.flush();
        writer.close();
    }

    public static <T> void saveAnyObjectToFileInner(T object, FileWriter writer) throws Exception {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            Class type = field.getType();
            if (type.isPrimitive() || type == String.class) {
                writer.append(field.get(object).toString()).append("\n");
            } else if (type.isAssignableFrom(List.class)) {
                List list = (List) field.get(object);
                writer.append(list.size() + "").append("\n");
                for (Object element : list) {
                    saveAnyObjectToFileInner(element, writer);
                }
            } else {
                saveAnyObjectToFileInner(field.get(object), writer);
            }
        }
    }

    // Annotations exercise 3
    public static <T> T createObjectWithDefaults(Class<T> clazz) throws Exception {
        T object = clazz.getConstructor().newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            StringDefault stringDefault = field.getAnnotation(StringDefault.class);
            if (stringDefault != null) {
                field.set(object, stringDefault.value());
            }

            IntDefault intDefault = field.getAnnotation(IntDefault.class);
            if (intDefault != null) {
                field.set(object, intDefault.value());
            }
        }

        return object;
    }
}