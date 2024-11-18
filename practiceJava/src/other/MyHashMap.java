package other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Entry {
    int key;
    int value; // omit getters and setters.

    Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    private static final int SIZE = 31;
    private final List<List<Entry>> table;

    public MyHashMap() {
        this.table = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            this.table.add(new LinkedList<>());
        }
    }

    private static int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        List<Entry> list = this.table.get(index);
        for (Entry entry : list) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        list.add(new Entry(key, value));
    }

    public int get(int key) {
        int index = hash(key);
        for (Entry entry : this.table.get(index)) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Iterator<Entry> iterator = this.table.get(index).iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.key == key) {
                iterator.remove();
                return;
            }
        }
    }
}
