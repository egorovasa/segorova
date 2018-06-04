package ru.job4j.parsing;

import java.util.Stack;
/**Parse.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
class Parse {
    private Stack<Character> stack = new Stack<>();

    private boolean isOpeningBracket(char bracket) {
        return "({[".indexOf(bracket) != -1;
    }

    private boolean isClosingBracket(char bracket) {
        return ")}]".indexOf(bracket) != -1;
    }

    private boolean isPair(char opening, char closing) {
        return opening == '(' && closing == ')' || opening == '['
                && closing == ']' || opening == '{' && closing == '}';
    }

    boolean validate(String input) {
        for (char c : input.toCharArray()) {
            if (isClosingBracket(c) && stack.isEmpty()) {
                return false;
            }
            if (isOpeningBracket(c)) {
                stack.push(c);
            }
            if (isClosingBracket(c)) {
                if (isPair(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    Stack<Character> change(String input) {
        Stack<Character> result = new Stack<>();
        Parse brackets = new Parse();
        if (brackets.validate(input)) {
            for (char c : input.toCharArray()) {
                if (c == '[') {
                    result.add(c);
                    result.add(']');
                } else if (c == '{') {
                    result.add(c);
                    result.add('}');
                } else if (c == '(') {
                    result.add(c);
                    result.add(')');
                }
            }
        }
        return result;
    }
}