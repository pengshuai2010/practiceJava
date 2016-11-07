package leetCode;

/**
 * Created by speng on 11/6/16.
 */
public class Q146_LRUCache_2 {
    private Entry[] buckets;
    private int capacity;
    private Entry head = new Entry();
    private Entry tail = new Entry();

    public Q146_LRUCache_2(int capacity) {
        if (capacity <= 0)
            throw new RuntimeException("capacity is not posive: " + capacity);
        this.capacity = capacity;
        buckets = new Entry[capacity];
        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new Entry();
        head.orderPrev = null;
        head.orderNext = tail;
        tail.orderPrev = head;
        tail.orderNext = null;
    }

    public static void main(String[] args) {
        Q146_LRUCache_2 map = new Q146_LRUCache_2(100);
        map.set(1, 5);
        map.set(1, 7);
        map.set(2, 8);
        map.set(3, 5);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.toString());
    }

    private int getIndex(int hashcode) {
        return Math.floorMod(hashcode, capacity);
    }

    public int get(int key) {
        int index = getIndex(key);
        Entry p = buckets[index].bucketNext;
        Entry q = buckets[index];
        while (p != null) {
            if (p.key.equals(key)) {
                return p.val;
            }
            p = p.bucketNext;
            q = q.bucketNext;
        }
        return -1;// as required by the problem description, use -1 to indicate not found
    }

    //TODO change insertion order to recently visited order
    public void set(int key, int value) {
        int index = getIndex(key);
        Entry p = buckets[index].bucketNext;
        Entry q = buckets[index];
        while (p != null) {
            if (p.key.equals(key)) {
                p.val = value;
                return;
            }
            p = p.bucketNext;
            q = q.bucketNext;
        }
        Entry entry = new Entry();
        entry.key = key;
        entry.val = value;
        q.bucketNext = entry;
        entry.bucketPrev = q;
        // update insert order linked list
        // there's a bug with IntelliJ debugger, it tries to dereference all points of doubly linked list, stuck in
        // infinite loop
        entry.orderPrev = tail.orderPrev;
        tail.orderPrev = entry;
        entry.orderPrev.orderNext = entry;
        entry.orderNext = tail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Entry p = head.orderNext;
        while (p.orderNext != null) {
            sb.append(p.key).append(": ").append(p.val).append(", ");
            p = p.orderNext;
        }
        sb.append('}');
        return sb.toString();
    }

    private class Entry {
        Integer key;
        Integer val;
        Entry bucketPrev;
        Entry bucketNext;
        Entry orderPrev;
        Entry orderNext;
    }
}
