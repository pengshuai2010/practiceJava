package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 11/12/16.
 */
public class Q43_MultiplyStrings {
    public static void main(String[] args) {
        Q43_MultiplyStrings solution = new Q43_MultiplyStrings();
        System.out.println(solution.multiply("0", "0"));
    }

    public String multiply1(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0)
            return "";
        List<String> nums = new ArrayList<>();
        num1 = reverseString(num1);
        num2 = reverseString(num2);
        for (int i = 0; i < num2.length(); i++) {
            int d2 = num2.charAt(i) - '0';
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++)
                sb.append('0');
            for (int j = 0; j < num1.length(); j++) {
                int d1 = num1.charAt(j) - '0';
                int res = d1 * d2 + carry;
                carry = res / 10;
                sb.append((char) (res % 10 + '0'));
            }
            if (carry > 0)
                sb.append((char) (carry + '0'));
            nums.add(sb.toString());
        }
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.get(nums.size() - 1).length(); i++) {
            int res = carry;
            for (int j = nums.size() - 1; j >= 0; j--) {
                if (nums.get(j).length() <= i)
                    break;
                res += nums.get(j).charAt(i) - '0';
            }
            carry = res / 10;
            sb.append((char) (res % 10 + '0'));
        }
        if (carry > 0)
            sb.append((char) (carry + '0'));
        return sb.toString();
    }

    private String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0)
            return "";
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + pos[i + j + 1];
                pos[i + j] += sum / 10;
                pos[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : pos) {
            if (sb.length() == 0 && digit == 0)
                continue;// skip leading 0's
            sb.append(digit);//digit will be cast to string implicitly
        }
        if (sb.length() == 0)
            sb.append("0");
        return sb.toString();
    }
}
