package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by speng on 12/11/16.
 */
public class Q288_UniqueWordAbbreviation {
    private Map<String, Boolean> map;
    private Set<String> set;

    /**
     * After reading the problem, state the problem in your words to the interviewer to make sure your understanding is correct.
     * And ask about how to handle corner cases.
     * In this problem, "A word's abbreviation is unique if no *other* word from the dictionary has the same abbreviation" is subtle.
     * if a word is in the dictionary, "unique" means no other words in the dictionary have the same abbrevation;
     * else, "unique" means no words in the dictionary have the same abbrevation;
     * <p>
     * Another solution that only use one HashMap
     * We can use only one Map<String, String>.
     * if (map.containsKey(abbr)) {
     * map.put(abbr, "");
     * } else {
     * map.put(abbr, word);
     * }
     * <p>
     * isUnique(String word) {
     * // map.get(abbr) returns null means this word or any word with same abbrevation is not in the dictionary, so it's unique
     * returns a string equals to this word means this word is in the ditionary and there's no other word in the dictionay that has same abbrevation
     * return "" means two words in the dictionary have same abbrevation with this word
     * return map.get(abbr) == null || map.get(abbr).equals(word)
     * }
     */
    public Q288_UniqueWordAbbreviation(String[] dictionary) {
        if (dictionary == null) {
            throw new RuntimeException("invalid input");
        }
        set = new HashSet<>();
        for (String word : dictionary) {
            set.add(word);
        }
        map = new HashMap<>();
        for (String word : set) {
            String abbr = getAbbr(word);
            if (map.containsKey(abbr)) {
                map.put(abbr, false);
            } else {
                map.put(abbr, true);
            }
        }
    }

    private String getAbbr(String word) {
        if (word.length() < 3) {
            return word;
        }
        return word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
    }

    public boolean isUnique(String word) {
        if (set.contains(word)) {
            return map.get(getAbbr(word));
        }
        return map.get(getAbbr(word)) == null;
    }
}
