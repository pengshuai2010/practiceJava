package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaipeng on 11/1/16.
 */
public class Q388_LongestAbsoluteFilePath {
    public static void main(String[] args) {
        new Q388_LongestAbsoluteFilePath().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
    }

    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0)
            return 0;
        String[] lines = input.split("\n");
        Map<Integer, Integer> path = new HashMap<>();
        int maxLength = 0;
        for (String line : lines) {
            String name = line.replace("\t", "");
            int depth = line.length() - name.length();
            if (depth == 0)
                path.put(depth, name.length());
            else
                path.put(depth, path.get(depth - 1) + name.length() + 1);
            if (name.contains(".")) {
                maxLength = Math.max(maxLength, path.get(depth));
            }
        }
        return maxLength;
    }
}
