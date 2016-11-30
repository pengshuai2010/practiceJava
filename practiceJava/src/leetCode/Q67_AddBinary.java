package leetCode;

/**
 * Created by speng on 11/29/16.
 */
public class Q67_AddBinary {
    //questions to ask: are the strings guranteed to be not null/empty?
    // how long would the strings be? e.g. guranteed to be within the range in int/long, or unbounded?
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            if (b == null || b.length() == 0) {
                return "0";
            } else {
                return b;
            }
        } else if (b == null || b.length() == 0) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }
            carry = sum / 2;
            sum %= 2;
            sb.append((char) (sum + '0'));
        }
        if (carry > 0) {
            sb.append((char) (carry + '0'));
        }
        return sb.reverse().toString();
    }
}
