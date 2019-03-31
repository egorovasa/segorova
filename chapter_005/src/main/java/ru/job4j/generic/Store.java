package ru.job4j.generic;

/**
 * @author Svetlana Egorova (s.sosenkova@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}