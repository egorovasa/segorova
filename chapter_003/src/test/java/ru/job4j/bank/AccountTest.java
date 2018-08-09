package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.*;

/**
 * AccountTest.
 *
 * @author Svetlana Egorova (s.sosenkova@gmail.com).
 * @version $Id$
 * @since 0.1
 */
public class AccountTest {
    @Test
    public void whenAddUserThenNewUserAppears() {
        User user1 = new User("Svetlana", "123");
        Bank sberbank = new Bank();
        sberbank.addUser(user1);
        assertThat(sberbank.findAllUsers(), is(1));
    }

    @Test
    public void whenAddAccountThenTwoAccounts() {
        User user1 = new User("Svetlana", "123");
        Bank sberbank = new Bank();
        Account account1 = new Account(5000, "456");
        sberbank.addUser(user1);
        sberbank.addAccountToUser("123", account1);
        assertThat(sberbank.getUserAccounts(user1).get(0), is("456"));
    }
}