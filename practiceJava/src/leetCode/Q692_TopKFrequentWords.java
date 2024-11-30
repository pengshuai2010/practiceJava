package leetCode;

import java.util.*;

public class Q692_TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        // clarify: will words be null or empty? Is k granteed to be k <= number of unique words?
        // is k guranteed k > 0?
        Map<String, Item> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, new Item(word, 0));
            }
            map.get(word).count++;
        }
        PriorityQueue<Item> pq = new PriorityQueue<>(map.values());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.remove().word);
        }
        return result;
    }

    private static class Item implements Comparable<Item> {
        String word;
        int count; // ommit getter and setters

        Item(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Item other) {
            if (this.count != other.count) {
                return other.count - this.count; // descending order
            }
            return this.word.compareTo(other.word); // lexicographical order
        }
    }
}
