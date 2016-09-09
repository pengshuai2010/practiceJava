package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by speng on 9/7/16.
 */
public class Q12integerToRoman {
    public static void main(String[] args) {
        System.out.println(new Q12integerToRoman().intToRoman(0));
        System.out.println(new Q12integerToRoman().intToRoman(9));
        System.out.println(new Q12integerToRoman().intToRoman(16));
        System.out.println(new Q12integerToRoman().intToRoman(19));
        System.out.println(new Q12integerToRoman().intToRoman(26));
        System.out.println(new Q12integerToRoman().intToRoman(78));
        System.out.println(new Q12integerToRoman().intToRoman(101));
        System.out.println(new Q12integerToRoman().intToRoman(199));
        System.out.println(new Q12integerToRoman().intToRoman(1984));
    }

    public String intToRoman(int num) {
        if (num <= 0 || num > 3999)
            return "";
        List<List<String>> table = new ArrayList<>();
        table.add(Arrays.asList("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"));
        table.add(Arrays.asList("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"));
        table.add(Arrays.asList("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"));
        table.add(Arrays.asList("", "M", "MM", "MMM"));
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (int tmp = num; tmp != 0; tmp /= 10) {
            int val = tmp % 10;
            sb.insert(0, table.get(counter).get(val));
            counter++;
        }
        return sb.toString();
    }
}
