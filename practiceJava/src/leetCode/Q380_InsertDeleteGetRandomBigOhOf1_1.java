package leetCode;

import java.util.*;

/**
 * Created by speng on 12/25/16.
 */
public class Q380_InsertDeleteGetRandomBigOhOf1_1 {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rand;

    /**
     * Initialize your data structure here.
     */
    public Q380_InsertDeleteGetRandomBigOhOf1_1() {
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
        list.set(index, null);
        map.remove(val);
        //when the number of actual element is less than half of list length, we compact the list.
        //each compact takes O(n) time, but when removing all element from a list of length n, compact() are only called
        //O(log(n)) times, each it takes O(m) time, m is length of list when compact() is called.
        // 1 + 2^1 + 2^2 + ... + 2^(log(n)) = O(n). So the amortized cost of remove() is O(1)
        if (map.size() < list.size() / 2) {
            compact();
        }
        return true;
    }

    private void compact() {
        List<Integer> newList = new ArrayList<>();
        for (Integer num : list) {
            if (num != null) {
                newList.add(num);
                map.put(num, newList.size() - 1);
            }
        }
        list = newList;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        //keep trying until we get a valid element
        //since each time load factor drops below 0.5 we will do a compact, the probability of getting a valid element
        //is no less than 1/2
        //average attempts = 1/2 + 2/2^2 + 3/2^3 + ... i/2^i + ... approximately = 2.08
        // so getRandom() takes O(1) time on average
        Integer val = null;
        while (val == null) {
            val = list.get(rand.nextInt(list.size()));
        }
        return val;
    }
}
