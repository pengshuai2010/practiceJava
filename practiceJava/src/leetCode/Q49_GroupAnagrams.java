package leetCode;

import java.util.*;

/**
 * Created by speng on 11/13/16.
 */
public class Q49_GroupAnagrams {
    /**
     * time complexity is O(n*s), where n is number of strings, s is larget string length
     * another way is to turn a string to char array, sort the array, then build a new string based on the char array,
     * use this new string as the key. Time complexity would be O(n*s*log(s))
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> solution = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return solution;
        Map<ArrayWrapper, List<String>> map = new HashMap<>();
        for (String str : strs) {// assuming str is not null
            int[] table = new int[26];
            for (int i = 0; i < str.length(); i++) {
                table[str.charAt(i) - 'a']++;
            }
            ArrayWrapper arrayWrapper = new ArrayWrapper(table);
            if (map.containsKey(arrayWrapper))
                map.get(arrayWrapper).add(str);
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(arrayWrapper, list);
            }
        }
        for (ArrayWrapper arrayWrapper : map.keySet()) {
            solution.add(map.get(arrayWrapper));
        }
        return solution;
    }

    /**
     * instead of home-brew array wrapper class, use unmodifiable list as key of map
     * this is slower than use array wrapper though.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> solution = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return solution;
        Map<List<Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {// assuming str is not null
            List<Integer> table = new ArrayList<>();
            for (int i = 0; i < 26; i++)
                table.add(0);
            for (int i = 0; i < str.length(); i++) {
                table.set(str.charAt(i) - 'a', table.get(str.charAt(i) - 'a') + 1);
            }
            // if we want to use list as the key of map, we must use unmodifiable list because otherwise we will have
            // trouble if the list is accidentally modified
            List<Integer> wrapper = Collections.unmodifiableList(table);
            if (map.containsKey(wrapper))
                map.get(wrapper).add(str);
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(wrapper, list);
            }
        }
        for (List<Integer> arrayWrapper : map.keySet()) {
            solution.add(map.get(arrayWrapper));
        }
        return solution;
    }

    /**
     * The equals() and hashCode() method of Array are shallow, so two array variables are equal only if they point to the
     * identical object. So if we want to use array as key of map, we need a wrapper class.
     * <p>
     * Another choice is to use unmodifiable list as key of map, because the hashCode and equals method of list is deep(
     * based on the contents)
     */
    private class ArrayWrapper {
        int[] table;

        ArrayWrapper(int[] table) {
            this.table = table;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(table);//deep hashcode, calculates hashcode based on the contents of the array
        }

        @Override
        public boolean equals(Object other) {
            // deep equals. two arrays are equals if their contents are equal.
            return other instanceof ArrayWrapper && Arrays.equals(table, ((ArrayWrapper) other).table);
        }
    }
}
