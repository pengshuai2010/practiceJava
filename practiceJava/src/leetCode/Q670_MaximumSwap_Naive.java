package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Q670_MaximumSwap_Naive {
    public int maximumSwap(int num) {
        if (num < 12) {
            return num;
        }
        // lower bits at front
        List<Integer> digits = getDigits(num);
        int[] count = getCount(digits);
        List<Integer> maxDigits = buildMaxDigits(count);
        int digitToSwapOut = -1;
        int digitToSwapIn = -1;
        for (int i = digits.size() - 1; i >= 0; i--) {
            if (!Objects.equals(digits.get(i), maxDigits.get(i))) {
                digitToSwapOut = digits.get(i);
                digitToSwapIn = maxDigits.get(i);
                break;
            }
        }
        if (digitToSwapOut == -1) {
            return num;
        }
        for (int i = 0; i < digits.size(); i++) {
            if (digits.get(i) == digitToSwapIn) {
                digits.set(i, digitToSwapOut);
                break;
            }
        }
        for (int i = digits.size() - 1; i >= 0; i--) {
            if (digits.get(i) == digitToSwapOut) {
                digits.set(i, digitToSwapIn);
                break;
            }
        }
        return buildNumber(digits);
    }

    private List<Integer> getDigits(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            int digit = num % 10;
            list.add(digit);
            num /= 10;
        }
        return list;
    }

    private int[] getCount(List<Integer> digits) {
        int[] count = new int[10];
        for (int digit: digits) {
            count[digit]++;
        }
        return count;
    }

    private List<Integer> buildMaxDigits(int[] count) {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                digits.add(i);
                count[i]--;
            }
        }
        return digits;
    }

    private int buildNumber(List<Integer> digits) {
        int num = 0;
        int factor = 1;
        for (int digit : digits) {
            num += digit * factor;
            factor *= 10;
        }
        return num;
    }
}
