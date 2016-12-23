package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by speng on 12/23/16.
 */
public class Q244_ShortestWordDistanceII {
    public static void main(String[] args) {
        String[] input = new String[]{"a", "b", "c", "d", "b", "b", "e", "a"};
//        WordDistance solution = new WordDistance(input);
        WordDistance2 solution = new WordDistance2(input);
        System.out.println(solution.shortest("a", "b"));
        System.out.println(solution.shortest("a", "c"));
        System.out.println(solution.shortest("a", "d"));
        System.out.println(solution.shortest("a", "e"));
        System.out.println(solution.shortest("b", "d"));
    }

    /**
     * constructor takes O(n) time. shortest() takes O(m + n) time, where m is the occurrences of word1, n is the
     * occurrences of word2. Space complexity is O(N), where O(N) is length of input array words[].
     */
    public static class WordDistance {
        private Map<String, List<Integer>> map;

        public WordDistance(String[] words) {
            map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                if (!map.containsKey(words[i])) {
                    map.put(words[i], new ArrayList<>());
                }
                map.get(words[i]).add(i);
            }
        }

        /**
         * map stores every unique word and a list of its occurrences in the input array. When comparing, since the two
         * lists are sorted, we can use the idea of merge sort to save time. Hence the time complexity is O(m + n) instead
         * of O(mn)
         */
        public int shortest(String word1, String word2) {
            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);
            int minDis = Integer.MAX_VALUE;
            int i = 0, j = 0;
            while (i < l1.size() && j < l2.size()) {
                int dis = Math.abs(l1.get(i) - l2.get(j));
                minDis = Math.min(minDis, dis);
                if (l1.get(i) < l2.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }
            return minDis;
        }
    }

    public static class WordDistance2 {
        private Map<String, Map<String, Integer>> table;

        /**
         * pre-calculate all answers and store in a look up take. Constructor takes O(n^2) time. Space complexity is
         * O(m^2) where m is number of unique words. shortest() only need to loop up in the table, taking O(1) time.
         * Time cost in constructor and space cost is large. Only worth it if we really want shortest() to be O(1).
         */
        public WordDistance2(String[] words) {
            table = new HashMap<>();
            Map<String, Integer> lastPos = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                lastPos.put(words[i], i);
                if (!table.containsKey(words[i])) {
                    table.put(words[i], new HashMap<>());
                }
                for (String other : table.keySet()) {
                    if (!other.equals(words[i])) {
                        int dis = i - lastPos.get(other);
                        if (words[i].compareTo(other) < 0) {
                            Integer lastDis = table.get(words[i]).get(other);
                            lastDis = lastDis == null ? Integer.MAX_VALUE : lastDis;
                            table.get(words[i]).put(other, Math.min(lastDis, dis));
                        } else {
                            Integer lastDis = table.get(other).get(words[i]);
                            lastDis = lastDis == null ? Integer.MAX_VALUE : lastDis;
                            table.get(other).put(words[i], Math.min(lastDis, dis));
                        }
                    }
                }
            }
        }

        public int shortest(String word1, String word2) {
            if (word1.compareTo(word2) < 0) {
                return table.get(word1).get(word2);
            }
            return table.get(word2).get(word1);
        }
    }
}
