package model;

import enums.Gender;

public class Person extends Structure implements Comparable<Person>{
    public Person(String name, int age, Gender gender) {
        super(name, age, gender);
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }
}
