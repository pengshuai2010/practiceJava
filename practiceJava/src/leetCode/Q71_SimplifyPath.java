package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by shuaipeng on 11/28/16.
 */
public class Q71_SimplifyPath {
    // questions to ask: leading spaces? space is valid filename, so we cannot remove trailing spaces
    private static final String SEPARATOR = "/";
    private static final String SEPARATOR_REGEX = "/+"; // backslash need to be escaped. Slash doesn't need to be escaped.
    private static final String CURRENT_DIR_SYMBOL = ".";
    private static final String PARENT_DIR_SYMBOL = "..";

    public String simplifyPath(String path) {
        // clarify what to do if path is null or empty?
        // is the path guranteed to be valid? "/   /" or "   /home  "
        String[] tokens = path.split(SEPARATOR_REGEX);
        Deque<String> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.isEmpty() || CURRENT_DIR_SYMBOL.equals(token)) {
                continue;
            }
            if (PARENT_DIR_SYMBOL.equals(token)) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(token);
            }
        }
        if (stack.isEmpty()) {
            return SEPARATOR;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(SEPARATOR).append(stack.removeFirst());
        }
        return sb.toString();
    }
}
