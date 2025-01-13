package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q249_GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strings) {
            String hash = calculateHash(str);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(str);
        }
        // map.values() returns a Collection
        return new ArrayList<>(map.values());
    }

    private String calculateHash(String str) {
        if (str.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // in Java, modulo operation (% operator) can produce a negative result
            int remainder = (ch - str.charAt(0) + 26) % 26;
            sb.append((char)(remainder + 'a'));
        }
        return sb.toString();
    }
}
