package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Q1249_MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        // clarify if s will be null
        // is s guranteed only contain ... ?
        Set<Integer> toRemove = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.addLast(i);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                } else {
                    // there is a ')' but no unmatched '(', so this '(' should be removed
                    toRemove.add(i);
                }
            }
        }
        toRemove.addAll(stack); // any '(' left unmachted should also be removed
        // it is a lot easier to keep record of the indice of what to remove, and then do it in one go, than
        // copying and skipping extra ')' while iterating and then remove extra '('
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!toRemove.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public String minRemoveToMakeValid2(String s) {
        // clarify if s will be null
        // is s guranteed only contain ... ?
        StringBuilder sb = new StringBuilder();
        // we need to make sure at any point, there won't be more ')'s than '('s.
        // So we don't need an actual stack. Just count the number of unmatched left parenthese.
        int unmatchedLeftParenthese = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                unmatchedLeftParenthese++;
                sb.append(ch);
            } else if (ch == ')') {
                if (unmatchedLeftParenthese > 0) {
                    unmatchedLeftParenthese--;
                    sb.append(ch);
                } // otherwise not append
            } else {
                sb.append(ch);
            }
        }
        // copy over, skip extra '('s, then reverse the result
        // simply deleting the extra '(' would be too expensive because a deletion takes O(n) time
        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && unmatchedLeftParenthese > 0) {
                unmatchedLeftParenthese--;
            } else {
                result.append(sb.charAt(i));
            }
        }
        result.reverse();
        return result.toString();
    }
}
