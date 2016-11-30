package leetCode;

import java.util.Stack;

/**
 * Created by shuaipeng on 11/28/16.
 */
public class Q71_SimplifyPath {
    // questions to ask: leading spaces? space is valid filename, so we cannot remove trailing spaces
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return "";
        // note that the iterator of Deque is in reverse sequential order, i.e. Last In First Out.
        // here we use stack because we want FIFO order
        Stack<String> stack = new Stack<>();
        for (String token : path.split("/+")) {
            if (token.length() == 0 || token.equals(".")) {
                continue;
            }
            if (token.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(token);

        }
        if (stack.isEmpty()) {//corner cases: "/", "/../"
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            sb.append("/").append(str);
        }
        return sb.toString();
    }
}
