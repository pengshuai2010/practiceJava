package leetCode;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 * <p>
 * Ask interview if
 */
public class Q362_DesignHitCounter {
    /**
     * It's important to ask if hit counts 300 seconds ago will be queried(i.e. if we need to keep hit counts 300 seconds ago),
     * and if we only need to consider fixed time windows of 300 seconds.Because we can do significant optimization based
     * on this assumption.
     * <p>
     * Use a tree map or a skip list, adding a new hit takes O(log(n)) time; querying hit count takes O(log(n) + m) time,
     * log(n) for finding the submap, O(m) for adding up hits in worst case when there are hits every second;
     * where n is number of unique timestamps so far, m is the size of time window. So even if there are many hits per
     * second, performance won't deteriorate. This solution provides flexibility with time window.
     * <p>
     * Another option is to use an array of length m, adding a new hit takes O(1) time, querying hit count takes O(m) time,
     * where m is the size of time window. This solution performs better, but lacks flexibility with time window.
     * <p>
     * Using a linkedHashMap can also get O(1) time adding new hits.
     */
    public class HitCounter1 {
        private SortedMap<Integer, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public HitCounter1() {
            // Both TreeMap and skip list take O(log(n)) time to get, put, remove, get submap
            map = new TreeMap<>();
//            map = new ConcurrentSkipListMap<>();
        }

        /**
         * Record a hit.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public void hit(int timestamp) {
            Integer val = map.get(timestamp);
            if (val == null) {
                map.put(timestamp, 1);
            } else {
                //save some time compared to map.put(timestamp, map.get(timestamp) + 1)
                map.put(timestamp, val + 1);
            }
        }

        /**
         * Return the number of hits in the past 5 minutes.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public int getHits(int timestamp) {
            int seconds = 300;
            int start = timestamp - seconds + 1;
            start = start < 0 ? 0 : start;
            Map<Integer, Integer> view = map.subMap(start, timestamp + 1);
            int hitCount = 0;
            for (int val : view.values()) {//for a SortedMap, use values() to iterate takes O(n) time; use keySet() to iterate over values takes O(n*log(n)) time
                hitCount += val;
            }
            return hitCount;
        }
    }

    public class HitCounter {
        private int[] count;
        private int[] time;

        /**
         * Initialize your data structure here.
         */
        public HitCounter() {
            count = new int[300];
            time = new int[300];
        }

        /**
         * Record a hit.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public void hit(int timestamp) {
            // the assumption is that timestamp starts from 1
            int index = timestamp % 300;
            if (time[index] == timestamp) {
                count[index]++;
            } else {
                time[index] = timestamp;
                count[index] = 1;
            }
        }

        /**
         * Return the number of hits in the past 5 minutes.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public int getHits(int timestamp) {
            int hitCount = 0;
            for (int i = 0; i < time.length; i++) {
                if (time[i] > 0 && time[i] > timestamp - 300 && time[i] <= timestamp) {
                    hitCount += count[i];
                }
            }
            return hitCount;
        }
    }

}
