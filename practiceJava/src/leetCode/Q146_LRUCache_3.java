package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * a better implementation of LRU Cache than Q146_LRUCache_2. Here we make use of existing Java API data structure
 * HashMap, use doubly linked list node as the value to be stored in the hash map.
 * This implementation use doubly linked list on top of HashMap, so we don't need to concern about the implementation
 * of hash map. And it is also fast because the HashMap in Java API is better than our home-made hash map implementation.
 * Created by shuaipeng on 11/7/16.
 */
public class Q146_LRUCache_3 {
    private int capacity;
    private int size;
    private DLinkedNode head;
    private DLinkedNode tail;
    private Map<Integer, DLinkedNode> map;

    public Q146_LRUCache_3(int capacity) {
        if (capacity <= 0)
            throw new RuntimeException("capacity is not posive: " + capacity);
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        Q146_LRUCache_3 cache = new Q146_LRUCache_3(1);
        cache.set(0, 2);
        System.out.println(cache.get(0));
        System.out.println(cache.toString());
        cache.set(1, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.toString());
        cache.set(2, 0);
        System.out.println(cache.get(2));
        System.out.println(cache.toString());
        cache.set(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.toString());
        cache.set(1, 2);
        System.out.println(cache.get(1));
        cache.set(1, 3);
        System.out.println(cache.get(1));
        System.out.println(cache.toString());
        System.out.println(cache.size());

    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            removeFromDLinkedList(node);
            addToDLinkedList(node);
            return node.val;
        }
    }

    public void set(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            while (size >= capacity) {
                DLinkedNode eldest = head.next;
                removeFromDLinkedList(eldest);
                map.remove(eldest.key);
                size--;
            }
            node = new DLinkedNode();
            node.key = key;
            node.val = value;
            addToDLinkedList(node);
            map.put(key, node);
            size++;
        } else {
            node.val = value;
            removeFromDLinkedList(node);
            addToDLinkedList(node);
        }
    }

    private void addToDLinkedList(DLinkedNode node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        node.prev.next = node;
    }

    private void removeFromDLinkedList(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        DLinkedNode p = head.next;
        while (p.next != null) {
            sb.append(p.key).append(": ").append(p.val).append(", ");
            p = p.next;
        }
        sb.append("}");
        return sb.toString();
    }

    public int size() {
        return size;
    }

    private class DLinkedNode {
        DLinkedNode prev;
        DLinkedNode next;
        int key;
        int val;
    }
}
