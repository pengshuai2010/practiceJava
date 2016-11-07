package leetCode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * make use of existing Java API data structure LinkedHashMap
 * Created by speng on 11/6/16.
 */
public class Q146_LRUCache_1 extends LinkedHashMap<Integer, Integer> {
    int capacity;

    public Q146_LRUCache_1(int capacity) {
        super(capacity, 0.5f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer res = super.get(key);
        if (res == null)
            return -1;
        else
            return res;
    }

    public void set(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}
