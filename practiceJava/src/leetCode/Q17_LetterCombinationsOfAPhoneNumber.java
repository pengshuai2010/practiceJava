package leetCode;

import java.util.*;

/**
 * Created by speng on 11/6/16.
 */
public class Q17_LetterCombinationsOfAPhoneNumber {
    // ask interviewer how to deal with 0 and 1

    public static void main(String[] args) {
        Q17_LetterCombinationsOfAPhoneNumber solution = new Q17_LetterCombinationsOfAPhoneNumber();
        String[] inputs = new String[]{null, "", "23", "123", "231"};
        for (String input : inputs) {
            System.out.println(input);
            System.out.println(solution.letterCombinations(input));
        }
    }

    //using dfs
    public List<String> letterCombinations1(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return combinations;
        Map<Character, String> map = new HashMap<>();
        map.put('0', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(digits, 0, new StringBuilder(), combinations, map);
        return combinations;
    }

    private void dfs(String digits, int index, StringBuilder sb, List<String> combinations, Map<Character, String> map) {
        if (index >= digits.length()) {
            combinations.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            dfs(digits, index + 1, sb, combinations, map);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }

    //using bfs
    public List<String> letterCombinations(String digits) {
        Queue<String> queue = new LinkedList<>();
        if (digits == null || digits.length() == 0)
            return (List<String>) queue;
        Map<Character, String> map = new HashMap<>();
        map.put('0', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        queue.add("");
        // bfs, traverse by layer
        for (int i = 0; i < digits.length(); i++) {
            String letters = map.get(digits.charAt(i));
            Queue<String> layer = new LinkedList<>();
            while (!queue.isEmpty()) {
                String partial = queue.poll();
                for (int j = 0; j < letters.length(); j++)
                    layer.offer(partial + letters.charAt(j));
            }
            queue = layer;
        }
        return (List<String>) queue;
    }
}
