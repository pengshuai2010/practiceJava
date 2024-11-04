package other;

import java.util.HashMap;
import java.util.Map;

public class MapWithTTL {
    private final Map<String, String> map;
    private final Map<String, Long> expiryTimeMillis;

    public MapWithTTL() {
        this.map = new HashMap<>();
        this.expiryTimeMillis = new HashMap<>();
    }

    public void put(String key, String value, long ttlMillis) {
        this.expiryTimeMillis.put(key, System.currentTimeMillis() + ttlMillis);
        this.map.put(key, value);
    }

    public String get(String key) {
        if (this.containsKey(key)) {
            return this.map.get(key);
        }
        return null;
    }

    public boolean containsKey(String key) {
        if (!this.map.containsKey(key)) {
            return false;
        }
        if (this.expiryTimeMillis.get(key) > System.currentTimeMillis()) {
            this.expiryTimeMillis.remove(key);
            this.map.remove(key);
        }
        return this.map.containsKey(key);
    }

    public int size() {
        return this.map.size();
    }
}
