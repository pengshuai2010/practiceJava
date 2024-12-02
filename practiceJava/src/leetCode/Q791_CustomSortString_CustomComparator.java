package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q791_CustomSortString_CustomComparator {
    public String customSortString(String order, String s) {
        // if the character set is large, e.g. UTF 8, the overhead of counting sort is prohibitablly large,
        // then we need to sort the characters in input string using the order defined in the "order" string.
        if (order.isEmpty()) {
            return s;
        }
        Map<Character, Integer> rank = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            rank.put(ch, i);
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        // Array.sort(primitive type array) doesn't support taking a Comparator as second argument
        list.sort((Character a, Character b) -> {
            int rankA = rank.getOrDefault(a, Integer.MAX_VALUE); // handle the case that a character is not in "order" string
            int rankB = rank.getOrDefault(b, Integer.MAX_VALUE);
            return rankA - rankB;
        });
        StringBuilder sb = new StringBuilder();
        for (Character ch : list) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
