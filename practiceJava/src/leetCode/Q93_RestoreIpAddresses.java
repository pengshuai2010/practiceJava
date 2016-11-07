package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 11/6/16.
 */
public class Q93_RestoreIpAddresses {
    public static void main(String[] args) {
        Q93_RestoreIpAddresses solution = new Q93_RestoreIpAddresses();
        String[] inputs = new String[]{"0000", "25525511135", "010010"};
        for (String input : inputs) {
            System.out.println(solution.restoreIpAddresses(input));
        }
    }

    public List<String> restoreIpAddresses(String s) {
        int[] parts = new int[4];
        List<String> ip = new ArrayList<>();
        dfs(parts, 0, s, ip);
        return ip;
    }

    private void dfs(int[] parts, int index, String s, List<String> ip) {
        if (index == parts.length) {
            StringBuilder sb = new StringBuilder(Integer.toString(parts[0]));
            for (int i = 1; i < 4; i++)
                sb.append('.').append(Integer.toString(parts[i]));
            ip.add(sb.toString());
            return;
        }
        // there should be [1, 3] digits in the number
        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            if (s.length() - i > 3 * (4 - index - 1))// trim the branch, e.g. there 10 are digits left but only 3 numbers
                continue;
            if (i > 1 && s.charAt(0) == '0')// avoid 2 or 3 digit numbers staring with 0, e.g. 00 or 010
                continue;
            int val = Integer.valueOf(s.substring(0, i));
            if (val < 256) {
                parts[index] = val;
                dfs(parts, index + 1, s.substring(i, s.length()), ip);
            }
        }
    }
}
