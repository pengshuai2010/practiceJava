package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaipeng on 9/6/16.
 */
public class Q6zigZagConversion {
    public static void main(String[] args) {
        System.out.println(new Q6zigZagConversion().convert("PAYPALISHIRING", 3));
        System.out.println(new Q6zigZagConversion().convert("ABC", 2));
        System.out.println(new Q6zigZagConversion().convert("ABCD", 2));
    }

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 0)
            return "";
        if (numRows == 1)
            return s;
        int period = 2 * numRows - 2;
        List<StringBuilder> sbList = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            sbList.add(new StringBuilder());
        for (int i = 0; i < s.length(); i++) {
            int residuel = i % period;
            if (residuel < numRows)
                sbList.get(residuel).append(s.charAt(i));
            else
                sbList.get(period - residuel).append(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder substring : sbList)
            sb.append(substring);
        return sb.toString();
    }
}
