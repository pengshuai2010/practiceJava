package lintCode;

/**
 * Created by shuaipeng on 2/2/17.
 */
public class Q600_SmallestRectangleEnclosingBlackPixels_BinarySearch {
    private static final char BLACK_PIXEL = '1';

    private static boolean hasBlackPixelVertically(char[][] image, int col) {
        int numRows = image.length;
        for (int row = 0; row < numRows; row++) {
            if (image[row][col] == BLACK_PIXEL) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasBlackPixelHorizontally(char[][] image, int row) {
        int numCols = image[0].length;
        for (int col = 0; col < numCols; col++) {
            if (image[row][col] == BLACK_PIXEL) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x:     the location of one of the black pixels
     * @param y:     the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0] == null
                || image[0].length == 0) {
            return 0;
        }
        int numRows = image.length;
        int numCols = image[0].length;
        // search for left boundary
        int start = 0;
        int end = y;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (hasBlackPixelVertically(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int leftBoundary = hasBlackPixelVertically(image, start) ? start : end;
        // find right boundary
        start = y;
        end = numCols - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (hasBlackPixelVertically(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int rightBoundary = hasBlackPixelVertically(image, end) ? end : start;
        // find upper boundary
        start = 0;
        end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (hasBlackPixelHorizontally(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int upperBoundary = hasBlackPixelHorizontally(image, start) ? start : end;
        // find lower boundary
        start = x;
        end = numRows - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (hasBlackPixelHorizontally(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int lowerBoundary = hasBlackPixelHorizontally(image, end) ? end : start;
        return (lowerBoundary - upperBoundary + 1) * (rightBoundary - leftBoundary + 1);
    }
}
