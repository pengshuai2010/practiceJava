package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by speng on 9/8/16.
 */
public class Q13romanToInteger {
    public static void main(String[] args) {
        System.out.println(new Q13romanToInteger().romanToInt("MCMLXXXIV"));//1984
        System.out.println(new Q13romanToInteger().romanToInt("LXXXI"));//81
        System.out.println(new Q13romanToInteger().romanToInt("DCCVII"));//707
        System.out.println(new Q13romanToInteger().romanToInt("MMCCX"));//2210
//        System.out.println(new Q13romanToInteger().romanToInt("oihEFG"));//invalid

    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int num = 0;
        int lastVal = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            Integer tmp = map.get(s.charAt(i));
            if (tmp == null)
                return 0;
            int val = tmp;
//            int val = map.get(s.charAt(i));
            if (val < lastVal)
                num -= val;
            else
                num += val;
            lastVal = val;
        }
        return num;
    }
}
