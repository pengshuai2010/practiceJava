package leetCode;

import java.util.*;

/**
 * create a number stack
 * create operator stack
 * if number
 * push to number stack
 * else
 * if operator stack is empty
 * push to operator stack
 * else
 * if same or lower priority
 * pop two from number stack and pop one from operator stack
 * calculate
 * push result to number stack
 * push current operator to operator stack
 * else
 * pop number from number stack
 * get next number
 * calculate
 * push result to number stack
 * if operator stack is not empty
 * pop and calculate
 * push result to numbers stack
 * return numbers stack.pop()
 * <p>
 * <p>
 * tokenize
 * white space or separted by operators, e.g. "3+5"
 * <p>
 * isOperator
 * getPriority
 * calculate
 */
public class Q227_BasicCalculatorII {
    private static final List<String> OPERATORS = Arrays.asList("+", "-", "*", "/");
    private static final Map<String, Integer> PRIORITY = new HashMap<String, Integer>() {{
        put("+", 0);
        put("-", 0);
        put("*", 1);
        put("/", 1);
    }};

    private static List<String> tokenize(String s) {
        List<String> tokens = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                StringBuilder sb = new StringBuilder();
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                tokens.add(sb.toString());
            } else if (isOperator(s.charAt(i))) {
                tokens.add(Character.toString(s.charAt(i)));
                i++;
            } else { // is white space
                i++;
            }
        }
        return tokens;
    }

    private static boolean isOperator(char ch) {
        return OPERATORS.contains(Character.toString(ch));
    }

    private static boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    private static int getPriority(String operator) {
        if (PRIORITY.containsKey(operator)) {
            return PRIORITY.get(operator);
        }
        throw new IllegalArgumentException("unsupported operator");
    }

    private static int calculate(int number1, int number2, String operator) {
        int result = 0;
        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
            default:
                throw new IllegalArgumentException("unsupported operator: " + operator);
        }
        return result;
    }

    public int calculate(String s) {
        // clarify if s will be null or empty, can we assume valid input: only white space, number and operators
        List<String> tokens = tokenize(s);
        Deque<String> operatorStack = new ArrayDeque<>();
        Deque<Integer> numberStack = new ArrayDeque<>();
        int i = 0;
        while (i < tokens.size()) {
            String token = tokens.get(i);
            if (isOperator(token)) {
                if (operatorStack.isEmpty()) {
                    operatorStack.addLast(token);
                } else {
                    String lastOperator = operatorStack.getLast();
                    if (getPriority(token) <= getPriority(lastOperator)) {
                        Integer number2 = numberStack.removeLast(); // last number
                        Integer number1 = numberStack.removeLast();
                        operatorStack.removeLast();
                        Integer result = calculate(number1, number2, lastOperator);
                        numberStack.addLast(result);
                        operatorStack.addLast(token);
                    } else {
                        Integer number1 = numberStack.removeLast();
                        // the current token is an operator, the next must be a number
                        i++;
                        int number2 = Integer.parseInt(tokens.get(i));
                        int result = calculate(number1, number2, token);
                        numberStack.addLast(result);
                    }
                }
            } else {
                numberStack.addLast(Integer.parseInt(token));
            }
            i++;
        }
        if (!operatorStack.isEmpty()) { // when the input contains only a number "2"
            String operator = operatorStack.removeLast();
            Integer number2 = numberStack.removeLast();
            Integer number1 = numberStack.removeLast();
            int result = calculate(number1, number2, operator);
            numberStack.addLast(result);
        }
        return numberStack.removeLast();
    }
}
