package com.taquangkhoi.learntoworkwithfirebase;

public class Person {
    String key, name, age;

    public Person(String key, String name, String age) {
        this.key = key;
        this.name = name;
        this.age = age;
    }
    
    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
