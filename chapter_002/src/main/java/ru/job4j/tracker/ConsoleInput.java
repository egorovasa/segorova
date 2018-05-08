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

    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Вне диапазона меню");
        }
    }
}
/*    public long ask1(String question) {
        System.out.print(question);
        return scanner.nextLong();
    }*/