package ru.job4j.bank;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Класс Bank, для проведения операций с аккаунтами.
 *
 * @author Svetlana Egorova (s.sosenkova@gmail.com).
 * @version $Id$
 * @since 0.1
 */
public class Bank {
    private TreeMap<User, List<Account>> users = new TreeMap<>();

    /**
     * Метод addUser добавляет пользователя.
     *
     * @param user пользователь.
     */
    public void addUser(User user) {
        this.users.put(user, new ArrayList<>());
    }

    public List<User> findAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        for (Map.Entry<User, List<Account>> user : this.users.entrySet()) {
            users.add(user.getKey());
        }
        return users;
    }

    /**
     * Метод удаляет пользователя.
     *
     * @param user пользователь
     */
    public void deleteUser(User user) {
        this.users.remove(user);
    }

    /**
     * Метод добавляет пользователю счёт.
     *
     * @param passport номер паспорта пользователя.
     * @param account  счёт пользователя.
     */
    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> user : this.users.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                this.users.get(user).add(account);
            }
        }
    }

    /**
     * Метод deleteAccountFromUser удаляет счёт из списка счетов пользователя.
     *
     * @param user    пользователь.
     * @param account счёт пользователя.
     */
    public void deleteAccountFromUser(User user, Account account) {
        this.users.get(user).remove(account);
    }

    /**
     * Метод getUserAccounts возвращает список счетов пользователя.
     *
     * @param user пользователь.
     * @return список счетов пользователя.
     */
    public List<Account> getUserAccounts(User user) {
        return this.users.get(user);
    }

    /**
     * Метод getActualAccount для получения актуальности счёта.
     *
     * @param user    пользователь.
     * @param account его счёт.
     * @return актуальный счёт.
     */
    private Account getActualAccount(User user, Account account) {
        List<Account> list = this.users.get(user);
        return list.get(list.indexOf(account));
    }

    /**
     * Метод transferMoney, для перевода денег между счетами двух пользователей.
     *
     * @param srcUser    отправитель.
     * @param srcAccount счёт отправителя.
     * @param destUser   получатель.
     * @param dstAccount счёт получателя.
     * @param amount     сумма средств.
     * @return исход операции.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User destUser, Account dstAccount, double amount) {
        return this.users.get(srcUser).contains(srcAccount)
                && this.users.get(destUser).contains(dstAccount)
                && getActualAccount(srcUser, srcAccount).transferOfOwnFunds(getActualAccount(destUser, dstAccount), amount);
    }
}
