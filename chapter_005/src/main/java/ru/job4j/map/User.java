package ru.job4j.map;

import java.util.Calendar;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (children != user.children) return false;
        return name.equals(user.name) && birthday.equals(user.birthday);
    }

/*    @Override
    public int hashCode() {
        int result = (name != null ? name.hashCode() : 0) + (birthday != null ? birthday.hashCode() : 0);
        return 31 * result + children;
    }*/
}