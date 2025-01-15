package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Q66_PlusOne {
    public int[] plusOne(int[] digits) {
        // will it be empty? since no sign, non-negative? guranteed to be digits?
        // Is it OK to modify the input?
        List<Integer> result = new ArrayList<>();
        int carry = 1; // plus 1
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            int sum = digit + carry;
            carry = sum / 10;
            result.add(sum % 10);
        }
        if (carry > 0) {
            result.add(carry);
        }
        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[result.size() - 1 - i]  = result.get(i);
        }
        return output;
    }
}
