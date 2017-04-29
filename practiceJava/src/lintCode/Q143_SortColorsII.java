package lintCode;

import java.util.Arrays;

/**
 * Created by speng on 4/28/17.
 */
public class Q143_SortColorsII {
    /**
     * @param colors: A list of integer
     * @param k:      An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }
        int[] count = new int[k + 1];
        for (int color : colors) {
            count[color]++;
        }
        int index = 0;
        for (int i = 1; i <= k; i++) {
            Arrays.fill(colors, index, index + count[i], i);
            index += count[i];
        }
    }
}
