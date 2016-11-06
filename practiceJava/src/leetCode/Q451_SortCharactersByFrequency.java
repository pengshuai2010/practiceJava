package leetCode;

import java.util.*;

/**
 * Created by speng on 11/5/16.
 */
public class Q451_SortCharactersByFrequency {
    public static void main(String[] args) {
        Q451_SortCharactersByFrequency solution = new Q451_SortCharactersByFrequency();
        String[] inputs = new String[]{null, "", "tree", "treeabbb", "eee"};
        for (String input : inputs) {
            System.out.println(input);
            System.out.println(solution.frequencySort(input));
        }
    }

    /**
     * O(n*log(n))
     *
     * @param s
     * @return
     */
    public String frequencySort1(String s) {
        if (s == null || s.length() == 0)
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else
                map.put(ch, 1);
        }
        List<Tuple> list = new ArrayList<>();
        for (char ch : map.keySet()) {
            list.add(new Tuple(ch, map.get(ch)));
        }
        //O(m*log(m)), where m is number of unique characters.
        // in worst case, it O(n*log(n))
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Tuple tuple : list) {
            for (int i = 0; i < tuple.getCount(); i++)
                sb.append(tuple.getChar());
        }
        return sb.toString();
    }

    /**
     * O(n)
     * using bucket sort
     *
     * @param s
     * @return
     */
    public String frequencySort2(String s) {
        if (s == null || s.length() == 0)
            return "";
        // ask interviewer if we can assume that the character are ascii characters.
        // if so, we can simply use an array
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else
                map.put(ch, 1);
        }
        // maximum occurrence of characters
        int max = 0;
        for (char ch : map.keySet())
            max = Math.max(map.get(ch), max);
        // bucket sort, each number in [1, max] is a bucket
        StringBuilder[] buckets = new StringBuilder[max + 1];
        for (char ch : map.keySet()) {
            int count = map.get(ch);
            if (buckets[count] == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(ch);
                buckets[count] = sb;
            } else {
                buckets[count].append(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int count = buckets.length - 1; count >= 0; count--) {
            if (buckets[count] != null)
                for (int index = 0; index < buckets[count].length(); index++)
                    for (int i = 0; i < count; i++)
                        sb.append(buckets[count].charAt(index));
        }
        return sb.toString();
    }

    /**
     * assuming ascii character set
     * O(n)
     * using bucket sort
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        if (s == null || s.length() == 0)
            return "";
        // ask interviewer if we can assume that the character are ascii characters.
        // if so, we can simply use an array
        int[] occurrence = new int[256];
        for (int i = 0; i < s.length(); i++)
            occurrence[s.charAt(i)]++;
        // maximum occurrence of characters
        int max = 0;
        for (int anOccurrence : occurrence) {
            max = Math.max(max, anOccurrence);
        }
        // bucket sort, each number in [1, max] is a bucket
        StringBuilder[] buckets = new StringBuilder[max + 1];
        for (int i = 0; i < occurrence.length; i++) {
            if (occurrence[i] > 0) {
                char ch = (char) i;
                int count = occurrence[i];
                if (buckets[count] == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(ch);
                    buckets[count] = sb;
                } else {
                    buckets[count].append(ch);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int count = buckets.length - 1; count >= 0; count--) {
            if (buckets[count] != null)
                for (int index = 0; index < buckets[count].length(); index++)
                    for (int i = 0; i < count; i++)
                        sb.append(buckets[count].charAt(index));
        }
        return sb.toString();
    }

    private class Tuple implements Comparable<Tuple> {
        private char ch;
        private int count;

        Tuple(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        char getChar() {
            return ch;
        }

        int getCount() {
            return count;
        }

        // the compareTo(T) method must be public, and input type should be T instead of Object
        public int compareTo(Tuple other) {
            return other.getCount() - count;
        }
    }
}
