package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q65_ValidNumber {
    public boolean isNumber(String s) {
        // will there be space? what are the possible characters?
        if (s.isEmpty()) {
            return false;
        }
        List<String> tokens = tokenize(s, Arrays.asList('e', 'E'));
        if (tokens.size() > 2) {
            return false; // there are more than one 'e' or 'E'
        }
        if (!isValidInteger(tokens.get(0)) && !isValidDecimal(tokens.get(0))) {
            return false;
        }
        if (tokens.size() == 2 && !isValidInteger(tokens.get(1))) {
            return false;
        }
        return true;
    }

    private List<String> tokenize(String s, List<Character> separators) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (separators.contains(ch)) { // when it is separator
                tokens.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(ch);
            }
        }
        tokens.add(sb.toString()); // don't forget the part after last separator!
        return tokens;
    }

    private boolean isValidInteger(String token) {
        if (token.isEmpty()) {
            return false;
        }
        if (token.charAt(0) == '+' || token.charAt(0) == '-') {
            return token.length() > 1 && containsOnlyDigits(token.substring(1));
        }
        return containsOnlyDigits(token);
    }

    private boolean containsOnlyDigits(String token) {
        for (int i = 0; i < token.length(); i++) {
            if (!Character.isDigit(token.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidDecimal(String token) {
        if (token.isEmpty()) {
            return false;
        }
        if (token.charAt(0) == '+' || token.charAt(0) == '-') {
            return token.length() > 1 && isValidNonNegativeDecimal(token.substring(1));
        }
        return isValidNonNegativeDecimal(token);
    }

    private boolean isValidNonNegativeDecimal(String token) {
        List<String> split = tokenize(token, List.of('.'));
        if (split.size() > 2) {
            return false; // there are more than 1 dots
        }
        // at least one part is not empty
        if (allEmpty(split)) {
            return false;
        }
        // all parts can only contain digits
        for (String part: split) {
            if (!containsOnlyDigits(part)) {
                return false;
            }
        }
        return true;
    }

    private boolean allEmpty(List<String> parts) {
        boolean allEmpty = true;
        for (String part: parts) {
            if (!part.isEmpty()) {
                allEmpty = false;
                break;
            }
        }
        return allEmpty;
    }
}
