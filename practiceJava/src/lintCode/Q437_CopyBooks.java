package lintCode;

/**
 * Created by shuaipeng on 1/7/17.
 */
public class Q437_CopyBooks {
    /**
     * @param pages: an array of integers
     * @param k:     an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        if (pages == null || pages.length == 0 || k < 1) {
            return -1;
        }
        int low = 0, high = 0;
        for (int num : pages) {
            low = Math.max(low, num);
            high += num;
        }
        //we don't really need to narrow the interval down to 1, 2 is enough. After while loop we will check low and high
        //When there's "low = mid" or "high = mid", if not handled properly, it may cause dead loop. By only narrowing
        //down to interval of 2, we make it easier to deal with such case.
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (canFinish(pages, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        //note that since we want minimum time, we should check low first
        if (canFinish(pages, k, low)) {
            return low;
        }
        return high;
    }

    /**
     * check if k people can finish copying the books in t time.
     * Let each person try to copy as many books as possible in t time, and see how many people is need.
     */
    private boolean canFinish(int[] pages, int k, int t) {
        int people = 1;
        int total = 0;
        for (int num : pages) {
            total += num;
            if (total > t) {
                total = num;
                people++;
            }
        }
        return people <= k;
    }
}
