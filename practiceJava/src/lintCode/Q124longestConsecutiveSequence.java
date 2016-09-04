package lintCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuaipeng on 9/2/16.
 */
public class Q124longestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(new Q124longestConsecutiveSequence().longestConsecutive(new int[]{2, 4}));
        System.out.println(new Q124longestConsecutiveSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(new Q124longestConsecutiveSequence().longestConsecutive(new int[]{100, 4, 101, 1, 3, 2, 102}));
    }

    /**
     * @param num: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        for (int ele : num)
            set.add(ele);
        int longest = 0;
        for (int ele : num) {
            int counter = 1;
            set.remove(ele);
            for (int i = ele - 1; set.contains(i); i--) {
                set.remove(i);
                counter++;
            }
            for (int i = ele + 1; set.contains(i); i++) {
                set.remove(i);
                counter++;
            }
            longest = Math.max(longest, counter);
        }
        return longest;
    }
}
