package leetCode;

/**
 * Created by speng on 12/11/16.
 */
public class Q393_UTF8Validation {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }
        int n = 0;
        for (int i = 0; i < data.length; i++) {
            if (n == 0) {
                n = getLeadingOnes(data[i]);
                if (n == 1 || n > 4) {// handle [10...] and [11111...]
                    return false;
                }
                n = (n == 0) ? 1 : n;
            } else {
                if (getLeadingOnes(data[i]) != 1) {//handle [110..., 0...]
                    return false;
                }
            }
            n--;
        }
        return 0 == n;//handle [110...]
    }

    private int getLeadingOnes(int data) {
        int mask = 1 << 7;
        int n = 0;
        while ((data & mask) > 0) {//note that bitwise operators have low priority!
            n++;
            data <<= 1;
        }
        return n;
    }
}
