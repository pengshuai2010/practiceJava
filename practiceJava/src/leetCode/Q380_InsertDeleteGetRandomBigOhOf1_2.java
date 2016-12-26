package leetCode;

import java.util.*;

/**
 * Created by speng on 12/25/16.
 */
public class Q380_InsertDeleteGetRandomBigOhOf1_2 {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rand;

    /**
     * Initialize your data structure here.
     */
    public Q380_InsertDeleteGetRandomBigOhOf1_2() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        map.remove(val);
        //The trick is here
        //if not last element, copy value of last element to list[index], and update map, then remove last element
        if (index != list.size() - 1) {
            list.set(index, list.get(list.size() - 1));
            map.put(list.get(index), index);
        }
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
