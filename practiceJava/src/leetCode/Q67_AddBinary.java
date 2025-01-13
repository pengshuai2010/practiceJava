package leetCode;

/**
 * Created by speng on 11/29/16.
 */
public class Q67_AddBinary {
    //questions to ask: are the strings guranteed to be not null/empty?
    // how long would the strings be? e.g. guranteed to be within the range in int/long, or unbounded?
    // leading zeros?
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int p1 = a.length() - 1, p2 = b.length() - 1; p1 >= 0 || p2 >= 0; p1--, p2--) {
            int binary1 = p1 >= 0 && a.charAt(p1) == '1' ? 1 : 0;
            int binary2 = p2 >= 0 && b.charAt(p2) == '1' ? 1 : 0;
            int sum = binary1 + binary2 + carry;
            carry = sum / 2;
            int remainder = sum % 2;
            sb.append(remainder);
        }
        if (carry > 0) {
            sb.append('1');
        }
        return  sb.reverse().toString();
    }
}
