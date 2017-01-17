package lintCode;

/**
 * Created by speng on 1/16/17.
 */
public class Q447_SearchInABigSortedArray {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        if (reader == null) {
            return -1;
        }
        if (reader.get(0) == target) {
            return 0;
        }
        int high = 1;
        while (reader.get(high) < target) {
            high *= 2;
        }
        int low = high / 2;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            int midValue = reader.get(mid);
            if (midValue < target) {
                low = mid + 1;
            } else if (midValue > target) {
                high = mid - 1;
            } else {
                high = mid;
            }
        }
        if (reader.get(low) == target) {
            return low;
        }
        if (reader.get(high) == target) {
            return high;
        }
        return -1;
    }

    private class ArrayReader {
        // get the number at index, return -1 if index is less than zero.
        public int get(int index) {
            return 0;//just a place holder to get rid of error message from IDE
        }
    }
}
