package ru.job4j.generic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AbstractStoreTest {
    AbstractStore<User> abstractArray;
    User user1, user2, user3, user4;
    UserStore userStore;
    SimpleArray<User> simpleArray;

    @Before
    public void setUp() {
        UserStore userStore = new UserStore(3);
        user1 = new User("First person");
        user2 = new User("Second person");
        user3 = new User("Third person");
        simpleArray = new SimpleArray<>(3);
        abstractArray = new AbstractStore(simpleArray);
    }

    @Test
    public void whenAddSmthTheNumberIncreases() {
        abstractArray.add(user1);
        abstractArray.add(user2);
        abstractArray.add(user3);
        assertThat(abstractArray.getCount(), is(3));
    }

    @Test
    public void whenReplaceSmthRightThenTrue() {
        abstractArray.add(user1);
        abstractArray.add(user2);
        abstractArray.add(user3);
        user4 = new User("Fourth person");
        assertThat(abstractArray.replace("First person", user4), is(true));
    }

    @Test
    public void delete() {
        abstractArray.add(user1);
        abstractArray.add(user2);
        abstractArray.add(user3);
        abstractArray.delete("Second person");
        assertThat(abstractArray.getCount(), is(2));
    }

    @Test
    public void findById() {
        abstractArray.add(user1);
        abstractArray.add(user2);
        abstractArray.add(user3);
        assertThat(abstractArray.findById("First person"), is(user1));
    }
}