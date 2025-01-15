package leetCode;

import java.util.*;

// 1 + 2 * 3 / 45 + 1
// number stack: 1, 6, 45,
// operator stack: +, /,


// tokenize
// for each token
//     if number
//         add to number stack
//     else
//         while operator stack is not empty and last operator is of same or higher priority
//             calculate for last operator
//         add operator
// while operator stack is not empty
//     calculate for last operator
// return number stack pop
public class Q227_BasicCalculatorII_NoOperatorStack {
    public static void main(String[] args) {
        Q227_BasicCalculatorII_NoOperatorStack solution = new Q227_BasicCalculatorII_NoOperatorStack();
        System.out.println(solution.calculate("1-5"));
    }

    private static final List<Character> OPERATORS = Arrays.asList('+', '-', '*', '/');

    public int calculate(String s) {
        // can I assume the expression is valid?
        // Will the intermediate and final result be in range of Integer, or Long, or even bigger?
        List<String> tokens = tokenize(s);
        Deque<Integer> numbers = new ArrayDeque<>();
        // The high level idea is to think of an expression like "1 - 2 * 3 / 3 - 4" as "(1) + (-2) * 3 / 3 + (-4)".
        // when we see a number, we only need to know the last operator, so there is no need for an operator stack
        String lastOperator = "+";
        for (String token: tokens) {
            if (isNumber(token)) {
                int number = Integer.parseInt(token);
                int result = switch (lastOperator) {
                    case "+" -> number;
                    case "-" -> -number;
                    case "*" -> numbers.removeLast() * number;
                    case "/" -> numbers.removeLast() / number;
                    default -> throw new IllegalArgumentException("unexpected value: " + lastOperator);
                };
                numbers.addLast(result);
            } else {
                lastOperator = token;
            }
        }
        int sum = 0;
        while (!numbers.isEmpty()) {
            sum += numbers.removeLast();
        }
        return sum;
    }

    private List<String> tokenize(String s) {
        List<String> tokens = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                StringBuilder sb = new StringBuilder();
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                i--;
                tokens.add(sb.toString());
            } else if (isOperator(s.charAt(i))) {
                tokens.add(Character.toString(s.charAt(i)));
            } // else it's white space, we do nothing
            i++;
        }
        return tokens;
    }

    private boolean isNumber(String token) {
        return Character.isDigit(token.charAt(0));
    }

    private boolean isOperator(char ch) {
        return OPERATORS.contains(ch);
    }
}
