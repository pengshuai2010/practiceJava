package leetCode;

/**
 * Created by speng on 11/25/16.
 */
public class Q190_ReverseBits {
    public static void main(String[] args) {
        Q190_ReverseBits solution = new Q190_ReverseBits();
        int[] inputs = new int[]{0b100100, 0b1111111111111111111111111011011, 0b1111111111111111111111111111111,
                0b0, 0b1, 0b00000010100101000001111010011100};
        for (int num : inputs)
            System.out.println(Integer.toBinaryString(solution.reverseBits(num)));// note that leading 0's will be omitted
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if ((n & 1) > 0)
                res++;
            n >>= 1;
        }
        return res;
    }
}
