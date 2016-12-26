package leetCode;

import java.util.*;

/**
 * Created by speng on 12/26/16.
 */
public class Q381_InsertDeleteGetRandomBigOh1_Duplicatesallowed {
    private List<Integer> list;
    //LinkedHashSet is used instead of HashSet because iterator for HashSet is expensive
    //see https://discuss.leetcode.com/topic/53688/java-haspmap-linkedhashset-arraylist-155-ms/38
    private Map<Integer, Set<Integer>> map;
    private Random rand;

    /**
     * Initialize your data structure here.
     */
    public Q381_InsertDeleteGetRandomBigOh1_Duplicatesallowed() {
        System.out.println("new RandomizedCollection");
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public static void main(String[] args) {
        Q381_InsertDeleteGetRandomBigOh1_Duplicatesallowed solution = new Q381_InsertDeleteGetRandomBigOh1_Duplicatesallowed();
        solution.insert(1);
        solution.insert(1);
        solution.remove(1);
        solution.getRandom();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        System.out.println("insert " + val);
        boolean isFirst = false;
        list.add(val);
        if (!map.containsKey(val)) {
            map.put(val, new LinkedHashSet<>());
            isFirst = true;
        }
        map.get(val).add(list.size() - 1);
        return isFirst;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        System.out.println("remove " + val);
        //either the map entry doesn't exist, or hashset has at least one element
        if (!map.containsKey(val)) {
            return false;
        }
        int lastIndex = list.size() - 1;
        int lastVal = list.get(lastIndex);
        if (val == lastVal) {//because duplicates are allowed
            map.get(lastVal).remove(lastIndex);
        } else {
            int index = map.get(val).iterator().next();
            list.set(index, lastVal);
            map.get(lastVal).remove(lastIndex);
            map.get(lastVal).add(index);
            map.get(val).remove(index);
        }
        list.remove(lastIndex);
        if (map.get(val).size() == 0) {
            map.remove(val);
        }
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        System.out.println("get random");
        return list.get(rand.nextInt(list.size()));
    }
}
