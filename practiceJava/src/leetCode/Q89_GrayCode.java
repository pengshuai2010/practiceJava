package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 12/5/16.
 */
public class Q89_GrayCode {
    /**
     * compare binary number [0, n - 1] and n-bit gray code, we find that if use binary number as input,
     * each bit is reversed if its higher bit is 1, so comes  i ^ (i >> 1)
     */
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        if (n < 0) {
            return list;
        }
        for (int i = 0; i < 1 << n; i++) {
            list.add(i ^ (i >> 1));
        }
        return list;
    }
}
