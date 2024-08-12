package com.breakingbad.tmp;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Car car = new Car("abc",person);
        Person person1 = car.getPerson();
        person1 = new Person();
        System.out.println(person1 == person);
    }
}
