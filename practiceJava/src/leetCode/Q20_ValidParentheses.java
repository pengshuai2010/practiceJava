package leetCode;

import java.util.Stack;

/**
 * Created by speng on 11/8/16.
 */
public class Q20_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null) {
            // deal with invalid input
        }
        if (s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '{':
                case '(':
                case '[':
                    stack.push(ch);
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') // don't forget check if stack empty before pop!
                        return false;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
                default:
                    //handle error here
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        if (s == null) {
            // deal with invalid input
        }
        if (s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '{':
                case '(':
                case '[':
                    stack.push(ch);
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') // don't forget check if stack empty before pop!
                        return false;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
                default:
                    //handle error here
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Q20_ValidParentheses solution = new Q20_ValidParentheses();
        String[] inputs = new String[]{"", "[", "]]", "[]", "[{]}", "[["};
        for (String input : inputs) {
            System.out.println(input);
            System.out.println(solution.isValid(input));
        }
    }
}
