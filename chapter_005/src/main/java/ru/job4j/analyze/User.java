package ru.job4j.analyze;

import java.util.Calendar;

public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return id == user.id && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        int result = (name != null ? name.hashCode() : 0) + id;
        return 31 * result;
    }
}