package ru.job4j.tracker;
/**
 * key определяет уникальность ключа.
 *
 * execute выполняет действие.
 * Принимает 2 параметра - input и tracker.
 *
 * info печатает информацию о том, что наше событие должно делать.
 *
 *
 */
public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();
}