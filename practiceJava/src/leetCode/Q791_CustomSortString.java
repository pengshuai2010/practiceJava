package leetCode;

public class Q791_CustomSortString {
    public String customSortString(String order, String s) {
        // will order or s be null?
        // will characters in order be unique?
        // will s consist of only lower case English letters?

        // When characters in a string is from a smaller character set, and we need to sort it, then we can
        // use counting sort. The time complexity is O(n) where n is s.length()
        // if the character set is large, the overhead of counting sort is prohibitablly large,
        // then we need to sort the characters in input string using the order defined in the "order" string.
        if (order.isEmpty()) {
            return s;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            int index = ch - 'a';
            while (count[index] > 0) {
                sb.append(ch);
                count[index]--;
            }
        }
        // process letters not in "order" string
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            while (count[i] > 0) {
                sb.append(ch);
                count[i]--;
            }
        }
        return sb.toString();
    }
}
