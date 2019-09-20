package ru.job4j.analyze;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analyze {

    public HashMap<String, Integer> collectionDifference(List<User> previous, List<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;

        Map<Integer, String> allUsers = new HashMap<>();
        for (User user : current) {
            allUsers.put(user.getId(), user.getName());
        }
        for (User user : previous) {
            if (!allUsers.containsKey(user.getId())) {
                deleted++;
            } else if (!allUsers.get(user.getId()).equals(user.getName())) {
                changed++;
            }
            allUsers.put(user.getId(), user.getName());
        }
        HashMap<String, Integer> result = new HashMap<>();
        result.put("Количество измененных пользователей: ", changed);
        result.put("Количество удалённых пользователей: ", deleted);
        result.put("Количество добавленных пользователей: ", allUsers.size() - previous.size());

        return result;
    }
}
