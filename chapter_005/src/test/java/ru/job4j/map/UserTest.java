package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {

    @Test
    public void WhenCreateTwoSameUsersThenWhat() {
        Calendar birthday = new GregorianCalendar(1992, 6, 18);
        Map<User, Object> userMap = new HashMap<>();
        User user1 = new User("Svetlana", 1, birthday);
        User user2 = new User("Svetlana", 1, birthday);
        userMap.put(user1, new Object());
        userMap.put(user2, new Object());
        System.out.println(userMap.toString());
    }
}