package se.deved;

import java.util.ArrayList;
import java.util.List;

public class Person {

    @StringDefault("Ironman")
    private String name;
    @IntDefault(560)
    private int age;
    private double height;
    private Address address;
    public List<Person> friends = new ArrayList<>();

    public Person(String name, int age, double height, Address address) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.address = address;
    }

    @Deprecated
    public Person() {}

    @Override
    public String toString() {
        return super.toString();
    }
}
