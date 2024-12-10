package leetCode;

public class Q921_MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        // will s be null? will s contain anything except '(' and ')'?
        if (s.isEmpty()) {
            return 0;
        }
        int leftParenthesesToAdd = 0;
        int unmatched = 0; // right parentheses to add
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                unmatched++;
            } else {
                if (unmatched > 0) {
                    unmatched--;
                } else {
                    leftParenthesesToAdd++;
                }
            }
        }
        return unmatched + leftParenthesesToAdd;
    }
}
