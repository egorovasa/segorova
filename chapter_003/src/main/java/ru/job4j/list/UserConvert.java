package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class UserConvert {
    HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<Integer, User>();
        for (int i = 0; i < list.size(); i++) {
            result.put(list.get(i).getId(), list.get(i));
        }
        return result;
    }
}
