package com.breakingbad.tmp;

public class Car {
    private String name;

    private Person person;

    public Car(String name,Person person) {
        this.name = name;
        this.person = person;
    }

    public String getName() {
        return name;
    }



    public Person getPerson() {
        return person;
    }
}
