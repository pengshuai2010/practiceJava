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
public class Q227_BasicCalculatorII_WithOperatorStack {
    public static final List<String> HIGH_PRIORITY = Arrays.asList("*", "/");
    private static final List<Character> OPERATORS = Arrays.asList('+', '-', '*', '/');

    public int calculate(String s) {
        // can I assume the expression is valid?
        // Will the intermediate and final result be in range of Integer, or Long, or even bigger?
        List<String> tokens = tokenize(s);
        Deque<Integer> numbers = new ArrayDeque<>();
        Deque<String> operators = new ArrayDeque<>();
        for (String token: tokens) {
            if (isNumber(token)) {
                int number = Integer.parseInt(token);
                numbers.addLast(number);
            } else {
                while (!operators.isEmpty() && getPriority(operators.getLast()) >= getPriority(token)) {
                    calculateLastOperator(numbers, operators);
                }
                operators.addLast(token);
            }
        }
        while (!operators.isEmpty()) {
            calculateLastOperator(numbers, operators);
        }
        return numbers.removeLast();
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
            } // else is white space
            i++;
        }
        return tokens;
    }

    private boolean isNumber(String token) {
        return Character.isDigit(token.charAt(0));
    }

    private int getPriority(String operator) {
        if (HIGH_PRIORITY.contains(operator)) {
            return 1;
        }
        return 0;
    }

    private void calculateLastOperator(Deque<Integer> numbers, Deque<String> operators) {
        int operand2 = numbers.removeLast();
        int operand1 = numbers.removeLast();
        String operator = operators.removeLast();
        int result = switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
        numbers.addLast(result);
    }

    private boolean isOperator(char ch) {
        return OPERATORS.contains(ch);
    }
}
