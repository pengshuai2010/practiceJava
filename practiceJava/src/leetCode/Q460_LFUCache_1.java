package leetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Q460_LFUCache_1 {
    private TreeSet<Cache> set;
    private Map<Integer, Cache> map;
    private int capacity;
    private int timestamp;

    /**
     * use HashMap and TreeSet.
     * get(int key) takes O(log(n)) time, because when we get(), we need to update the usage and timestamp field of Cache.
     * If we change the Cache object directly, we will break the underlying binary search tree of TreeSet. So we need to
     * first remove the Cache object, update it, then add it back. And add, remove operation of TreeSet takes O(log(n)) time.
     * For the same reason, set(int key, int value) takes O(log(n)) time.
     * <p>
     * Why not use PriorityQueue: We need to put the tuple (key, usage, timestamp) into a collection, which allow us to
     * get the oldest and update tuples. With PriorityQueue, we can get oldest in O(1) time, but updating a tuple would
     * take O(n) time as PriorityQueue.remove(Object o) takes O(n) time. Since updating is needed in both get(int key) and
     * set(int key, int value), these two methods would become O(n).
     */
    public Q460_LFUCache_1(int capacity) {
        if (capacity == 0) {
            return;
        }
        set = new TreeSet<>(new Comparator<Cache>() {
            public int compare(Cache a, Cache b) {
                if (a.usage == b.usage) {
                    return a.timestamp - b.timestamp;
                }
                return a.usage - b.usage;
            }
        });
        map = new HashMap<>();
        this.capacity = capacity;
        timestamp = 0;
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        Cache cache = map.get(key);
        if (cache == null) {
            return -1;
        }
        int val = cache.value;
        //By providing custom comparator, we use usage and timestamp filed of Cache as key of the tree set.
        //So we should first remove from set, then change it, then add it back.
        set.remove(cache);
        cache.usage += 1;
        cache.timestamp = timestamp;
        timestamp++;
        set.add(cache);
        return val;
    }

    public void set(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (set.size() == capacity && !map.containsKey(key)) {//!map.containsKey(key) handles the case when the key already exits
            Cache cache = set.pollFirst();
            map.remove(cache.key);
        }
        if (map.containsKey(key)) {
            Cache cache = map.get(key);
            set.remove(cache);//should first remove from set, then change it
            cache.usage += 1;
            cache.timestamp = timestamp;
            timestamp++;
            cache.value = value;
            set.add(cache);
            return;
        }
        Cache cache = new Cache(key, 1, timestamp, value);
        timestamp++;
        set.add(cache);
        map.put(key, cache);
    }

    //if we only need two parameters, an int[] will do. But with 4, it's better to create a class, making code more readable
    private class Cache {
        int key;
        int usage;
        int timestamp;
        int value;

        public Cache(int key, int usage, int timestamp, int value) {
            this.key = key;
            this.usage = usage;
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
