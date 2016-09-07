package leetCode;

import java.math.BigInteger;

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
        System.out.println(new Q8stringToInteger().myAtoi("  -0012a42"));
        System.out.println(new Q8stringToInteger().myAtoi(Integer.toString(Integer.MAX_VALUE)));
        System.out.println(new Q8stringToInteger().myAtoi(Integer.toString(-Integer.MAX_VALUE)));
        System.out.println(new Q8stringToInteger().myAtoi(Integer.toString(Integer.MIN_VALUE)));
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

//        // the benefits of using regular expressions is that, when requirements change, we don't need to change the
//        // the logic, only need to change the regex pattern
//        Pattern p = Pattern.compile("\\s*([+-]?)(\\d+)[^\\d]*.*");
//        Matcher m = p.matcher(str);
//        if (!m.matches())
//            return 0;
//        boolean isNegative = false;
//        String signPart = m.group(1);
//        String numPart = m.group(2);

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
        String numPart;
        String signPart = "";
        if (Character.isDigit(leadingCh)) {
            numPart = sb.substring(0, endIndex);
        } else {
            numPart = sb.substring(1, endIndex);
            signPart = sb.substring(0, 1);
        }
        boolean isNegative = false;

        if (signPart != null && signPart.length() != 0 && signPart.charAt(0) == '-')
            isNegative = true;
        long number = 0;
        for (int i = 0; i < numPart.length(); i++) {
            int val = numPart.charAt(i) - '0';
            // another way to detect overflow is
            // "if (number > (Integer.MAX_VALUE - val)/10)" before we update number
            number = number * 10 + val;
            // note that MAX_VALUE is 2147483647, and MIN_VALUE is -2147483648
            // the absolute value of MAX_VALUE is 1 less than MIN_VALUE
            // so if we use "number >= Integer.MAX_VALUE" here, it will fail the input "-2147483647"
            if (number > Integer.MAX_VALUE)
                if (isNegative)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
        }
        if (isNegative)
            number = -number;
        return (int) number;
    }


}
