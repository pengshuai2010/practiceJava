package leetCode;

/**
 * implements LinkedHashMap from scratch. Capacity is fixed. When a new entry is added and size has reached capacity, the
 * least recently used entry will be removed.
 * Created by speng on 11/6/16.
 */
public class Q146_LRUCache_2 {
    private static int MIN_NUM_BUCKETS = 16;
    private int size;
    private Entry[] buckets;
    private int capacity;
    private Entry head = new Entry();// dummy head of order linked list
    private Entry tail = new Entry();// dummy tail of order linked list

    public Q146_LRUCache_2(int capacity) {
        if (capacity <= 0)
            throw new RuntimeException("capacity is not posive: " + capacity);
        this.capacity = capacity;
        size = 0;
        int numBuckets = Math.max(capacity * 2, MIN_NUM_BUCKETS);
        buckets = new Entry[numBuckets];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Entry();
            Entry dummyTail = new Entry();
            buckets[i].bucketNext = dummyTail;
            dummyTail.bucketPrev = buckets[i];
        }
        head.orderPrev = null;
        head.orderNext = tail;
        tail.orderPrev = head;
        tail.orderNext = null;
    }

    public static void main(String[] args) {
//        Q146_LRUCache_2 map = new Q146_LRUCache_2(4);
//        map.set(1, 5);
//        map.set(1, 7);
//        map.set(2, 8);
//        map.set(3, 5);
//        System.out.println(map.get(1));
//        System.out.println(map.get(2));
//        map.set(3, 9);
//        System.out.println(map.toString());
//        System.out.println(map.size());
//        map.set(4, 11);
//        System.out.println(map.toString());
//        System.out.println(map.size());
//        map.set(5, 23);
//        System.out.println(map.toString());
//        System.out.println(map.size());

        Q146_LRUCache_2 map = new Q146_LRUCache_2(1);
        map.set(0, 2);
        System.out.println(map.get(0));
        map.set(1, 1);
        System.out.println(map.get(1));
        map.set(2, 0);
        System.out.println(map.get(2));
        map.set(3, 2);
        System.out.println(map.get(3));
        map.set(1, 2);
        System.out.println(map.get(1));
        map.set(1, 3);
        System.out.println(map.get(1));
        System.out.println(map.toString());
        System.out.println(map.size());
    }

    private int getIndex(int hashcode) {
        return Math.floorMod(hashcode, capacity);
    }

    public int get(int key) {
        int index = getIndex(key);
        Entry p = buckets[index].bucketNext;
        Entry q = buckets[index];
        while (p.bucketNext != null) {// because last node is dummy tail
            if (p.key.equals(key)) {
                // take this node out from order linked list, then add it before tail
                // won't affect the bucket linked list
                removeFromOrderLinkedList(p);
                addToOrderLinkedList(p);
                return p.val;
            }
            p = p.bucketNext;
            q = q.bucketNext;
        }
        return -1;// as required by the problem description, use -1 to indicate not found
    }

    private void removeFromOrderLinkedList(Entry entry) {
        entry.orderPrev.orderNext = entry.orderNext;
        entry.orderNext.orderPrev = entry.orderPrev;
        entry.orderPrev = null;
        entry.orderNext = null;
    }

    private void removeFromBucketLinkedList(Entry entry) {
        entry.bucketPrev.bucketNext = entry.bucketNext;
        entry.bucketNext.bucketPrev = entry.bucketPrev;
        entry.bucketPrev = null;
        entry.bucketNext = null;
    }

    private void addToOrderLinkedList(Entry entry) {
        entry.orderPrev = tail.orderPrev;
        tail.orderPrev = entry;
        entry.orderPrev.orderNext = entry;
        entry.orderNext = tail;
    }

    public void set(int key, int value) {
        int index = getIndex(key);
        Entry p = buckets[index].bucketNext;
        Entry q = buckets[index];
        while (p.bucketNext != null) {// because last node is dummy tail
            if (p.key.equals(key)) {
                p.val = value;
                removeFromOrderLinkedList(p);
                addToOrderLinkedList(p);
                return;
            }
            p = p.bucketNext;
            q = q.bucketNext;
        }
        while (size >= capacity) {
            // remove the eldest
            Entry eldest = head.orderNext;
            if (eldest != null) {
                removeFromOrderLinkedList(eldest);
                removeFromBucketLinkedList(eldest);
                size--;
            }
        }
        Entry entry = new Entry();
        entry.key = key;
        entry.val = value;
        addToBucket(index, entry);
        // update insert order linked list
        // there's a bug with IntelliJ debugger, it tries to dereference all points of doubly linked list, stuck in
        // infinite loop
        addToOrderLinkedList(entry);
        size++;
    }

    private void addToBucket(int index, Entry entry) {
        entry.bucketNext = buckets[index].bucketNext;
        entry.bucketPrev = buckets[index];
        entry.bucketNext.bucketPrev = entry;
        buckets[index].bucketNext = entry;
    }

    public int size() {
        return size;
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
