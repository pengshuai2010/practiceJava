package leetCode;

/**
 * Created by speng on 12/14/16.
 */
public class Q338_CountingBits {
    public int[] countBits1(int num) {
        int[] ones = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ones[i] = countOnes(i);
        }
        return ones;
    }

    /**
     * takes O(k) time to find out number of 1 bits, where k is the number of 1 bits in the number
     */
    private int countOnes(int num) {
        int count = 0;
        while (num > 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    /**
     * define f(x) as number of 1 bits in the number x
     * then f(x) = f(x >> 1) + (x & 1)
     * initally, f(0) = 0
     */
    public int[] countBits(int num) {
        int[] ones = new int[num + 1];
        ones[0] = 0;
        for (int i = 0; i <= num; i++) {
            ones[i] = ones[i >> 1] + (i & 1);
        }
        return ones;
    }
}
