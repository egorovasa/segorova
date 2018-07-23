package ru.job4j.sorting;

public class User implements Comparable<User> {

    private String name;
    private Integer age;

    User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    Integer getAge() {
        return age;
    }

    @Override
    public int compareTo(User user) {
        return age.compareTo(user.getAge());
    }
}