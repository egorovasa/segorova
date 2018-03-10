package ru.job4j.loop;
/**Factorial.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *@version $Id$
 *@since 0.1
 */
public class Factorial {
    /**
     *Method calc.
     *@param n Just positive whole number.
     *@return Factorial of number.
     */
    public int calc(int n) {
        int fact = 1;
        while (n > 0) {
            fact = n * fact;
            n--; }
        return fact;
    }
}
