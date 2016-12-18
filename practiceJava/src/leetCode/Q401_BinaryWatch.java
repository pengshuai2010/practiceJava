package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 12/17/16.
 */
public class Q401_BinaryWatch {
    /**
     * The idea behind this solution is simple: for all combinations of hours and minutes(12*60 in total),
     * getOneBits(hour) + getOneBits(minute) == num.
     * <p>
     * Another solution is circular shifting bit mask, e.g. circular shift 0b1100, 0b1010 and bitwise & with 0b1111, but
     * that's an overkill.
     * <p>
     * If we want fastest solution, we can hard code all answers.
     */
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        if (num < 0 || num > 10) {
            return list;
        }
        int[] numOneBits = new int[60];//avoid duplicate calculation
        for (int i = 0; i < 60; i++) {
            numOneBits[i] = getOneBits(i);
        }
        for (int hour = 0; hour < 12; hour++) {
            int bits = numOneBits[hour];
            if (bits > num) {//trim
                continue;
            }
            for (int minute = 0; minute < 60; minute++) {
                if (bits + numOneBits[minute] == num) {
                    list.add(getTimeString(hour, minute));
                }
            }
        }
        return list;
    }

    private int getOneBits(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

    private String getTimeString(int hour, int minute) {
        return hour + ":" + (minute < 10 ? "0" + minute : minute);
    }
}
