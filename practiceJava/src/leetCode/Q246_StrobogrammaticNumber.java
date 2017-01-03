package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by speng on 1/3/17.
 */
public class Q246_StrobogrammaticNumber {
    public boolean isStrobogrammatic1(String num) {
        if (num == null) {
            throw new java.lang.IllegalArgumentException();
        }
        //ask interview: is it guaranteed all digits in the string num?
        if (num.length() == 0) {
            return true;
        }
        char[] table = new char[10];
        Arrays.fill(table, 'a');
        table[0] = '0';
        table[1] = '1';
        table[6] = '9';
        table[8] = '8';
        table[9] = '6';
        //need i <= j instead of i < j to handle corner cases like "2"
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if (num.charAt(i) != table[num.charAt(j) - '0']) {
                return false;
            }
        }
        return true;
    }

    public boolean isStrobogrammatic(String num) {
        if (num == null) {
            throw new java.lang.IllegalArgumentException();
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if (!map.containsKey(num.charAt(j)) || num.charAt(i) != map.get(num.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
