package ru.job4j.tracker;
import java.util.*;
/**ConsoleInput.
 *
 * @author Svetlana Egorova (s.sosenkova@gmail.com).
 *
 * @version $Id$
 *
 * @since 0.1
 *
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
    public long ask1(String question) {
        System.out.print(question);
        return scanner.nextLong();
    }
}