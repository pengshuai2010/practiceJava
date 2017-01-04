package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by speng on 1/3/17.
 */
public class Q247_StrobogrammaticNumberII {
    private Map<Character, Character> map;

    /**
     * A number cannot start with zero. Need to pay attention to that.
     */
    public List<String> findStrobogrammatic1(int n) {
        List<String> solutions = new ArrayList<>();
        if (n < 1) {
            return solutions;
        }
        map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        dfs(n, 0, new StringBuilder(), solutions);
        return solutions;
    }

    private void dfs(int n, int index, StringBuilder sb, List<String> solutions) {
        if (index == n / 2) {
            String mirror = getMirror(sb.toString());
            if (n % 2 == 1) {
                solutions.add(sb.toString() + '0' + mirror);//don't use append()! we shouldn't change sb here.
                solutions.add(sb.toString() + '1' + mirror);
                solutions.add(sb.toString() + '8' + mirror);
            } else {
                solutions.add(sb + mirror);
            }
            return;
        }
        for (char ch : "01689".toCharArray()) {
            if (index == 0 && ch == '0') {
                continue;//a number cannot begin with 0
            }
            sb.append(ch);
            dfs(n, index + 1, sb, solutions);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private String getMirror(String origin) {
        StringBuilder sb = new StringBuilder();
        for (int i = origin.length() - 1; i >= 0; i--) {
            sb.append(map.get(origin.charAt(i)));
        }
        return sb.toString();
    }

    /**
     * A shorter and more elegant solution. The drawback is creating to many temporary String objects.
     */
    public List<String> findStrobogrammatic(int n) {
        List<String> solutions = new ArrayList<>();
        if (n < 1) {
            return solutions;
        }
        List<String> prev = new ArrayList<>();
        if (n % 2 == 0) {
            prev.add("");
        } else {
            prev.add("0");
            prev.add("1");
            prev.add("8");
        }
        for (int i = 0; i < n / 2; i++) {
            List<String> curr = new ArrayList<>();
            for (String str : prev) {
                if (i < n / 2 - 1) {
                    curr.add("0" + str + "0");
                }
                curr.add("1" + str + "1");
                curr.add("6" + str + "9");
                curr.add("8" + str + "8");
                curr.add("9" + str + "6");
            }
            prev = curr;
        }
        return prev;
    }
}
