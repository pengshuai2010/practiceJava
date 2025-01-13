package leetCode;

public class Q415_AddStrings {
    public String addStrings(String num1, String num2) {
        // will there be leading zeros? empty string?
        // will num1 or num2 be negative?
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int p1 = num1.length() - 1, p2 = num2.length() - 1; p1 >= 0 || p2 >= 0; p1--, p2--) {
            int digit1 = 0;
            int digit2 = 0;
            if (p1 >= 0) {
                digit1 = num1.charAt(p1) - '0';
            }
            if (p2 >= 0) {
                digit2 = num2.charAt(p2) - '0';
            }
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            sb.append(remainder); // stringBuilder.append(int) will append the string representation of int
        }
        if (carry > 0) {
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }
}
