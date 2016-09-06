package leetCode;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shuaipeng on 9/6/16.
 */
public class Q8stringToInteger {
    public static void main(String[] args) {
        System.out.println(new Q8stringToInteger().myAtoi(""));
        System.out.println(new Q8stringToInteger().myAtoi("    "));
        System.out.println(new Q8stringToInteger().myAtoi("1"));
        System.out.println(new Q8stringToInteger().myAtoi(" --12   "));
        System.out.println(new Q8stringToInteger().myAtoi(" -12-   "));
        System.out.println(new Q8stringToInteger().myAtoi(" -12a   "));
        System.out.println(new Q8stringToInteger().myAtoi(" +12a   "));
        System.out.println(new Q8stringToInteger().myAtoi(" 12a   "));
        System.out.println(new Q8stringToInteger().myAtoi("9223372036854775809"));
        System.out.println(new Q8stringToInteger().myAtoi("-9223372036854775809"));
    }

    // it is important to clarity with the interviewer:
    // will there be white spaces? base 10? invalid number? overflow?
    // can I use parseLong() or BigInteger?
    public int myAtoi2(String str) {
        if (str == null || str.length() == 0)
            return 0;
        String sb = str.trim();
        if (sb.length() == 0)
            return 0;
        char leadingCh = sb.charAt(0);
        if (leadingCh != '-' && leadingCh != '+' && !Character.isDigit(leadingCh))
            return 0;
        int endIndex = 1;
        while (endIndex < sb.length() && Character.isDigit(sb.charAt(endIndex)))
            endIndex++;
        if (!Character.isDigit(leadingCh) && endIndex == 1)
            return 0;
        BigInteger number = new BigInteger(sb.substring(0, endIndex));
        if (number.compareTo(new BigInteger(Integer.toString(Integer.MIN_VALUE))) < 0)
            return Integer.MIN_VALUE;
        if (number.compareTo(new BigInteger(Integer.toString(Integer.MAX_VALUE))) > 0)
            return Integer.MAX_VALUE;
        return number.intValue();
    }

    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        // the benefits of using regular expressions is that, when requirements change, we don't need to change the
        // the logic, only need to change the regex pattern
        Pattern p = Pattern.compile("\\s*([+-]?)(\\d+)[^\\d]*");
        Matcher m = p.matcher(str);
        if (!m.matches()) {
            System.out.println(str + ": invalid");
            return 0;
        }
        System.out.println(str + ":  " + m.group(1) + ", " + m.group(2));
        return 0;

    }
}
